package es.upm.dit.isst.amigos.dao;

import es.upm.dit.isst.amigos.model.Login;

public interface LoginDAO {
	
	public Login insertLogin(String usuario, String contraseña);
	
	public Login getLoginByUsuario(String usuario);
}
