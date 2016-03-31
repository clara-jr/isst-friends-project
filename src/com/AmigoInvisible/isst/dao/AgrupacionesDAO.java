package com.AmigoInvisible.isst.dao;

import java.util.List;

import com.AmigoInvisible.isst.model.Agrupaciones;

public interface AgrupacionesDAO {
	
	// Devuelve el model, por si es necesario algun dato autogenerado.
	public Agrupaciones insertAgrupacion(String user, int grupo, String amigoinv);
	
	public List<Agrupaciones> getAgrupacionesByUser(String user);
	
	public List<Agrupaciones> getAgrupacionesByGrupo(int grupo);
	
	public List<Agrupaciones> getAgrupByUserAndGrupo(String user, int grupo);
	
}
