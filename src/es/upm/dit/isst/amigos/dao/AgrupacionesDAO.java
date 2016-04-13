package es.upm.dit.isst.amigos.dao;

import java.util.List;

import es.upm.dit.isst.amigos.model.Agrupaciones;

public interface AgrupacionesDAO {
	
	// Devuelve el model, por si es necesario algun dato autogenerado.
	public Agrupaciones insertAgrupacion(String user, Long grupo, String amigoinv);
	
	public void deleteAgrupacion(Agrupaciones agrupacion);
	
	public void deleteListaAgrupaciones(List<Agrupaciones> lista);
	
	public List<Agrupaciones> getAgrupacionesByUser(String user);
	
	public List<Agrupaciones> getAgrupacionesByGrupo(Long grupo);
	
	public List<Agrupaciones> getAgrupByUserAndGrupo(String user, int grupo);
}
