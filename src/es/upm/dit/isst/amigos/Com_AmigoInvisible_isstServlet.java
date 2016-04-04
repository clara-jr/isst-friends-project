package es.upm.dit.isst.amigos;

import java.io.IOException;
import java.util.List;

import es.upm.dit.isst.amigos.dao.*;
import es.upm.dit.isst.amigos.model.*;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Com_AmigoInvisible_isstServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		UserDAOImpl userdao = UserDAOImpl.getInstance();
		LoginDAOImpl logindao = LoginDAOImpl.getInstance();
		ListasDeseosDAOImpl listasdao = ListasDeseosDAOImpl.getInstance();
		GrupoDAOImpl gruposdao = GrupoDAOImpl.getInstance();
		AgrupacionesDAOImpl agrupdao = AgrupacionesDAOImpl.getInstance();
		
		User user = userdao.insertUser("pepe", "pepe@peponcio.com", "");
		Login login = logindao.insertLogin("pepe", "mamon");
		ListasDeseos lista = listasdao.insertLista("pepe", "Un juguete");
		ListasDeseos lista2 = listasdao.insertLista("pepe", "Otro juguete");
		Grupo grupo = gruposdao.insertGrupo("robocop", "30 €", "5/5/2015");
		Agrupaciones agrup = agrupdao.insertAgrupacion("pepe", grupo.getId(), "robocock");
				
		User usuario = userdao.getUserByNick("pepe");
		Login log1 = logindao.getLoginByUser("pepe");
		//List<ListasDeseos> list1 = listasdao.getListaByUser("pepe");
		Grupo grup1 = gruposdao.getGrupoById(grupo.getId());
		List<Grupo> grup2 = gruposdao.getGrupoByModerador("robocop");
		List<Agrupaciones> agrup1 = agrupdao.getAgrupacionesByUser("pepe");
		
		
		
				
		resp.getWriter().println("Hello, world");
		
		resp.getWriter().println("Hola " + usuario.getNick());
		resp.getWriter().println("Email: " + usuario.toString());
		
		resp.getWriter().println("Ahora meteremos datos en la db y los mostraremos a continuación:");
		resp.getWriter().println("LOGIN:");
		resp.getWriter().println("" + login.getContraseña());
		resp.getWriter().println("" + login.getUser());
		resp.getWriter().println("LISTAS:");
		/*for(ListasDeseos temp: list1){
			resp.getWriter().println(temp.getUser());
			resp.getWriter().println(temp.getItem());
		}*/
		
		
	}
}
