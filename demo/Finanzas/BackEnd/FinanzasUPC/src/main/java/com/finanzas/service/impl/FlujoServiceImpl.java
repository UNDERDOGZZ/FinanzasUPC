package com.finanzas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.entities.Contrato;
import com.finanzas.entities.Flujo;
import com.finanzas.repository.ContratoRepository;
import com.finanzas.repository.FlujoRepository;
import com.finanzas.service.FlujoService;

@Service
public class FlujoServiceImpl implements FlujoService {

	@Autowired
	private FlujoRepository flujoRepository;
	@Autowired
	private ContratoRepository contratoRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Flujo> findAll() throws Exception {
		return flujoRepository.findAll();
	}

	@Transactional
	@Override
	public Flujo save(Flujo t) throws Exception {
		return flujoRepository.save(t);
	}

	@Transactional
	@Override
	public Flujo update(Flujo t) throws Exception {
		return flujoRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Flujo> findById(Integer id) throws Exception {
		return flujoRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		flujoRepository.deleteById(id);

	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub

	}

	@Transactional(readOnly = true)
	@Override
	public Flujo fetchByContratoIdNumeroFila(int contratoId, int numerofila) throws Exception {
		// TODO Auto-generated method stub
		return flujoRepository.fetchByContratoIdNumeroFila(contratoId, numerofila);
	}

	
	@Transactional(readOnly = true)
	@Override
	public List<Flujo> fetchFlujos(int id) throws Exception {
		
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

		int numfila = 1;

		Flujo flujo = new Flujo();

		Flujo flujoaux = new Flujo();

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
					flujo.setSaldoFinal(flujo.getSaldoInicial() + flujo.getAmortizacion());
				}
				if (c.getPlazogracia().equals("T")  && c.getNumeroCuotasPG() >= numfila) {
					flujo.setCuota(flujo.getInteres());
					flujo.setAmortizacion(0);
					flujo.setSaldoFinal(flujo.getSaldoInicial());

				}
				if (c.getNumeroCuotasPG() < numfila) {
					flujo.setAmortizacion(-1 * flujo.getSaldoInicial() / (NumeroTotalCuotas - numfila + 1));
					flujo.setCuota(flujo.getInteres() + flujo.getAmortizacion());
					flujo.setSaldoFinal(flujo.getSaldoInicial() + flujo.getAmortizacion());
				}
				flujo.setSeguroRiesgo(flujo.getSeguroRiesgo() * -1);
				flujo.setComision(c.getComisionPeriodica() * -1);
				flujo.setDepreciacion(ValorVenta / NumeroTotalCuotas * -1);
				flujo.setAhorroTributario(
						flujo.getInteres() + flujo.getSeguroRiesgo() + flujo.getComision() + flujo.getDepreciacion());
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
			} else 
			{
				//flujoaux = this.fetchByContratoIdNumeroFila(1, 1);
				
				flujoaux = listaflujos.get(listaflujos.size()-1);
				
				flujo.setSaldoInicial(flujoaux.getSaldoFinal());
				
				flujo.setInteres(flujo.getSaldoInicial() * -1 * PorcentajeTEP);
				if (c.getPlazogracia() == "T" && numfila <= c.getNumeroCuotasPG()) {
					flujo.setCuota(0);
					flujo.setAmortizacion(0);
					flujo.setSaldoFinal(flujo.getSaldoInicial() + flujo.getAmortizacion());
				}
				if (c.getPlazogracia() == "P" && c.getNumeroCuotasPG() >= numfila) {
					flujo.setCuota(flujo.getInteres());
					flujo.setAmortizacion(0);
					flujo.setSaldoFinal(flujo.getSaldoInicial());

				}
				
				if (c.getNumeroCuotasPG() < numfila) {
					flujo.setAmortizacion(-1 * flujo.getSaldoInicial() / (NumeroTotalCuotas - numfila + 1));
					flujo.setCuota(flujo.getInteres() + flujo.getAmortizacion());
					flujo.setSaldoFinal(flujo.getSaldoInicial() + flujo.getAmortizacion());
				}
				flujo.setSeguroRiesgo(flujo.getSeguroRiesgo() * -1);
				flujo.setComision(c.getComisionPeriodica() * -1);
				flujo.setDepreciacion(ValorVenta / NumeroTotalCuotas * -1);
				flujo.setAhorroTributario(
						flujo.getInteres() + flujo.getSeguroRiesgo() + flujo.getComision() + flujo.getDepreciacion());
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
			}
		}
		return listaflujos;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Flujo> fetchByContratoId(int id) throws Exception {
		return flujoRepository.fetchByContratoId(id);
	}

}
