package es.upm.dit.isst.amigos.dao;

import java.util.List;

import es.upm.dit.isst.amigos.model.ListasDeseos;

public interface ListasDeseosDAO {
	public ListasDeseos insertLista(String user, String item);
	
	public List<ListasDeseos> getListaByUser(String user);
}
