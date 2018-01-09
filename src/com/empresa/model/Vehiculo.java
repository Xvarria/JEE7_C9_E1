package com.empresa.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = -366283986788235006L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String placa;
	@Column(unique = true)
	private String chasis;
	private int puertas;
	@OneToOne (cascade = CascadeType.ALL)
	private Motor motor;
	
	@ManyToOne
	private Propietario propietario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getChasis() {
		return chasis;
	}
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}
	public int getPuertas() {
		return puertas;
	}
	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chasis == null) ? 0 : chasis.hashCode());
		result = prime * result + id;
		result = prime * result + ((motor == null) ? 0 : motor.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((propietario == null) ? 0 : propietario.hashCode());
		result = prime * result + puertas;
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
		Vehiculo other = (Vehiculo) obj;
		if (chasis == null) {
			if (other.chasis != null)
				return false;
		} else if (!chasis.equals(other.chasis))
			return false;
		if (id != other.id)
			return false;
		if (motor == null) {
			if (other.motor != null)
				return false;
		} else if (!motor.equals(other.motor))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (propietario == null) {
			if (other.propietario != null)
				return false;
		} else if (!propietario.equals(other.propietario))
			return false;
		if (puertas != other.puertas)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", placa=" + placa + ", chasis=" + chasis + ", puertas=" + puertas + ", motor="
				+ motor + "]";
	}
	
	
}
