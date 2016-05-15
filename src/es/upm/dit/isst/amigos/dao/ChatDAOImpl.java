package es.upm.dit.isst.amigos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.appengine.api.datastore.Text;

import es.upm.dit.isst.amigos.model.Chat;


public class ChatDAOImpl implements ChatDAO {
	
	private static ChatDAOImpl instance;
	
	private ChatDAOImpl(){
		
	}
	
	public static ChatDAOImpl getInstance(){
		if (instance == null)
			instance = new ChatDAOImpl();
		return instance;
	}

	@Override
	public Chat insertChat(Long grupo, String from, String to, boolean leidofrom, boolean leidoto) {
		EntityManager em = EMFService.get().createEntityManager();		
		Chat chatObject = new Chat(grupo, from, to, new Text(""), leidofrom, leidoto);
				
		em.persist(chatObject);
		em.close();
		return chatObject;
	}

	@Override
	public List<Chat> getChatByFrom(String from) {
		EntityManager em = EMFService.get().createEntityManager();

		Query q = em.createQuery("SELECT m FROM Chat m WHERE m.from = :from");
		q.setParameter("from", from);
		@SuppressWarnings("unchecked")
		List<Chat> chats = q.getResultList();
		em.close();
		return chats;
	}

	@Override
	public List<Chat> getChatByTo(String to) {
		EntityManager em = EMFService.get().createEntityManager();

		Query q = em.createQuery("SELECT m FROM Chat m WHERE m.to = :to");
		q.setParameter("to", to);
		@SuppressWarnings("unchecked")
		List<Chat> chats = q.getResultList();
		em.close();
		return chats;
	}

	@Override
	public Chat getChatByFromAndGrupo(Long grupo, String from) {
		EntityManager em = EMFService.get().createEntityManager();

		Query q = em.createQuery("SELECT m FROM Chat m WHERE m.grupo = :grupo AND m.from = :from");
		q.setParameter("grupo", grupo);
		q.setParameter("from", from);
		Chat chat = (Chat) q.getSingleResult();
		em.close();
		return chat;
	}

	@Override
	public Chat getChatByToAndGrupo(Long grupo, String to) {
		EntityManager em = EMFService.get().createEntityManager();

		Query q = em.createQuery("SELECT m FROM Chat m WHERE m.grupo = :grupo AND m.to = :to");
		q.setParameter("grupo", grupo);
		q.setParameter("to", to);
		Chat chat = (Chat) q.getSingleResult();
		em.close();
		return chat;
	}

	@Override
	public Chat insertMensaje(Chat chat, String mensaje, String autor ) {
		EntityManager em = EMFService.get().createEntityManager();
		
		String conversacionchat = chat.getConversacion().getValue();
		conversacionchat = conversacionchat + autor + ": " +  mensaje + ";(•_•);" ;
		chat.setConversacion(new Text(conversacionchat));
		
		em.merge(chat);
		em.close();
		return chat;
	}

	@Override
	public void updateChat(Chat chat) {
		EntityManager em = EMFService.get().createEntityManager();
		
		em.merge(chat);
		em.close();
		return;		
	}

	@Override
	public List<Chat> getChatByGrupo(Long grupo) {
		EntityManager em = EMFService.get().createEntityManager();

		Query q = em.createQuery("SELECT m FROM Chat m WHERE m.grupo = :grupo");
		q.setParameter("grupo", grupo);
		@SuppressWarnings("unchecked")
		List<Chat> chats = q.getResultList();
		em.close();
		
		return chats;
	}

	@Override
	public void deleteChat(Chat chat) {
		EntityManager em = EMFService.get().createEntityManager();

		Query q = em.createQuery("SELECT m FROM Chat m WHERE m.id = :id");
		q.setParameter("id", chat.getId());
		Chat chatelim = (Chat) q.getSingleResult();
		
		em.remove(chatelim);
		em.close();
		return;
		
	}

}
