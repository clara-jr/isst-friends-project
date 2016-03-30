package com.AmigoInvisible.isst.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Grupos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String moderador;
	
	public int getId() {
		return id;
	}
	public String getModerador() {
		return moderador;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setModerador(String moderador) {
		this.moderador = moderador;
	}
}
