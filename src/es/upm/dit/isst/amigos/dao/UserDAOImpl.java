package es.upm.dit.isst.amigos.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.dit.isst.amigos.model.User;
import es.upm.dit.isst.amigos.dao.EMFService;

public class UserDAOImpl implements UserDAO {

	private static UserDAOImpl instance;
	
	private UserDAOImpl(){
		
	}
	
	public static UserDAOImpl getInstance(){
		if (instance == null)
			instance = new UserDAOImpl();
		return instance;
	}
	
	@Override
	public User insertUser(String nick, String email, String perfilsocial) {
		EntityManager em = EMFService.get().createEntityManager();
		User userObject = new User(nick, email, perfilsocial);
		em.persist(userObject);
		
		em.close();
		
		return userObject;
	}

	@Override
	public User getUserByNick(String nick) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("SELECT m FROM User m WHERE m.nick=:nick");
		q.setParameter("nick", nick);
		User usuario = (User) q.getSingleResult();
		em.close();
		return usuario;
	}

	@Override
	public User getUserByEmail(String email) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("SELECT m FROM User m WHERE m.email = :email");
		q.setParameter("email", email);
		User usuario = (User) q.getSingleResult();
		em.close();
		return usuario;

	}

	@Override
	public User getUserByPerfilSocial(String perfilsocial) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("SELECT m FROM User m WHERE m.perfilsocial = :perfilsocial");
		q.setParameter("perfilsocial", perfilsocial);
		User usuario = (User) q.getSingleResult();
		em.close();
		return usuario;
	}

}
