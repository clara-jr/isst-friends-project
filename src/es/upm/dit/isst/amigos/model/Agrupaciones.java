package es.upm.dit.isst.amigos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Agrupaciones implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private int id;
	private String user;
	private int grupo;
	private String amigoinv;
	
	public Agrupaciones(String user, int grupo, String amigoinv){
		this.user = user;
		this.grupo = grupo;
		this.amigoinv = amigoinv;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public int getGrupo() {
		return grupo;
	}
	public String getAmigoinv() {
		return amigoinv;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	public void setAmigoinv(String amigoinv) {
		this.amigoinv = amigoinv;
	}
}






