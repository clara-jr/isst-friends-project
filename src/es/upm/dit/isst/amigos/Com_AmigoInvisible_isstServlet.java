package es.upm.dit.isst.amigos;

import java.io.IOException;

import es.upm.dit.isst.amigos.dao.*;
import es.upm.dit.isst.amigos.model.*;

import javax.servlet.http.*;

import org.apache.tools.ant.taskdefs.Sleep;

@SuppressWarnings("serial")
public class Com_AmigoInvisible_isstServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");

		
		UserDAOImpl dao = UserDAOImpl.getInstance();
		
		dao.insertUser("Nacho1", "email1", "social1");
		dao.insertUser("Nacho2", "email2", "social2");
		dao.insertUser("Nacho3", "email3", "social3");
		dao.insertUser("Nacho4", "email4", "social4");
		

		ListasDeseosDAOImpl listasdao = ListasDeseosDAOImpl.getInstance();
		GrupoDAOImpl gruposdao = GrupoDAOImpl.getInstance();
		AgrupacionesDAOImpl agrupdao = AgrupacionesDAOImpl.getInstance();
		

		Grupo grupo1 = gruposdao.insertGrupo("prueba1", "nachoperegrino94", "30", "07/07/07");
		Grupo grupo2 = gruposdao.insertGrupo("prueba2", "nachoperegrino94", "30", "07/07/07");
		Grupo grupo3 = gruposdao.insertGrupo("prueba3", "pepe", "30", "07/07/07");
		Grupo grupo4 = gruposdao.insertGrupo("prueba4", "pepe", "30", "07/07/07");

		
		agrupdao.insertAgrupacion("pepe", grupo1.getId(), "", "");
		agrupdao.insertAgrupacion("lola", grupo1.getId(), "", "");
		agrupdao.insertAgrupacion("pepo", grupo1.getId(), "", "");
		agrupdao.insertAgrupacion("nachoperegrino94", grupo1.getId(), "", "");

		
		agrupdao.insertAgrupacion("pepe", grupo2.getId(), "lola", "");
		agrupdao.insertAgrupacion("lola", grupo2.getId(), "pepo", "");
		agrupdao.insertAgrupacion("pepo", grupo2.getId(), "test", "");
		agrupdao.insertAgrupacion("nachoperegrino94", grupo2.getId(), "pepe", "");
		
		agrupdao.insertAgrupacion("pepe", grupo3.getId(), "lola", "");
		agrupdao.insertAgrupacion("lola", grupo3.getId(), "pepo", "");
		agrupdao.insertAgrupacion("pepo", grupo3.getId(), "test", "");
		agrupdao.insertAgrupacion("nachoperegrino94", grupo3.getId(), "pepe", "");
		
		agrupdao.insertAgrupacion("pepe", grupo4.getId(), "", "");
		agrupdao.insertAgrupacion("lola", grupo4.getId(), "", "");
		agrupdao.insertAgrupacion("pepo", grupo4.getId(), "", "");
		agrupdao.insertAgrupacion("nachoperegrino94", grupo4.getId(), "", "");

		
		
		
		/*try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Agrupaciones prueba = agrupdao.getAgrupByUserAndGrupo("pepe", Long.valueOf(8557));
		
		
		
		prueba.setAmigoinv("nene");
		
		agrupdao.updateAgrupacion(prueba);*/
		
		
		/*
		ListasDeseos lista = listasdao.insertLista("nachoperegrino94", "Un juguete");
		ListasDeseos lista2 = listasdao.insertLista("nachoperegrino94", "Otro juguete");

		listasdao.insertLista("nachoperegrino94", "Un juguete");
		listasdao.insertLista("nachoperegrino94", "Otro juguete");
		listasdao.insertLista("clarajimenezrecio", "Un juguete");
		listasdao.insertLista("clarajimenezrecio", "Otro juguete");
		listasdao.insertLista("skyle94", "Un juguete");
		listasdao.insertLista("skyle94", "Otro juguete");

		Grupo grupo = gruposdao.insertGrupo("prueba","clarajimenezrecio", "30", "5/5/2015");
		agrupdao.insertAgrupacion("clarajimenezrecio", grupo.getId(), "nachoperegrino94", null);
		agrupdao.insertAgrupacion("nachoperegrino94", grupo.getId(), "skyle94", null);
		agrupdao.insertAgrupacion("skyle94", grupo.getId(), "clarajimenezrecio", null);
		Grupo grupo2 = gruposdao.insertGrupo("prueba2","nachoperegrino94", "60", "5/5/2016");
		agrupdao.insertAgrupacion("clarajimenezrecio", grupo2.getId(), "skyle94", null);
		agrupdao.insertAgrupacion("nachoperegrino94", grupo2.getId(), "clarajimenezrecio", null);
		agrupdao.insertAgrupacion("skyle94", grupo2.getId(), "nachoperegrino94", null);
		
		resp.getWriter().println("Hello, world");
		*/
	}
}
