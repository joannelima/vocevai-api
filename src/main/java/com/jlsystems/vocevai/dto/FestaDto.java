package com.jlsystems.vocevai.dto;

import java.util.List;

import com.jlsystems.vocevai.list.CategoriaFesta;
import com.jlsystems.vocevai.model.Usuario;

public class FestaDto {
	
	private Usuario usuario;
	
	private CategoriaFesta categoria;
	
	private List<ConvidadoDto> convidados;

	private List<PresenteDto> presente;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public CategoriaFesta getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaFesta categoria) {
		this.categoria = categoria;
	}

	public List<ConvidadoDto> getConvidados() {
		return convidados;
	}

	public void setConvidados(List<ConvidadoDto> convidados) {
		this.convidados = convidados;
	}

	public List<PresenteDto> getPresente() {
		return presente;
	}

	public void setPresente(List<PresenteDto> presente) {
		this.presente = presente;
	}

	
	
}
