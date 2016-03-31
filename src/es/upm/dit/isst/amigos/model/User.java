package es.upm.dit.isst.amigos.model;

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
	
	public User(String nick, String email, String perfilsocial, int lista){
		this.nick = nick;
		this.email = email;
		this.perfilsocial = perfilsocial;
	}
	
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
	
}
