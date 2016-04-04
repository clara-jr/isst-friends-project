package es.upm.dit.isst.amigos.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String user;
	private String contraseña;
	
	public Login(String user, String contraseña){
		this.user = user;
		this.contraseña = contraseña;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
