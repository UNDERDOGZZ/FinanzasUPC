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

import com.finanzas.entities.Flujo;
import com.finanzas.entities.Resultado;
import com.finanzas.service.ResultadoService;


@RestController
@RequestMapping("/resultados")
public class ResultadoController {

	@Autowired
	private ResultadoService resultadoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Resultado>> findAll() {
		try {
			List<Resultado> signs = new ArrayList<>();
			signs = resultadoService.findAll();
			return new ResponseEntity<List<Resultado>>(signs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Resultado>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Resultado> findById(@PathVariable("id") Integer id) {
		try {
			Optional<Resultado> sign = resultadoService.findById(id);
			if (!sign.isPresent()) {
				return new ResponseEntity<Resultado>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Resultado>(sign.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Resultado>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Resultado sign) {
		try {
			Resultado s = new Resultado();
			s = resultadoService.save(sign);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Resultado sign) {
		try {
			resultadoService.update(sign);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Resultado> sign = resultadoService.findById(id);

			if (!sign.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				resultadoService.deleteById(id);
				return new ResponseEntity<>("Signo se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(value = "/contrato/todos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resultado> fetchFlujos(@PathVariable("id") Integer id) {
		try {
			Resultado signs = new Resultado();
			signs = resultadoService.fecthResultados(id);
			return new ResponseEntity<Resultado>(signs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Resultado>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
