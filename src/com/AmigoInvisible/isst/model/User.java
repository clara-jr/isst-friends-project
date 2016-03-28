package com.AmigoInvisible.isst.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String nick;
	private String email;
	private String perfilsocial;
	private int lista;
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPerfilsocial() {
		return perfilsocial;
	}
	public void setPerfilsocial(String perfilsocial) {
		this.perfilsocial = perfilsocial;
	}
	public int getLista() {
		return lista;
	}
	public void setLista(int lista) {
		this.lista = lista;
	}
	
	
}
