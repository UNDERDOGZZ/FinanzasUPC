package com.finanzas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}

