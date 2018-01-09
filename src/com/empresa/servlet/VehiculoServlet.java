package com.empresa.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empresa.dao.VehiculoDAO;
import com.empresa.model.Motor;
import com.empresa.model.Propietario;
import com.empresa.model.Vehiculo;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/VehiculoServlet")
public class VehiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehiculoServlet() {
		super();
		// this.vehiculoDAO = new VehiculoDAOImpl();
	}

	// Se invoca como EJB
	@EJB
	VehiculoDAO vehiculoDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Usuarios:
		List<Propietario> propietarios = vehiculoDAO.getAllPropietarios();
		if (propietarios == null) {
			System.out.println("Lista de usuarios NULL, consulta servlet");
		} else {
			System.out.println(propietarios.size());
		}
		request.setAttribute("propietarios", propietarios);
		request.getRequestDispatcher("/vehiculos.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Crea un motor
		Motor motor = new Motor();
		motor.setCilidros(4);
		motor.setVin("ABCD1234");
		motor.setVolumen(1500);

		//this.vehiculoDAO.persist(motor);
		
		// 2. Crea un vehiculo y lo crea
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMotor(motor);
		vehiculo.setPlaca("873299");
		vehiculo.setChasis("CHASIS");
		vehiculo.setPuertas(4);
		
		// 2. Crea un motor
		Motor motor2 = new Motor();
		motor2.setCilidros(8);
		motor2.setVin("ABCD888");
		motor2.setVolumen(3500);

		//this.vehiculoDAO.persist(motor);
		
		// 2. Crea un vehiculo y lo crea
		Vehiculo vehiculo2 = new Vehiculo();
		vehiculo2.setMotor(motor2);
		vehiculo2.setPlaca("ABC123");
		vehiculo2.setChasis("CHASIS22");
		vehiculo2.setPuertas(2);		
		
		Propietario propietario = new Propietario();
		propietario.setCedula("113200655");
		propietario.setNombre("Marcos");
		Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
		vehiculos.add(vehiculo);
		vehiculos.add(vehiculo2);
		
		propietario.setVehiculos(vehiculos);
		this.vehiculoDAO.persist(propietario);
		
		doGet(request, response);
	}
}