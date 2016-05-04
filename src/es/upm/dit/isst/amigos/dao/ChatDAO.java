package es.upm.dit.isst.amigos.dao;

import java.util.List;

import es.upm.dit.isst.amigos.model.Chat;

public interface ChatDAO {

	public Chat insertChat(Long grupo, String from, String to, boolean leidofrom, boolean leidoto);
	
	public List<Chat> getChatByFrom(String from);
	
	public List<Chat> getChatByTo(String to);
	
	public Chat getChatByFromAndGrupo(Long grupo, String from);
	
	public Chat getChatByToAndGrupo(Long grupo, String to);
	
	/*
	 * autor: El que escribe el mensaje. No importa si es el que regala o al que regalan, simplemente el que escribe el mensaje.
	 * mensaje: El mensaje que se escribe.
	 */
	
	public Chat insertMensaje(Chat chat, String mensaje, String autor);
	
	public void updateChat(Chat chat);
	
	
	
	
}
