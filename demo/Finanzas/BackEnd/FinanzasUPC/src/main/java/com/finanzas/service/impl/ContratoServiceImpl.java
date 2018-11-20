package com.finanzas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.entities.Contrato;
import com.finanzas.repository.ContratoRepository;
import com.finanzas.service.ContratoService;
@Service
public class ContratoServiceImpl implements ContratoService {

	@Autowired
	private ContratoRepository contratoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Contrato> findAll() throws Exception {
		return contratoRepository.findAll();
	}

	@Transactional
	@Override
	public Contrato save(Contrato t) throws Exception {
		return contratoRepository.save(t);
	}
	
	@Transactional
	@Override
	public Contrato update(Contrato t) throws Exception {
		return contratoRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Contrato> findById(Integer id) throws Exception {
		return contratoRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		contratoRepository.deleteById(id);

	}

	@Transactional(readOnly = true)
	@Override
	public List<Contrato> fetchByEmpresa(String empresa) throws Exception {
		return contratoRepository.fetchByEmpresa(empresa);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
