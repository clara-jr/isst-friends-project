package es.upm.dit.isst.amigos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.amigos.dao.*;
import es.upm.dit.isst.amigos.model.*;

@SuppressWarnings("serial")
public class ChatServlet extends HttpServlet {
	
	GrupoDAO dao = GrupoDAOImpl.getInstance();
	AgrupacionesDAO agrupao = AgrupacionesDAOImpl.getInstance();
	UserDAO usao = UserDAOImpl.getInstance();
	
	UserService userservice = UserServiceFactory.getUserService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		if (req.getUserPrincipal() == null ){
			resp.getWriter().println("<p>No deberías estar aquí.</p>"
							+ "<a href=\"" + userservice.createLoginURL(req.getRequestURI()) +
                                     "\">Logueate</a> o <a href=\"\\\">vete</a>");
		}
		
		else {
			
			User usuario = UserDAOImpl.getInstance().getUserByEmail(userservice.getCurrentUser().getEmail().toLowerCase(Locale.ENGLISH));
			List<Agrupaciones> agrupuser = AgrupacionesDAOImpl.getInstance().getAgrupacionesByUser(usuario.getNick());
			List<Grupo> grupos = new ArrayList<Grupo>();
	
			for (Agrupaciones temp: agrupuser){
				if (temp.getAmigoinv() != "")
					grupos.add(GrupoDAOImpl.getInstance().getGrupoById(temp.getGrupo()));
			}
			
			req.getSession().setAttribute("usuario", usuario);
			req.getSession().setAttribute("grupos", grupos);
						
			resp.sendRedirect("chat.jsp");		
			
		}
	}
}
