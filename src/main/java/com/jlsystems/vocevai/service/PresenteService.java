package com.jlsystems.vocevai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.jlsystems.vocevai.list.Presente;
import com.jlsystems.vocevai.repository.PresenteRepository;

@Service
public class PresenteService {

	@Autowired
	PresenteRepository presenteRepository;
	
	public List<Presente> getPresente(){
		return presenteRepository.findAll();
	}
	
	public Optional<Presente> getPresentePorId(Integer id) {
		return presenteRepository.findById(id);
	}
	
	public List<Presente> getPresentePorNome(String nome) {
		return presenteRepository.findByDescricao(nome);
	}
	
	public Presente salvarPresente(Presente presente) {
		Assert.isNull(presente.getId(), "Não foi possível inserir o registro");
		return presenteRepository.save(presente);
	}
}
