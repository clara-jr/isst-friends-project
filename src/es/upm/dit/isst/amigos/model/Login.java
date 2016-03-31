package es.upm.dit.isst.amigos.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String usuario;
	private String contraseña;
	
	public Login(String usuario, String contraseña){
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
