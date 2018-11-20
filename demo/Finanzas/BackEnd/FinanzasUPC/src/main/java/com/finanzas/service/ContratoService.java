package com.finanzas.service;

import java.util.List;

import com.finanzas.entities.Contrato;

public interface ContratoService extends CrudService<Contrato> {
	List<Contrato> fetchByEmpresa(String empresa) throws Exception;

}
