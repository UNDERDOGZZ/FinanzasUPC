package com.finanzas.service;

import java.util.List;
import java.util.Optional;

import com.finanzas.entities.Contrato;
import com.finanzas.entities.Flujo;

public interface FlujoService extends CrudService<Flujo> {
	Flujo fetchByContratoIdNumeroFila(int contratoId, int numerofila) throws Exception;

	 List<Flujo> fetchFlujos(int id) throws Exception;
	
	List<Flujo> fetchByContratoId(int id) throws Exception;
}
