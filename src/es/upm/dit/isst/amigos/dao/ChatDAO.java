package es.upm.dit.isst.amigos.dao;

import java.util.List;

import es.upm.dit.isst.amigos.model.Chat;

public interface ChatDAO {

	public Chat insertChat(Long grupo, String from, String to, String conversacion, boolean leidofrom, boolean leidoto);
	
	public List<Chat> getChatByFrom(String from);
	
	public List<Chat> getChatByTo(String to);
	
	public Chat getChatByFromAndGrupo(Long grupo, String from);
	
	public Chat getChatByToAndGrupo(Long grupo, String to);
	
	
}
