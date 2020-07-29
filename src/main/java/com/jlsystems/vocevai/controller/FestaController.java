package com.jlsystems.vocevai.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jlsystems.vocevai.dto.FestaDto;
import com.jlsystems.vocevai.model.Festa;
import com.jlsystems.vocevai.service.FestaService;

@RestController
@RequestMapping("/festa")
public class FestaController {
	
	@Autowired
	private FestaService festaService; 
	
	@PostMapping("/nova")
	private ResponseEntity<Festa> novaFesta(@Valid FestaDto festa, BindingResult result){
		Festa p = festaService.salvarFesta(festa);
		URI location = getUri(p.getId());
		return ResponseEntity.created(location).build();
	}
	
	private URI getUri(Integer id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
	
}
