package es.upm.dit.isst.amigos.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import es.upm.dit.isst.amigos.dao.AgrupacionesDAOImpl;
import es.upm.dit.isst.amigos.model.Agrupaciones;

public class AgrupacionesDAOImplTest {

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
	public void testModel() {
		Long grupo = (long) 1;
		AgrupacionesDAOImpl agrupao = AgrupacionesDAOImpl.getInstance();
		Agrupaciones agrup = agrupao.insertAgrupacion("Pepe", grupo, "Amigo", "");
		assertEquals(agrup.getUser(), "Pepe");
		assertEquals(agrup.getGrupo(), grupo);
		assertEquals(agrup.getExclusion(), "");
		assertEquals(agrup.getAmigoinv(), "Amigo");
		agrupao.deleteAgrupacion(agrup);
	}
	
	@Test
	public void testGetters() {
		Long grupo = (long) 1;
		AgrupacionesDAOImpl agrupao = AgrupacionesDAOImpl.getInstance();
		agrupao.insertAgrupacion("Pepe", grupo, "Amigo", "");
		assertEquals(agrupao.getAgrupByUserAndGrupo("Pepe", grupo).getGrupo(), grupo);
		assertEquals(agrupao.getAgrupByUserAndGrupo("Pepe", grupo).getUser(), "Pepe");
		assertEquals(agrupao.getAgrupByUserAndGrupo("Pepe", grupo).getAmigoinv(), "Amigo");
		
		List<Agrupaciones> agrups = agrupao.getAgrupacionesByGrupo(grupo);
		assertEquals(agrups.size(), 1);
		assertEquals(agrups.get(0).getGrupo(), grupo);
		assertEquals(agrups.get(0).getUser(), "Pepe");
		agrupao.insertAgrupacion("Amigo", grupo, "Pepe", "");
		agrups = agrupao.getAgrupacionesByGrupo(grupo);
		assertEquals(agrups.size(), 2);
		assertEquals(agrups.get(0).getGrupo(), grupo);
		assertEquals(agrups.get(0).getUser(), "Pepe");
		assertEquals(agrups.get(1).getGrupo(), grupo);
		assertEquals(agrups.get(1).getUser(), "Amigo");
		
		agrups = agrupao.getAgrupacionesByUser("Pepe");
		assertEquals(agrups.size(), 1);
		assertEquals(agrups.get(0).getGrupo(), grupo);
		assertEquals(agrups.get(0).getUser(), "Pepe");
		agrups = agrupao.getAgrupacionesByUser("Amigo");
		assertEquals(agrups.size(), 1);
		assertEquals(agrups.get(0).getGrupo(), grupo);
		assertEquals(agrups.get(0).getUser(), "Amigo");
	}
	
	@Test
	public void testUpdate() {
		Long grupo = (long) 1;
		AgrupacionesDAOImpl agrupao = AgrupacionesDAOImpl.getInstance();
		Agrupaciones agrup = agrupao.insertAgrupacion("Pepe", grupo, "Amigo", "");
		agrup = agrupao.insertAgrupacion("Amigo", grupo, "Pepe", "");
		List<Agrupaciones> agrups = agrupao.getAgrupacionesByGrupo(grupo);
		assertEquals(agrups.size(), 2);
		assertEquals(agrups.get(0).getGrupo(), grupo);
		assertEquals(agrups.get(0).getUser(), "Pepe");
		assertEquals(agrups.get(1).getGrupo(), grupo);
		assertEquals(agrups.get(1).getUser(), "Amigo");
		agrupao.updateAgrupacion(agrup);
		//TO DO
	}

}
