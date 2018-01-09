package com.empresa.dao;

import java.util.List;

import javax.ejb.Remote;

import com.empresa.model.Motor;
import com.empresa.model.Propietario;
import com.empresa.model.Vehiculo;

@Remote //EN la interface se define el tipo de acceso local vs public
public interface VehiculoDAO {

	public void persist(Vehiculo vehiculo);
	
	public void persist(Motor motor);
	
	public void persist(Propietario propietario);
	
	public List<Vehiculo> getAllVehiculos(); 
	
	public List<Propietario> getAllPropietarios();
}
