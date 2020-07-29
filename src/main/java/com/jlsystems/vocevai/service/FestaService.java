package com.jlsystems.vocevai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlsystems.vocevai.dto.ConvidadoDto;
import com.jlsystems.vocevai.dto.FestaDto;
import com.jlsystems.vocevai.dto.PresenteDto;
import com.jlsystems.vocevai.model.Festa;
import com.jlsystems.vocevai.repository.FestaRepository;

@Service
public class FestaService {

	@Autowired
	FestaRepository festaRepository;
	
	@Autowired
	ConvidadoService convidadoService;
	
	@Autowired
	PresenteService presenteService;
	
	public Festa salvarFesta(FestaDto festaDto) {
		Festa festa = new Festa();
		festa.setCategoria(festaDto.getCategoria());
		festa.setUsuario(null);
		festaRepository.save(festa);
		salvarListaConvidados(festaDto, festa);
		salvarListaPresentes(festaDto, festa);
		
		
		return festa;
	}

	private void salvarListaPresentes(FestaDto festaDto, Festa festa) {
		if(festaDto.getPresente() != null && festaDto.getPresente().size()>=0){
			System.err.println(festaDto.getPresente().size());
			List<PresenteDto> presentes = festaDto.getPresente();
			presentes.forEach(presente -> presenteService.salvarPresentePorFesta(presente, festa));
		}
	}

	private void salvarListaConvidados(FestaDto festaDto, Festa festa) {
		if(festaDto.getConvidados() !=null && festaDto.getConvidados().size()>=0) {
			List<ConvidadoDto> convidados = festaDto.getConvidados();
			convidados.forEach(convidado -> convidadoService.salvarConvidadoPorFesta(convidado, festa));
		}
	}
	
	
}
