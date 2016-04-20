package es.upm.dit.isst.amigos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Agrupaciones implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	private String user;
	private Long grupo;
	private String amigoinv;
	private String exclusion;
	
	public Agrupaciones(String user, Long grupo, String amigoinv){
		this.user = user;
		this.grupo = grupo;
		this.amigoinv = amigoinv;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public Long getGrupo() {
		return grupo;
	}
	public String getAmigoinv() {
		return amigoinv;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setGrupo(Long grupo) {
		this.grupo = grupo;
	}
	public void setAmigoinv(String amigoinv) {
		this.amigoinv = amigoinv;
	}


	public String getExclusion() {
		return exclusion;
	}


	public void setExclusion(String exclusion) {
		this.exclusion = exclusion;
	}
}






