package com.finanzas.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.entities.Contrato;
import com.finanzas.entities.Flujo;
import com.finanzas.entities.Resultado;
import com.finanzas.entities.Irr;
import com.finanzas.entities.FinanceLib;


import com.finanzas.repository.ContratoRepository;
import com.finanzas.repository.ResultadoRepository;
import com.finanzas.service.ResultadoService;
@Service
public class ResultadoServiceImpl implements ResultadoService {
	
	@Autowired
	private ResultadoRepository resultadoRepository;
	@Autowired
	private ContratoRepository contratoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Resultado> findAll() throws Exception {
		return resultadoRepository.findAll();
	}

	@Transactional
	@Override
	public Resultado save(Resultado t) throws Exception {
		return resultadoRepository.save(t);
	}
	
	@Transactional
	@Override
	public Resultado update(Resultado t) throws Exception {
		return resultadoRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Resultado> findById(Integer id) throws Exception {
		return resultadoRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		resultadoRepository.deleteById(id);

	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Transactional(readOnly = true)
	@Override
	public Resultado fecthResultados(int id) throws Exception {
		Resultado aux = new Resultado();
		
		List<Flujo> listaflujos = new ArrayList<>();
		
		Optional<Contrato> c2 = contratoRepository.findById(id);
		
		Contrato c =  c2.get();
		
		c.setPorcentajeIGV(0.18);

		double IGV = (c.getPrecioVenta() / (1 + c.getPorcentajeIGV()) * c.getPorcentajeIGV());

		double ValorVenta = (c.getPrecioVenta() - IGV);

		double MontoLeasing = (ValorVenta + c.getCostesNotariales() + c.getCostesRegistrales() + c.getTasacion()
				+ c.getComisionEstudio() + c.getComisionActivacion());

		double PorcentajeTEP = (Math.pow((1 + c.getPorcentajeTEA()),
				(c.getFrecuenciaDePago() / c.getNumeroDiasPorAnno())) - 1);

		double NumeroCuotasAnno = (c.getNumeroDiasPorAnno() / c.getFrecuenciaDePago());

		double NumeroTotalCuotas = (NumeroCuotasAnno * c.getNumeroAnnos());

		double SeguroRiesgo = (c.getPorcentajeSeguroRiesgo() * c.getPrecioVenta() / NumeroCuotasAnno);
		
		aux.setIgv((c.getPrecioVenta() / (1 + c.getPorcentajeIGV()) * c.getPorcentajeIGV()));  

		aux.setValorVenta((c.getPrecioVenta() - IGV)); 

		aux.setMontoLeasing((ValorVenta + c.getCostesNotariales() + c.getCostesRegistrales() + c.getTasacion()
		+ c.getComisionEstudio() + c.getComisionActivacion())); 

		aux.setPorcentajeTEP((Math.pow((1 + c.getPorcentajeTEA()),
				(c.getFrecuenciaDePago() / c.getNumeroDiasPorAnno())) - 1)); 

		aux.setNumeroCuotasAnno((c.getNumeroDiasPorAnno() / c.getFrecuenciaDePago()));

		aux.setNumeroTotalCuotas((NumeroCuotasAnno * c.getNumeroAnnos())); 

		aux.setSeguroRiesgo((c.getPorcentajeSeguroRiesgo() * c.getPrecioVenta() / NumeroCuotasAnno));

		int numfila = 1;

		Flujo flujo = new Flujo();

		Flujo flujoaux = new Flujo();
		
		double[] arraydouble = new double[(int) (NumeroCuotasAnno * c.getNumeroAnnos())];
		double[] arraydoubleN = new double[(int) (NumeroCuotasAnno * c.getNumeroAnnos())];
		double[] arraydoubleI = new double[(int) (NumeroCuotasAnno * c.getNumeroAnnos())];
		double[] arraydoubleA = new double[(int) (NumeroCuotasAnno * c.getNumeroAnnos())];
		double[] arraydoubleS = new double[(int) (NumeroCuotasAnno * c.getNumeroAnnos())];
		double[] arraydoubleC = new double[(int) (NumeroCuotasAnno * c.getNumeroAnnos())];
		double[] arraydoubleR = new double[(int) (NumeroCuotasAnno * c.getNumeroAnnos())];
		double[] arraydoubleD = new double[(int) (NumeroCuotasAnno * c.getNumeroAnnos())];


		int indice = 0;

		for (int i = 0; i < NumeroTotalCuotas; i++) {
			flujo = new Flujo();
			flujo.setSeguroRiesgo(SeguroRiesgo);
			flujo.setPlazoGracia(c.getPlazogracia());
			
			if (numfila == 1) {
				flujo.setSaldoInicial(MontoLeasing);
				flujo.setInteres(flujo.getSaldoInicial() * -1 * PorcentajeTEP);
				if (c.getPlazogracia().equals("T")  && numfila <= c.getNumeroCuotasPG()) {
					flujo.setCuota(0);
					flujo.setAmortizacion(0);
					flujo.setSaldoFinal(flujo.getSaldoInicial() - flujo.getInteres());
				}
				if (c.getPlazogracia().equals("P")  && c.getNumeroCuotasPG() >= numfila) {
					flujo.setCuota(flujo.getInteres());
					flujo.setAmortizacion(0);
					flujo.setSaldoFinal(flujo.getSaldoInicial());

				}
				if (c.getNumeroCuotasPG() < numfila) {
					flujo.setPlazoGracia("S");
					flujo.setAmortizacion(-1 * flujo.getSaldoInicial() / (NumeroTotalCuotas - numfila + 1));
					flujo.setCuota(flujo.getInteres() + flujo.getAmortizacion());
					flujo.setSaldoFinal(flujo.getSaldoInicial() + flujo.getAmortizacion());
					
				}
				flujo.setSeguroRiesgo(flujo.getSeguroRiesgo() * -1);
				flujo.setComision(c.getComisionPeriodica() * -1);
				flujo.setDepreciacion(ValorVenta / NumeroTotalCuotas * -1);
				flujo.setAhorroTributario((flujo.getInteres() + flujo.getSeguroRiesgo() + flujo.getComision() + flujo.getDepreciacion())*c.getPorcentajeImpuestoRenta());
				if (numfila == NumeroTotalCuotas) {
					flujo.setRecompra(ValorVenta * c.getPorcentajeRecompra() * -1);
				} else {
					flujo.setRecompra(0);
				}
				flujo.setIgv((flujo.getCuota() + flujo.getSeguroRiesgo() + flujo.getComision() + flujo.getRecompra())
						* c.getPorcentajeIGV());
				flujo.setFlujoBruto(
						flujo.getCuota() + flujo.getSeguroRiesgo() + flujo.getComision() + flujo.getRecompra());
				flujo.setFlujoIGV(flujo.getFlujoBruto() + flujo.getIgv());
				flujo.setFlujoNeto(flujo.getFlujoBruto() - flujo.getAhorroTributario());

				flujo.setContratoId(c);
				flujo.setNumeroFila(numfila);
				numfila++;	
				listaflujos.add(flujo);
				arraydouble[indice] = flujo.getFlujoBruto();
				arraydoubleN[indice] = flujo.getFlujoNeto();
				arraydoubleI[indice] = flujo.getInteres();
				arraydoubleA[indice] = flujo.getAmortizacion();
				arraydoubleS[indice] = flujo.getSeguroRiesgo();
				arraydoubleC[indice] = flujo.getComision();
				arraydoubleR[indice] = flujo.getRecompra();
				

				
				indice++;
			} else 
			{
				//flujoaux = this.fetchByContratoIdNumeroFila(1, 1);
				
				flujoaux = listaflujos.get(listaflujos.size()-1);
				
				flujo.setSaldoInicial(flujoaux.getSaldoFinal());
				
				flujo.setInteres(flujo.getSaldoInicial() * -1 * PorcentajeTEP);
				if (c.getPlazogracia().equals("T")  && numfila <= c.getNumeroCuotasPG()) {
					flujo.setCuota(0);
					flujo.setAmortizacion(0);
					flujo.setSaldoFinal(flujo.getSaldoInicial() - flujo.getInteres());
				}
				if (c.getPlazogracia().equals("P")  && c.getNumeroCuotasPG() >= numfila) {
					flujo.setCuota(flujo.getInteres());
					flujo.setAmortizacion(0);
					flujo.setSaldoFinal(flujo.getSaldoInicial());

				}
				
				if (c.getNumeroCuotasPG() < numfila) {
					flujo.setPlazoGracia("S");
					flujo.setAmortizacion(-1 * flujo.getSaldoInicial() / (NumeroTotalCuotas - numfila + 1));
					flujo.setCuota(flujo.getInteres() + flujo.getAmortizacion());
					flujo.setSaldoFinal(flujo.getSaldoInicial() + flujo.getAmortizacion());
				}
				flujo.setSeguroRiesgo(flujo.getSeguroRiesgo() * -1);
				flujo.setComision(c.getComisionPeriodica() * -1);
				flujo.setDepreciacion(ValorVenta / NumeroTotalCuotas * -1);
				flujo.setAhorroTributario((flujo.getInteres() + flujo.getSeguroRiesgo() + flujo.getComision() + flujo.getDepreciacion())*c.getPorcentajeImpuestoRenta());
				if (numfila == NumeroTotalCuotas) {
					flujo.setRecompra(ValorVenta * c.getPorcentajeRecompra() * -1);
				} else {
					flujo.setRecompra(0);
				}
				flujo.setIgv((flujo.getCuota() + flujo.getSeguroRiesgo() + flujo.getComision() + flujo.getRecompra())
						* c.getPorcentajeIGV());
				flujo.setFlujoBruto(
						flujo.getCuota() + flujo.getSeguroRiesgo() + flujo.getComision() + flujo.getRecompra());
				flujo.setFlujoIGV(flujo.getFlujoBruto() + flujo.getIgv());
				flujo.setFlujoNeto(flujo.getFlujoBruto() - flujo.getAhorroTributario());

				flujo.setContratoId(c);
				flujo.setNumeroFila(numfila);
				numfila++;
				listaflujos.add(flujo);
				arraydouble[indice] = flujo.getFlujoBruto();
				arraydoubleN[indice] = flujo.getFlujoNeto();
				arraydoubleI[indice] = flujo.getInteres();
				arraydoubleA[indice] = flujo.getAmortizacion();
				arraydoubleS[indice] = flujo.getSeguroRiesgo();
				arraydoubleC[indice] = flujo.getComision();
				arraydoubleR[indice] = flujo.getRecompra();
				
				indice++;
			}
		}
		double sumaFB=0.0;		
		double sumaFN=0.0;
		double intereses=0.0;
		double amortizacionCap=0.0;
		double seguroContraR=0.0;
		double comisionesPer=0.0;
		double recompra=0.0;
		double desembolsoT=0.0;



		Irr irr=new Irr();
		
		FinanceLib financeLib=new FinanceLib();
		
		aux.setTceaFlujoBruto(Math.pow(1+irr.irr(arraydouble, 0.01), c.getNumeroDiasPorAnno()/c.getFrecuenciaDePago())-1);
		
		aux.setTceaFlujoNeto(Math.pow(1+irr.irr(arraydoubleN, 0.01), c.getNumeroDiasPorAnno()/c.getFrecuenciaDePago())-1);
		
		for(int i=0; i<aux.getNumeroTotalCuotas();i++)
		{
			sumaFB=sumaFB+arraydouble[i];
		}
		aux.setVanFlujoBruto(sumaFB+financeLib.npv((Math.pow(1+c.getTasaDescuentoKs(),c.getFrecuenciaDePago()/c.getNumeroDiasPorAnno()) -1), arraydouble));
		for(int i=0; i<aux.getNumeroTotalCuotas();i++)
		{
			sumaFN=sumaFN+arraydoubleN[i];
		}
		aux.setVanFlujoNeto(sumaFN+financeLib.npv((Math.pow(1+c.getTasaDescuentoWACC(),c.getFrecuenciaDePago()/c.getNumeroDiasPorAnno()) -1), arraydoubleN));
		aux.setContratoId(c);
		
		for(int i=0; i<aux.getNumeroTotalCuotas();i++)
		{
			intereses=intereses+arraydoubleI[i];
		}
		aux.setIntereses(intereses);
		
		for(int i=0; i<aux.getNumeroTotalCuotas();i++)
		{
			amortizacionCap=amortizacionCap+arraydoubleA[i];
		}
		aux.setAmortizacionCapital(amortizacionCap);
		
		for(int i=0; i<aux.getNumeroTotalCuotas();i++)
		{
			seguroContraR=seguroContraR+arraydoubleS[i];
		}
		aux.setSeguroContraRiesgo(seguroContraR);
		for(int i=0; i<aux.getNumeroTotalCuotas();i++)
		{
			comisionesPer=comisionesPer+arraydoubleC[i];
		}
		aux.setComisionesPeriodicas(comisionesPer);
		for(int i=0; i<aux.getNumeroTotalCuotas();i++)
		{
			recompra=recompra+arraydoubleR[i];
		}
		aux.setRecompra(recompra);
		
		aux.setDesembolsoTotal(intereses+amortizacionCap+seguroContraR+comisionesPer+recompra);
		
		
		
		return aux;
	}
}