package com.AmigoInvisible.isst.dao;

import java.util.List;

import com.AmigoInvisible.isst.model.Grupo;

public interface GrupoDAO {
	public Grupo insertGrupo(String moderador, String preciomax, String fecha);
	
	public Grupo getGrupoById(int id);
	
	public List<Grupo> getGrupoByModerador(String moderador);
}
