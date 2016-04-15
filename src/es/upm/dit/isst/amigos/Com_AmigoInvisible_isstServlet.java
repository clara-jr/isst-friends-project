package es.upm.dit.isst.amigos;

import java.io.IOException;

import es.upm.dit.isst.amigos.dao.*;
import es.upm.dit.isst.amigos.model.*;

import javax.servlet.http.*;

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
		
		
		/*ListasDeseosDAOImpl listasdao = ListasDeseosDAOImpl.getInstance();
		GrupoDAOImpl gruposdao = GrupoDAOImpl.getInstance();
		AgrupacionesDAOImpl agrupdao = AgrupacionesDAOImpl.getInstance();
		
		ListasDeseos lista = listasdao.insertLista("nachoperegrino94", "Un juguete");
		ListasDeseos lista2 = listasdao.insertLista("nachoperegrino94", "Otro juguete");
		Grupo grupo = gruposdao.insertGrupo("prueba","clarajimenezrecio", "30", "5/5/2015");
		Agrupaciones agrup = agrupdao.insertAgrupacion("clarajimenezrecio", grupo.getId(), "");
		agrupdao.insertAgrupacion("nachoperegrino94", grupo.getId(), "");
		agrupdao.insertAgrupacion("Linda", grupo.getId(), "");
		agrupdao.insertAgrupacion("Javier", grupo.getId(), "");
		agrupdao.insertAgrupacion("Penelope", grupo.getId(), ""); */
		
		
				
		/*User usuario = userdao.getUserByNick("nachoperegrino94");
		//Login log1 = logindao.getLoginByUser("nachoperegrino94");
		List<ListasDeseos> list1 = listasdao.getListaByUser("nachoperegrino94");
		Grupo grup1 = gruposdao.getGrupoById(grupo.getId());
		
		//List<Grupo> grup2 = gruposdao.getGrupoByModerador("nachoperegrino94");
		List<Agrupaciones> agrup1 = agrupdao.getAgrupacionesByUser("nachoperegrino94");
		Grupo grup3 = gruposdao.getGrupoById(agrup1.get(0).getGrupo());*/
		
		
				
		resp.getWriter().println("Hello, world");
		/*resp.getWriter().println("Hola " + usuario.getNick());
		resp.getWriter().println("Email: " + usuario.toString());
		
		resp.getWriter().println("Ahora meteremos datos en la db y los mostraremos a continuación:");
		resp.getWriter().println("LOGIN:");
		resp.getWriter().println("LISTAS:");
		for(ListasDeseos temp: list1){
			resp.getWriter().println(temp.getUser());
			resp.getWriter().println(temp.getItem());
		}
		resp.getWriter().println("GRUPOS:");*/
		//resp.getWriter().println(grup1.getFecha());
		//resp.getWriter().println(grup1.getModerador());
		//resp.getWriter().println(grup1.getPreciomax());
		
		/*for(Grupo temp: grup2){
			resp.getWriter().println(temp.getFecha());
			resp.getWriter().println(temp.getModerador());
			resp.getWriter().println(temp.getPreciomax());
			resp.getWriter().println(temp.getId());
		}
		
		resp.getWriter().println("AGRUPACIONES:");
		for(Agrupaciones temp: agrup1){
			resp.getWriter().println(temp.getAmigoinv());
			resp.getWriter().println(temp.getUser());
			resp.getWriter().println(temp.getGrupo());
			resp.getWriter().println(temp.getId());
		}*/


	}
}
