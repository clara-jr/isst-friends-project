package com.AmigoInvisible.isst.dao;

import java.util.List;

import com.AmigoInvisible.isst.model.ListasDeseos;

public interface ListasDeseosDAO {
	public ListasDeseos insertLista(String user, String item);
	
	public List<ListasDeseos> getListaByUser(String user);
}
