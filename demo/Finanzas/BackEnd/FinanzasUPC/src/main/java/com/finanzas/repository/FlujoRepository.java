package com.finanzas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.finanzas.entities.Flujo;

@Repository
public interface FlujoRepository extends JpaRepository<Flujo, Integer> {
	
	@Query("select f from Flujo f where f.contratoId.id = ?1 and f.numeroFila = ?2")
	Flujo fetchByContratoIdNumeroFila(int contratoId, int numerofila);
	
	@Query("select f from Flujo f where f.contratoId.id = ?1")
	List<Flujo> fetchByContratoId(int id);
}
