package com.empresa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Propietario implements Serializable{

	private static final long serialVersionUID = -7623149495900019902L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String cedula;
	private String nombre;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Vehiculo> vehiculos;
	
	@ManyToMany
	private Set<Sociedad> sociedades;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((sociedades == null) ? 0 : sociedades.hashCode());
		result = prime * result + ((vehiculos == null) ? 0 : vehiculos.hashCode());
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
		Propietario other = (Propietario) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (sociedades == null) {
			if (other.sociedades != null)
				return false;
		} else if (!sociedades.equals(other.sociedades))
			return false;
		if (vehiculos == null) {
			if (other.vehiculos != null)
				return false;
		} else if (!vehiculos.equals(other.vehiculos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Propietario [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", vehiculos=" + vehiculos
				+ ", sociedades=" + sociedades + "]";
	}
	
	
	//QUIZ relacion 1 a n unidirrecional
	

}
