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

		ListasDeseosDAOImpl listasdao = ListasDeseosDAOImpl.getInstance();
		GrupoDAOImpl gruposdao = GrupoDAOImpl.getInstance();
		AgrupacionesDAOImpl agrupdao = AgrupacionesDAOImpl.getInstance();
		
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
	}
}
