package com.finanzas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.finanzas.entities.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

	@Query("select c from Contrato c where c.usuarioId.empresa like %?1%")
	List<Contrato> fetchByEmpresa(String empresa);
	
}
