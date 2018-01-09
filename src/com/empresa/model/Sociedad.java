package com.empresa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sociedad implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7555170160168081399L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String razonSocial;
	
	@ManyToMany (mappedBy = "sociedades")
	private Set<Propietario> propietarios;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Set<Propietario> getPropietarios() {
		return propietarios;
	}

	public void setPropietarios(Set<Propietario> propietarios) {
		this.propietarios = propietarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((propietarios == null) ? 0 : propietarios.hashCode());
		result = prime * result + ((razonSocial == null) ? 0 : razonSocial.hashCode());
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
		Sociedad other = (Sociedad) obj;
		if (id != other.id)
			return false;
		if (propietarios == null) {
			if (other.propietarios != null)
				return false;
		} else if (!propietarios.equals(other.propietarios))
			return false;
		if (razonSocial == null) {
			if (other.razonSocial != null)
				return false;
		} else if (!razonSocial.equals(other.razonSocial))
			return false;
		return true;
	}
	

}
