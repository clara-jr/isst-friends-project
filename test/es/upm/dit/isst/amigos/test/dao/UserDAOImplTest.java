package es.upm.dit.isst.amigos.test.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import es.upm.dit.isst.amigos.dao.UserDAOImpl;
import es.upm.dit.isst.amigos.model.User;

public class UserDAOImplTest {

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
	public void testInsertUser() {
		UserDAOImpl userdao = UserDAOImpl.getInstance();
		User user = userdao.insertUser("Pepe", "pepe666", "");
		assertEquals(user.getNick(), "Pepe");
		assertEquals(user.getEmail(), "pepe666");
		assertEquals(user.getPerfilsocial(), "");
	}

	@Test
	public void testGetUserByNick() {
		UserDAOImpl userdao = UserDAOImpl.getInstance();
		userdao.insertUser("Pepe", "pepe666", "");
		userdao.insertUser("Juan", "juanito69", "");
		assertEquals(userdao.getUserByNick("Pepe").getNick(), "Pepe");
		assertEquals(userdao.getUserByNick("Pepe").getEmail(), "pepe666");
		assertEquals(userdao.getUserByNick("Pepe").getPerfilsocial(), "");
	}

	@Test
	public void testGetUserByEmail() {
		UserDAOImpl userdao = UserDAOImpl.getInstance();
		userdao.insertUser("Pepe", "pepe666", "");
		userdao.insertUser("Juan", "juanito69", "");
		assertEquals(userdao.getUserByEmail("pepe666").getNick(), "Pepe");
		assertEquals(userdao.getUserByEmail("pepe666").getEmail(), "pepe666");
		assertEquals(userdao.getUserByEmail("pepe666").getPerfilsocial(), "");
	}
}
