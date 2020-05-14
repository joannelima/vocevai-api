package com.jlsystems.vocevai.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jlsystems.vocevai.list.Convidado;
import com.jlsystems.vocevai.service.ConvidadoService;

@RestController
@RequestMapping("/convidado")
public class ConvidadoController {
	
	@Autowired
	private ConvidadoService convidadoService; 
	
	@GetMapping()
	private ResponseEntity<List<Convidado>> listaTodosPresentes(){
		  List<Convidado> presentes = convidadoService.getConvidado();
	        return ResponseEntity.ok(presentes);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Optional<Convidado>> listaPorId(@PathVariable Integer id){
		Optional<Convidado> presente = convidadoService.getConvidadoPorId(id);
		return ResponseEntity.ok(presente);
	}
	
	@GetMapping("/nome/{nome}")
	private ResponseEntity<List<Convidado>> listaPorNome(@PathVariable String nome){
		List<Convidado> presente = convidadoService.getConvidadoPorNome(nome);
		return ResponseEntity.ok(presente);
	}
	
	@PostMapping
	public ResponseEntity<Convidado> salvarPresente(@RequestBody Convidado convidado) {
			Convidado p = convidadoService.salvarConvidado(convidado);
			URI location = getUri(p.getId());
			return ResponseEntity.created(location).build();
	}
	
	private URI getUri(Integer id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
	
}
