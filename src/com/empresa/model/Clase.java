package com.empresa.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Clase implements Serializable {

	/**
	 * TArea/Quiz hacer un OneToMany que consulta y pagine
	 */
	private static final long serialVersionUID = -6672423698571693816L;

	private int id;
	private String codigo;
	private String curso;
}
