package com.finanzas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finanzas.entities.Usuario;
import com.finanzas.repository.UsuarioRepository;
import com.finanzas.service.UsuarioService;
@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() throws Exception {
		return usuarioRepository.findAll();
	}

	@Transactional
	@Override
	public Usuario save(Usuario t) throws Exception {
		return usuarioRepository.save(t);
	}
	
	@Transactional
	@Override
	public Usuario update(Usuario t) throws Exception {
		return usuarioRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Usuario> findById(Integer id) throws Exception {
		return usuarioRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		usuarioRepository.deleteById(id);

	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
