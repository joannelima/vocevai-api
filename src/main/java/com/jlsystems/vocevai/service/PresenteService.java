package com.jlsystems.vocevai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlsystems.vocevai.list.Presente;
import com.jlsystems.vocevai.repository.PresenteRepository;

@Service
public class PresenteService {

	@Autowired
	PresenteRepository presenteRepository;
	
	public List<Presente> getPresente(){
		return presenteRepository.findAll();
	}
}
