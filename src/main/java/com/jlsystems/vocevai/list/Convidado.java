package com.jlsystems.vocevai.list;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jlsystems.vocevai.model.Festa;


@Entity
public class Convidado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeConvidado;
	
	private String codigoConvidado;
	
	private Boolean temPresente;
	
	@ManyToOne
	@JoinColumn(name ="fk_festa")
	private Festa fkFesta;
	
	public String getCodigoConvidado() {
		return codigoConvidado;
	}

	public Festa getFkFesta() {
		return fkFesta;
	}

	public void setFkFesta(Festa fkFesta) {
		this.fkFesta = fkFesta;
	}

	public void setCodigoConvidado(String codigoConvidado) {
		this.codigoConvidado = codigoConvidado;
	}

	public Boolean getTemPresente() {
		return temPresente;
	}

	public void setTemPresente(Boolean temPresente) {
		this.temPresente = temPresente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeConvidado() {
		return nomeConvidado;
	}

	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Convidado other = (Convidado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
