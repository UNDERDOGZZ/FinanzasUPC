package com.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.entities.Resultado;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {
	
}
