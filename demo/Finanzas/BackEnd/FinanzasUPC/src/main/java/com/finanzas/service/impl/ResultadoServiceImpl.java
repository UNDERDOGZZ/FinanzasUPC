package com.finanzas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.entities.Resultado;
import com.finanzas.repository.ResultadoRepository;
import com.finanzas.service.ResultadoService;
@Service
public class ResultadoServiceImpl implements ResultadoService {
	
	@Autowired
	private ResultadoRepository resultadoRepository;
	
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

}
