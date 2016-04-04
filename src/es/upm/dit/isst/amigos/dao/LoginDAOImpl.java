package es.upm.dit.isst.amigos.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.dit.isst.amigos.model.Login;

public class LoginDAOImpl implements LoginDAO {

	private static LoginDAOImpl instance;
	
	private LoginDAOImpl(){
		
	}
	
	public static LoginDAOImpl getInstance(){
		if (instance == null)
			instance = new LoginDAOImpl();
		return instance;
	}
	
	@Override
	public Login insertLogin(String user, String contraseña) {
		EntityManager em = EMFService.get().createEntityManager();
		Login loginObject = new Login(user, contraseña);
		em.persist(loginObject);
		
		em.close();
		
		return loginObject;
	}

	@Override
	public Login getLoginByUser(String user) {
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("SELECT m FROM Login m WHERE m.user = :user");
		q.setParameter("user", user);
		Login logueo = (Login) q.getSingleResult();
		em.close();
		return logueo;
	}

}
