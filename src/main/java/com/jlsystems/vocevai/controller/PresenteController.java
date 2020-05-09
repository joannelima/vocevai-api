package com.jlsystems.vocevai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jlsystems.vocevai.list.Presente;
import com.jlsystems.vocevai.service.PresenteService;

@RestController
@RequestMapping("/presentes")
public class PresenteController {
	
	@Autowired
	private PresenteService presenteService; 
	
	@GetMapping()
	private ResponseEntity<List<Presente>> listaTodosPresentes(){
		  List<Presente> presentes = presenteService.getPresente();
	        return ResponseEntity.ok(presentes);
	}
	
}
