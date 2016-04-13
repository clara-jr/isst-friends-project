package es.upm.dit.isst.amigos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.amigos.dao.*;
import es.upm.dit.isst.amigos.model.*;

@SuppressWarnings("serial")
public class VerGruposServlet extends HttpServlet {
	/**
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserService userservice = UserServiceFactory.getUserService();
		if (req.getUserPrincipal() == null ){
			resp.getWriter().println("<p>No deberías estar aquí.</p>"
							+ "<a href=\"" + userservice.createLoginURL(req.getRequestURI()) +
                                     "\">Logueate</a> o <a href=\"\\\">vete</a>");
		}
		else{
			
			User usuario = UserDAOImpl.getInstance().getUserByEmail(userservice.getCurrentUser().getEmail());
			List<Agrupaciones> agrupuser = AgrupacionesDAOImpl.getInstance().getAgrupacionesByUser(usuario.getNick());
			List<Grupo> grupos = new ArrayList<Grupo>();
			HashMap<Long, Agrupaciones[] > agrupacionesporgrupo = new HashMap<Long, Agrupaciones[] >();
			
	
			for (Agrupaciones temp: agrupuser){
				grupos.add(GrupoDAOImpl.getInstance().getGrupoById(temp.getGrupo()));
				List<Agrupaciones> agrupacionesdelgrupo = AgrupacionesDAOImpl.getInstance().getAgrupacionesByGrupo(temp.getGrupo());
				agrupacionesporgrupo.put(temp.getGrupo(), agrupacionesdelgrupo.toArray(new Agrupaciones[agrupacionesdelgrupo.size()]));
			}
			
			req.getSession().setAttribute("usuario", usuario);
			req.getSession().setAttribute("grupos", grupos);
			req.getSession().setAttribute("agrupaciones", agrupacionesporgrupo);
						
			resp.sendRedirect("grupos.jsp");
			
				
			
		}
	}
}
