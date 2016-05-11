package es.upm.dit.isst.amigos.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import es.upm.dit.isst.amigos.dao.GrupoDAOImpl;
import es.upm.dit.isst.amigos.model.Grupo;

public class GrupoDAOImplTest {

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
	public void testInsertGrupo() {
		GrupoDAOImpl grupdao = GrupoDAOImpl.getInstance();
		Grupo grupo = grupdao.insertGrupo("GrupoX", "Mod", "20", "20-7", "Hola");
		assertEquals(grupo.getNombre(), "GrupoX");
		assertEquals(grupo.getModerador(), "Mod");
		assertEquals(grupo.getPreciomax(), "20");
		assertEquals(grupo.getFecha(), "20-7");
		assertEquals(grupo.getMsg(), "Hola");
	}

	@Test
	public void testGetGrupoById() {
		GrupoDAOImpl grupdao = GrupoDAOImpl.getInstance();
		Grupo grupo = grupdao.insertGrupo("GrupoX", "Mod", "20", "20-7", "Hola");
		Long id = grupo.getId();
		grupo = grupdao.insertGrupo("GrupoY", "Mod2", "30", "30-7", "Holi");
		assertEquals(grupdao.getGrupoById(id).getNombre(), "GrupoX");
		assertEquals(grupdao.getGrupoById(id).getModerador(), "Mod");
		assertEquals(grupdao.getGrupoById(id).getPreciomax(), "20");
	}

	@Test
	public void testGetGrupoByModerador() {
		GrupoDAOImpl grupdao = GrupoDAOImpl.getInstance();
		Grupo grupo = grupdao.insertGrupo("GrupoX", "Mod", "20", "20-7", "Hola");
		String mod = grupo.getModerador();
		grupo = grupdao.insertGrupo("GrupoY", "Mod2", "30", "30-7", "Holi");
		List<Grupo> grupos = grupdao.getGrupoByModerador(mod);
		assertEquals(grupos.get(0).getNombre(), "GrupoX");
		assertEquals(grupos.get(0).getModerador(), "Mod");
		assertEquals(grupos.get(0).getPreciomax(), "20");
	}

	@Test
	public void testDeleteGrupo() {
		GrupoDAOImpl grupdao = GrupoDAOImpl.getInstance();
		Grupo grupo = grupdao.insertGrupo("GrupoX", "Mod", "20", "20-7", "Hola");
		grupo = grupdao.insertGrupo("GrupoY", "Mod2", "30", "30-7", "Holi");
		grupo = grupdao.insertGrupo("GrupoZ", "Mod2", "30", "31-7", "Holi");
		Long id = grupo.getId();
		grupdao.deleteGrupo(grupo);
		try {
			assertEquals(grupdao.getGrupoById(id), null);
		} catch (Exception e) {
			assertEquals(true, true);
		}
	}

}
