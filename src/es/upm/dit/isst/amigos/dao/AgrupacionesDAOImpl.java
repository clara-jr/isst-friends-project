package es.upm.dit.isst.amigos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.dit.isst.amigos.model.Agrupaciones;

public class AgrupacionesDAOImpl implements AgrupacionesDAO {

	private static AgrupacionesDAOImpl instance;
	
	private AgrupacionesDAOImpl(){
		
	}
	
	public static AgrupacionesDAOImpl getInstance(){
		if (instance == null)
			instance = new AgrupacionesDAOImpl();
		return instance;
	}
	
	// FALTA AÑADIR UN METODO PARA UPDATEAR UN ENTITY Y QUITAR SU AMIGO INVISIBLE
	
	@Override
	public Agrupaciones insertAgrupacion(String user, Long grupo, String amigoinv) {
		EntityManager em = EMFService.get().createEntityManager();
		Agrupaciones agrupObject = new Agrupaciones(user, grupo, amigoinv);
		em.persist(agrupObject);
		
		em.close();
		
		return agrupObject;
	}

	@Override
	public List<Agrupaciones> getAgrupacionesByUser(String user) {
		EntityManager em = EMFService.get().createEntityManager();

		Query q = em.createQuery("SELECT m FROM Agrupaciones m WHERE m.user = :user");
		q.setParameter("user", user);
		List<Agrupaciones> agrupaciones = q.getResultList();
		em.close();
		return agrupaciones;
	}

	@Override
	public List<Agrupaciones> getAgrupacionesByGrupo(Long grupo) {
		EntityManager em = EMFService.get().createEntityManager();

		Query q = em.createQuery("SELECT m FROM Agrupaciones m WHERE m.grupo = :grupo");
		q.setParameter("grupo", grupo);
		List<Agrupaciones> agrupaciones = q.getResultList();
		em.close();
		return agrupaciones;
	}

	@Override
	public List<Agrupaciones> getAgrupByUserAndGrupo(String user, int grupo) {
		EntityManager em = EMFService.get().createEntityManager();

		Query q = em.createQuery("SELECT m FROM Agrupaciones m WHERE m.user = :user AND m.grupo = :grupo");
		q.setParameter("grupo", grupo);
		q.setParameter("user", user);
		List<Agrupaciones> agrupaciones = q.getResultList();
		em.close();
		return agrupaciones;
	}

	
	@Override
	public void deleteAgrupacion(Agrupaciones agrupacion) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT m FROM Agrupaciones m WHERE m.id = :id");
		q.setParameter("id", agrupacion.getId());
		Agrupaciones agrupacionx = (Agrupaciones) q.getSingleResult();
		em.remove(em.contains(agrupacionx) ? agrupacionx : em.merge(agrupacionx));
		em.close();
	
	}

	@Override
	public void updateAgrupacion(Agrupaciones agrupacion) {
		EntityManager em = EMFService.get().createEntityManager();
		em.merge(agrupacion);
		em.close();
	}

}
