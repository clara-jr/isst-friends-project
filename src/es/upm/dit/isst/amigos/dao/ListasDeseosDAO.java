package es.upm.dit.isst.amigos.dao;

import java.util.List;

import es.upm.dit.isst.amigos.model.ListasDeseos;

public interface ListasDeseosDAO {
	public ListasDeseos insertLista(String user, String item);
	
	public ListasDeseos getItem(String user, String item);
	
	public void removeLista(ListasDeseos lista);
	
	public List<ListasDeseos> getListaByUser(String user);
}
