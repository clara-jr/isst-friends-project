package es.upm.dit.isst.amigos.dao;

import es.upm.dit.isst.amigos.model.User;

public interface UserDAO {
	
	public User insertUser(String nick, String email, String perfilsocial);
	
	public User getUserByNick(String nick);
	
	public User getUserByEmail(String email);
	
	public User getUserByPerfilSocial(String perfilsocial);
}
