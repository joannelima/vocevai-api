package com.jlsystems.vocevai.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.jlsystems.vocevai.list.CategoriaFesta;
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
	private CategoriaFesta fkCategoria;

	@ManyToMany(fetch=FetchType.EAGER)
	private List<Presente> presente;
	
	public Integer getId() {
		return id;
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

	public CategoriaFesta getFkCategoria() {
		return fkCategoria;
	}

	public void setFkCategoria(CategoriaFesta fkCategoria) {
		this.fkCategoria = fkCategoria;
	}

	
	
    
}