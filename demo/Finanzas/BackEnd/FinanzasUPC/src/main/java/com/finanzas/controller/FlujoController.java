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

import com.finanzas.entities.Contrato;
import com.finanzas.entities.Flujo;
import com.finanzas.service.FlujoService;


@RestController
@RequestMapping("/flujos")
public class FlujoController {

	@Autowired
	private FlujoService flujoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Flujo>> findAll() {
		try {
			List<Flujo> signs = new ArrayList<>();
			signs = flujoService.findAll();
			return new ResponseEntity<List<Flujo>>(signs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Flujo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/contrato/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Flujo>> findByContratoId(@PathVariable("id") Integer id) {
		try {
			List<Flujo> signs = new ArrayList<>();
			signs = flujoService.fetchByContratoId(id);
			return new ResponseEntity<List<Flujo>>(signs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Flujo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Flujo> findById(@PathVariable("id") Integer id) {
		try {
			Optional<Flujo> sign = flujoService.findById(id);
			if (!sign.isPresent()) {
				return new ResponseEntity<Flujo>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Flujo>(sign.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Flujo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Flujo sign) {
		try {
			Flujo s = new Flujo();
			s = flujoService.save(sign);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Flujo sign) {
		try {
			flujoService.update(sign);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Flujo> sign = flujoService.findById(id);

			if (!sign.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				flujoService.deleteById(id);
				return new ResponseEntity<>("Signo se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(value = "/contrato/todos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Flujo>> fetchFlujos(@PathVariable("id") Integer id) {
		try {
			List<Flujo> signs = new ArrayList<>();
			signs = flujoService.fetchFlujos(id);
			return new ResponseEntity<List<Flujo>>(signs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Flujo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
