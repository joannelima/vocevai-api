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

import com.jlsystems.vocevai.list.Presente;
import com.jlsystems.vocevai.service.PresenteService;

@RestController
@RequestMapping("/festa/presentes")
public class PresenteController {
	
	@Autowired
	private PresenteService presenteService; 
	
	@GetMapping()
	private ResponseEntity<List<Presente>> listaTodosPresentes(){
		  List<Presente> presentes = presenteService.getPresente();
	        return ResponseEntity.ok(presentes);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Optional<Presente>> get(@PathVariable Integer id){
		Optional<Presente> presente = presenteService.getPresentePorId(id);
		return ResponseEntity.ok(presente);
	}
	
	@GetMapping("/nome/{nome}")
	private ResponseEntity<List<Presente>> get(@PathVariable String nome){
		List<Presente> presente = presenteService.getPresentePorNome(nome);
		return ResponseEntity.ok(presente);
	}
	
	@PostMapping
	public ResponseEntity<Presente> post(@RequestBody Presente presente) {
			Presente p = presenteService.insert(presente);
			URI location = getUri(p.getId());
			return ResponseEntity.created(location).build();
	}
	
	private URI getUri(Integer id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
	
}
