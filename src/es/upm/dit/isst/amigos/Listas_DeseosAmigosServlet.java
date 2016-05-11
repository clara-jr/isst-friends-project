package es.upm.dit.isst.amigos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.amigos.dao.*;
import es.upm.dit.isst.amigos.logic.Functions;
import es.upm.dit.isst.amigos.model.*;

@SuppressWarnings("serial")
public class Listas_DeseosAmigosServlet extends HttpServlet {
	
	ListasDeseosDAO dao = ListasDeseosDAOImpl.getInstance();
	UserService userservice = UserServiceFactory.getUserService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		if (req.getUserPrincipal() == null ){
			resp.getWriter().println("<p>No deberías estar aquí.</p>"
							+ "<a href=\"" + userservice.createLoginURL(req.getRequestURI()) +
                                     "\">Logueate</a> o <a href=\"\\\">vete</a>");
		}
		else{
			
			User usuario = UserDAOImpl.getInstance().getUserByEmail(userservice.getCurrentUser().getEmail().toLowerCase(Locale.ENGLISH));
			
			List<Agrupaciones> agrupuser = AgrupacionesDAOImpl.getInstance().getAgrupacionesByUser(usuario.getNick());
			
			List<ListasDeseos> deseos_inv = new ArrayList<ListasDeseos>();
			List<ListasDeseos> deseos_v = new ArrayList<ListasDeseos>();
			List<User> usuarios_inv = new ArrayList<User>();
			List<User> usuarios_v = new ArrayList<User>();
	
			for (Agrupaciones temp: agrupuser){
				if (temp.getAmigoinv() != "") {
					if (GrupoDAOImpl.getInstance().getGrupoById(temp.getGrupo()).getModerador().equals(userservice.getCurrentUser().getNickname().toLowerCase(Locale.ENGLISH))) {
						List<Agrupaciones> usersingroup = AgrupacionesDAOImpl.getInstance().getAgrupacionesByGrupo(temp.getGrupo());
						for (Agrupaciones temp2: usersingroup){
							if (!usuarios_v.contains(UserDAOImpl.getInstance().getUserByNick(temp2.getUser())) && !usuarios_inv.contains(UserDAOImpl.getInstance().getUserByNick(temp2.getUser())) && !temp2.getUser().equals(userservice.getCurrentUser().getNickname().toLowerCase(Locale.ENGLISH))) {
								deseos_v.addAll(ListasDeseosDAOImpl.getInstance().getListaByUser(temp2.getUser()));
								usuarios_v.add(UserDAOImpl.getInstance().getUserByNick(temp2.getUser()));
							}
						}
					}
					else {
						if (temp.getUser().equals(userservice.getCurrentUser().getNickname().toLowerCase(Locale.ENGLISH))) {
							if (!usuarios_inv.contains(UserDAOImpl.getInstance().getUserByNick(temp.getAmigoinv())) && !usuarios_v.contains(UserDAOImpl.getInstance().getUserByNick(temp.getAmigoinv()))) {
								deseos_inv.addAll(ListasDeseosDAOImpl.getInstance().getListaByUser(temp.getAmigoinv()));
								usuarios_inv.add(UserDAOImpl.getInstance().getUserByNick(temp.getAmigoinv()));
							}
						}
					}
				}
			}
			
			req.getSession().setAttribute("deseos_inv", deseos_inv); // deseos de los usuarios invisibles
			req.getSession().setAttribute("deseos_v", deseos_v); // deseos de los usuarios visibles por ser moderador
			req.getSession().setAttribute("usuarios_inv", usuarios_inv);
			req.getSession().setAttribute("usuarios_v", usuarios_v);
						
			resp.sendRedirect("amigos.jsp");
			
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {	
		String item = req.getParameter("item");
		String user = req.getParameter("user");
		ListasDeseos seleccion = dao.getItem(user, item);
		if (item != null) {
			dao.removeLista(seleccion);
			Functions.getInstance().aviso_eliminado(user, item, userservice.getCurrentUser().getNickname().toLowerCase(Locale.ENGLISH));
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
		}
		resp.sendRedirect("/listas_deseos_amigos");
	}
}