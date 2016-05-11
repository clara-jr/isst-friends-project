package es.upm.dit.isst.amigos.test.logic;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import es.upm.dit.isst.amigos.logic.Functions;

public class FunctionsTest {

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
	public void testRandomize() {
		String[] usernames = {"Pepe", "Juan", "Jorge", "Jaimito"};
		String[] randomizedArray = Functions.getInstance().Randomize(usernames);
		int repetidos = 0;
		for(int i = 0; i < randomizedArray.length; i++){
			for(int j = i+1; j < randomizedArray.length; j++){
				if(randomizedArray[i].equals(randomizedArray[j])) repetidos++;
			}
		}
		assertEquals(0, repetidos);
	}

	@Test
	public void testAsignador() {
		String[] usernames = {"Pepe", "Juan", "Jorge", "Jaimito", "María"};
		String[] usernames_excls = {"", "Pepe", "", "Jorge", ""};
		String[] randomizedArray = Functions.getInstance().asignador(usernames, usernames_excls);
		int err_excl = 0;
		int repetidos = 0;
		for(int i = 0; i < randomizedArray.length-1; i++){
			for(int j = i+1; j < randomizedArray.length; j++){
				if(randomizedArray[i].equals(randomizedArray[j])) repetidos++;
			}
			int index = Arrays.asList(usernames).indexOf(randomizedArray[i]);
			if(usernames_excls[index].equals(randomizedArray[i+1])) err_excl++;
		}
		int index = Arrays.asList(usernames).indexOf(randomizedArray[randomizedArray.length-1]);
		if(usernames_excls[index].equals(randomizedArray[0])){
			err_excl++;
		}
		assertEquals(0, repetidos); //Comprueba nombres repetidos
		assertEquals(0, err_excl); //Comprueba fallos en la exclusión
		
		String[] usernames_excls2 = {"Juan", "Pepe", "María", "Jorge", "Jaimito"};
		String[] randomizedArray2 = Functions.getInstance().asignador(usernames, usernames_excls2);
		int err_excl2 = 0;
		int repetidos2 = 0;
		for(int i = 0; i < randomizedArray2.length-1; i++){
			for(int j = i+1; j < randomizedArray2.length; j++){
				if(randomizedArray2[i].equals(randomizedArray2[j])) repetidos2++;
			}
			index = Arrays.asList(usernames).indexOf(randomizedArray2[i]);
			if(usernames_excls2[index].equals(randomizedArray2[i+1])){
				err_excl2++;
			}
		}
		index = Arrays.asList(usernames).indexOf(randomizedArray2[randomizedArray2.length-1]);
		if(usernames_excls2[index].equals(randomizedArray2[0])){
			err_excl2++;
		}
		assertEquals(0, repetidos2); //Comprueba nombres repetidos
		assertEquals(0, err_excl2); //Comprueba fallos en la exclusión
	}

	/*@Test
	public void testEnviarEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testAviso() {
		fail("Not yet implemented");
	}

	@Test
	public void testAviso_eliminado() {
		fail("Not yet implemented");
	}*/

}
