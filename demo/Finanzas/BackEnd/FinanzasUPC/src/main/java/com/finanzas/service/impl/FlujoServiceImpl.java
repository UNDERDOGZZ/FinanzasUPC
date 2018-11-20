package com.finanzas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.entities.Contrato;
import com.finanzas.entities.Flujo;
import com.finanzas.repository.FlujoRepository;
import com.finanzas.service.FlujoService;
@Service
public class FlujoServiceImpl implements FlujoService {
	
	@Autowired
	private FlujoRepository flujoRepository;
	
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

	@Override
	public Flujo fetchByContratoIdNumeroFila(int contratoId, int numerofila) throws Exception {
		// TODO Auto-generated method stub
		return flujoRepository.fetchByContratoIdNumeroFila(contratoId, numerofila);
	}

	@Override
	public void saveFlujo(Contrato c) throws Exception {
		c.setPorcentajeIGV(0.18);
		
		double IGV =(c.getPrecioVenta()/(1+c.getPorcentajeIGV())*c.getPorcentajeIGV());
		
		double ValorVenta = (c.getPrecioVenta()- IGV);
		
		double MontoLeasing = (ValorVenta + c.getCostesNotariales() + c.getCostesRegistrales() + c.getTasacion()+ c.getComisionEstudio()+ c.getComisionActivacion());
		
		double PorcentajeTEP = (Math.pow((1+c.getPorcentajeTEA()), (c.getFrecuenciaDePago()/c.getNumeroDiasPorAnno()))-1);

		double NumeroCuotasAnno = (c.getNumeroDiasPorAnno()/c.getFrecuenciaDePago());
		
		double NumeroTotalCuotas = (NumeroCuotasAnno*c.getNumeroAnnos());
		
		double SeguroRiesgo = (c.getPorcentajeSeguroRiesgo()*c.getPrecioVenta()/NumeroCuotasAnno);
		
		int numfila = 1;
		
		Flujo flujo = new Flujo();
		
		Flujo flujoaux = new Flujo();
		
		for(int i= 0; i <NumeroTotalCuotas;i++)
		{
			if(numfila==1)
			{
				
				this.save(flujo);
				flujo = new Flujo();
				numfila++;
			}
			else
			{
				flujoaux = this.fetchByContratoIdNumeroFila(c.getId(), numfila);
				
				
				this.save(flujo);
				flujo = new Flujo();
				flujoaux = new Flujo();
				numfila++;
			}
		}
		
	}

}

