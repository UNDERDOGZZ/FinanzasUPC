package com.finanzas.service;

import java.util.Optional;

import com.finanzas.entities.Contrato;
import com.finanzas.entities.Flujo;

public interface FlujoService extends CrudService<Flujo> {
	Flujo fetchByContratoIdNumeroFila(int contratoId, int numerofila) throws Exception;

	Flujo saveFlujo(Contrato c) throws Exception;
}
