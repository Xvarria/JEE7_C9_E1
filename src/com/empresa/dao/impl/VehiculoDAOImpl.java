package com.empresa.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.empresa.dao.VehiculoDAO;
import com.empresa.model.Motor;
import com.empresa.model.Propietario;
import com.empresa.model.Vehiculo;

//En la implementacion se define el tipo 
@Stateless
@LocalBean
public class VehiculoDAOImpl implements VehiculoDAO {

	@PersistenceContext(name="default")
	private EntityManager em;
	
	@Override
	public void persist(Vehiculo vehiculo) {
		em.persist(vehiculo);
	}
	
	public void persist(Motor motor){
		em.persist(motor);
	}
	
	

	@Override
	public void persist(Propietario propietario) {
		em.persist(propietario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> getAllVehiculos() {
	    String queryString = "Select u from Vehiculo u";
	    Query query = em.createQuery(queryString);
	    List<Vehiculo> result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Propietario> getAllPropietarios() {
	    String queryString = "Select p from Propietario p";
	    Query query = em.createQuery(queryString);
	    List<Propietario> result = query.getResultList();
		return result;
	}
}
