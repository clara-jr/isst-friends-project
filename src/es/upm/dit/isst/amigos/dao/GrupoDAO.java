package es.upm.dit.isst.amigos.dao;

import java.util.List;

import es.upm.dit.isst.amigos.model.Grupo;

public interface GrupoDAO {
	public Grupo insertGrupo(String nombre, String moderador, String preciomax, String fecha);
	
	public Grupo getGrupoById(Long id);
	
	public List<Grupo> getGrupoByModerador(String moderador);
	
	public void deleteGrupo(Grupo grupo);
}
