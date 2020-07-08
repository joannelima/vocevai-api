package com.jlsystems.vocevai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.jlsystems.vocevai.model.Festa;
import com.jlsystems.vocevai.repository.FestaRepository;

@Service
public class FestaService {

	@Autowired
	FestaRepository festaRepository;
	
	public Festa salvarFesta(Festa festa) {
		Assert.isNull(festa.getId(), "Não foi possível inserir o registro");
		
		return festaRepository.save(festa);
	}
}
