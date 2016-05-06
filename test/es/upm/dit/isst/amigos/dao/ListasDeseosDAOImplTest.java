package es.upm.dit.isst.amigos.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import es.upm.dit.isst.amigos.model.ListasDeseos;

public class ListasDeseosDAOImplTest {

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	
	@Before
	public void setUp() {
		helper.setUp();
		
	}

	@After
	public void tearDown() {
		helper.tearDown();
    }

	@Test
	public void testInsertLista() {
		ListasDeseosDAOImpl listdao = ListasDeseosDAOImpl.getInstance();
		ListasDeseos lista = listdao.insertLista("Pepe", "Jamon");
		assertEquals(lista.getUser(), "Pepe");
		assertEquals(lista.getItem(), "Jamon");
	}

	@Test
	public void testGetListaByUser() {
		ListasDeseosDAOImpl listdao = ListasDeseosDAOImpl.getInstance();
		ListasDeseos lista = listdao.insertLista("Pepe", "Jamon");
		assertEquals(lista.getUser(), "Pepe");
		assertEquals(lista.getItem(), "Jamon");
		
		List<ListasDeseos> listas = listdao.getListaByUser("Pepe");
		assertEquals(listas.size(), 1);
		assertEquals(listas.get(0).getUser(), "Pepe");
		assertEquals(listas.get(0).getItem(), "Jamon");
		
		lista = listdao.insertLista("Juan", "PS7");
		listas = listdao.getListaByUser("Juan");
		assertEquals(listas.size(), 1);
		assertEquals(listas.get(0).getUser(), "Juan");
		assertEquals(listas.get(0).getItem(), "PS7");
		
		lista = listdao.insertLista("Pepe", "Pan");
		listas = listdao.getListaByUser("Pepe");
		assertEquals(listas.size(), 2);
		assertEquals(listas.get(0).getUser(), "Pepe");
		assertEquals(listas.get(0).getItem(), "Jamon");
		assertEquals(listas.get(1).getUser(), "Pepe");
		assertEquals(listas.get(1).getItem(), "Pan");
	}

	@Test
	public void testRemoveLista() {
		ListasDeseosDAOImpl listdao = ListasDeseosDAOImpl.getInstance();
		ListasDeseos lista = listdao.insertLista("Pepe", "Jamon");
		lista = listdao.insertLista("Juan", "PS7");
		listdao.removeLista(lista);
		List<ListasDeseos> listas = listdao.getListaByUser("Juan");
		assertEquals(listas.size(), 0);
		listas = listdao.getListaByUser("Pepe");
		assertEquals(listas.get(0).getUser(), "Pepe");
		assertEquals(listas.get(0).getItem(), "Jamon");
		
	}

	@Test
	public void testGetItem() {
		ListasDeseosDAOImpl listdao = ListasDeseosDAOImpl.getInstance();
		ListasDeseos lista = listdao.insertLista("Pepe", "Jamón");
		lista = listdao.insertLista("Juan", "PS7");
		lista = listdao.insertLista("Pepe", "Pan");
		assertEquals(listdao.getItem("Pepe", "Pan").getItem(), "Pan");
		assertEquals(listdao.getItem("Pepe", "Jamón").getItem(), "Jamón");
	}

}
