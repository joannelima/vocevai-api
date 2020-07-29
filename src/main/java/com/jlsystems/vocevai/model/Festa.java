package com.jlsystems.vocevai.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jlsystems.vocevai.list.CategoriaFesta;
import com.jlsystems.vocevai.list.Convidado;
import com.jlsystems.vocevai.list.Presente;

@Entity
public class Festa implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
	
	@ManyToOne
	@JoinColumn(name ="fk_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name ="fk_categoria")
	private CategoriaFesta categoria;
	
	@OneToMany(mappedBy = "festa", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Convidado> convidados;

	@ManyToMany(fetch=FetchType.EAGER)
	private List<Presente> presente;
	
	public Integer getId() {
		return id;
	}

	
	public List<Convidado> getConvidados() {
		return convidados;
	}


	public void setConvidados(List<Convidado> convidados) {
		this.convidados = convidados;
	}


	public List<Presente> getPresente() {
		return presente;
	}


	public void setPresente(List<Presente> presente) {
		this.presente = presente;
	}


	public void setId(Integer id) {
		this.id = id;
	}

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

	

	
	
    
}