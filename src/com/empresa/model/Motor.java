package com.empresa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Motor implements Serializable {
	private static final long serialVersionUID = -366283986788235006L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String vin;
	private int cilidros;
	private int volumen;
	
	@OneToOne(mappedBy="motor")
	private Vehiculo vehiculo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getVin() {
		return vin;
	}
	
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public int getCilidros() {
		return cilidros;
	}
	
	public void setCilidros(int cilidros) {
		this.cilidros = cilidros;
	}
	
	public int getVolumen() {
		return volumen;
	}
	
	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cilidros;
		result = prime * result + id;
		result = prime * result + ((vehiculo == null) ? 0 : vehiculo.hashCode());
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
		result = prime * result + volumen;
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
		Motor other = (Motor) obj;
		if (cilidros != other.cilidros)
			return false;
		if (id != other.id)
			return false;
		if (vehiculo == null) {
			if (other.vehiculo != null)
				return false;
		} else if (!vehiculo.equals(other.vehiculo))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		if (volumen != other.volumen)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Motor [id=" + id + ", vin=" + vin + ", cilidros=" + cilidros + ", volumen=" + volumen + ", vehiculo="
				+ vehiculo + "]";
	}
	
	
	
}
