package com.jlsystems.vocevai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.jlsystems.vocevai.dto.ConvidadoDto;
import com.jlsystems.vocevai.list.Convidado;
import com.jlsystems.vocevai.model.Festa;
import com.jlsystems.vocevai.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	ConvidadoRepository convidadoRepository;
	
	public List<Convidado> getConvidado(){
		return convidadoRepository.findAll();
	}
	
	public Optional<Convidado> getConvidadoPorId(Integer id) {
		return convidadoRepository.findById(id);
	}
	
	public List<Convidado> getConvidadoPorNome(String nome) {
		return convidadoRepository.findByNomeConvidado(nome);
	}
	
	public Convidado salvarConvidado(Convidado convidado) {
		Assert.isNull(convidado.getId(), "Não foi possível inserir o registro");
		return convidadoRepository.save(convidado);
	}
	
	public Convidado salvarConvidadoPorFesta(ConvidadoDto convidado, Festa festa) {
		Convidado novoConvidado = new Convidado();
		novoConvidado.setFesta(festa);
		novoConvidado.setCodigoConvidado(convidado.getCodigoConvidado());
		novoConvidado.setNomeConvidado(convidado.getNomeConvidado());
		novoConvidado.setTemPresente(convidado.getTemPresente());
		return novoConvidado;
	}
}
