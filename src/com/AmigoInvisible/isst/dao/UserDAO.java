package com.AmigoInvisible.isst.dao;

import com.AmigoInvisible.isst.model.User;

public interface UserDAO {
	
	public User insertUser(String nick, String email, String perfilsocial);
	
	public User getUserByNick(String nick);
	
	public User getUserByEmail(String email);
	
	public User getUserByPerfilSocial(String perfilsocial);
	
	
	

}
