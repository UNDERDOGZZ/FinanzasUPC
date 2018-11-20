package com.finanzas.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.faq.entities.Pregunta;
import com.finanzas.entities.Contrato;
import com.finanzas.service.ContratoService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/contratos")
public class ContratoController {

	@Autowired
	private ContratoService contratoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contrato>> findAll() {
		try {
			List<Contrato> signs = new ArrayList<>();
			signs = contratoService.findAll();
			return new ResponseEntity<List<Contrato>>(signs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Contrato>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Contrato> findById(@PathVariable("id") Integer id) {
		try {
			Optional<Contrato> sign = contratoService.findById(id);
			if (!sign.isPresent()) {
				return new ResponseEntity<Contrato>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Contrato>(sign.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Contrato>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Contrato sign) {
		try {
			Contrato s = new Contrato();
			s = contratoService.save(sign);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Contrato sign) {
		try {
			contratoService.update(sign);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Contrato> sign = contratoService.findById(id);

			if (!sign.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				contratoService.deleteById(id);
				return new ResponseEntity<>("Signo se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@ApiOperation("Obtener contratos por empresa")
	@GetMapping(value = "/search/{empresa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contrato>> fetchByText(@PathVariable("empresa") String empresa) {
		try {
			List<Contrato> contratos = new ArrayList<>();
			contratos = contratoService.fetchByEmpresa(empresa);
			return new ResponseEntity<List<Contrato>>(contratos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Contrato>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
