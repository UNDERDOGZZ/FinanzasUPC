package com.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.entities.Flujo;

@Repository
public interface FlujoRepository extends JpaRepository<Flujo, Integer> {
	
}
