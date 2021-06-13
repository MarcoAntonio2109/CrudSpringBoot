package br.com.tinnova.crudsb.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tinnova.crudsb.dto.VeiculoDto;
import br.com.tinnova.crudsb.entities.Veiculo;
import br.com.tinnova.crudsb.exception.VeiculoException;
import br.com.tinnova.crudsb.service.VeiculoService;

@RestController
@RequestMapping(path = "veiculo")
public class VeiculoController {
	
	final Logger logger =  LogManager.getLogger(VeiculoController.class.getName());
	
	@Autowired
	private VeiculoService service;
	
	@GetMapping(path = "/findAll")
	public ResponseEntity<Iterable<Veiculo>> findAll() {
		try {	
			return ResponseEntity.ok().body(service.findAll());
		}catch (VeiculoException e) {
			logger.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}

	}
	
	@GetMapping(path = "/findByAno")
	public ResponseEntity<List<Veiculo>> findByAno(@RequestParam(name ="ano", required=true) Integer ano) {	
		try {	
			return ResponseEntity.ok().body(service.findByAno(ano));
		}catch (VeiculoException e) {
			logger.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}

	}

	@GetMapping(path = "/findById")
	public ResponseEntity<Optional<Veiculo>> findById(@RequestParam(name = "id", required=true) Integer id) {		
		try {	
			return ResponseEntity.ok().body(service.findById(id));
		}catch (VeiculoException e) {
			logger.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
	}	
	
	@PostMapping(path = "/addVeiculo")
	public ResponseEntity<Veiculo> addVeiculo(@Valid Veiculo veiculo) { 
		try {
			return ResponseEntity.ok().body(service.addVeiculo(veiculo));
		}catch (VeiculoException e) {
			logger.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
	}	
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, path ="/updateVeiculo")	
	public ResponseEntity<Veiculo> updateVeiculo(VeiculoDto veiculo) {	
		try {
			return ResponseEntity.ok().body(service.updateVeiculo(veiculo));
		}catch (VeiculoException e) {
			logger.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping(path = "/deleteById")
	public ResponseEntity<String> deleteById(Integer id) {	
		try {
			service.deleteVeiculoById(id);
			return ResponseEntity.ok().body(null);
		}catch (VeiculoException e) {
			logger.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping(path = "/deleteByAno")
	public ResponseEntity<String> deleteByAno(Integer ano) {	
		try {
			service.deleteVeiculoByAno(ano);
			return ResponseEntity.ok().body(null);
		}catch (VeiculoException e) {
			logger.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping(path = "/deleteAll")
	public ResponseEntity<String> deleteAll() {	
		try {
			service.deleteAll();
			return ResponseEntity.ok().body(null);
		}catch (VeiculoException e) {
			logger.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
	}
}
