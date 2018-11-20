package com.finanzas.service;

import com.finanzas.entities.Resultado;

public interface ResultadoService extends CrudService<Resultado> {
	
	Resultado fecthResultados(int id) throws Exception;
}
