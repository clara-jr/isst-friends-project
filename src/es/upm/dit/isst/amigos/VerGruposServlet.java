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
import es.upm.dit.isst.amigos.logic.*;

@SuppressWarnings("serial")
public class VerGruposServlet extends HttpServlet {
	/**
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	
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
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {	

		String user = req.getParameter("usuario");
		Long id = Long.valueOf(req.getParameter("grupo_id"));
		String lock = req.getParameter("lock");
		String item = req.getParameter("item");
		
		UserService userservice = UserServiceFactory.getUserService();
		String nickname = userservice.getCurrentUser().getNickname();

		String v = "true";
		String f = "false";
		
		if(lock.equals(v)) {
			
			if (item.equals("Rick Astley")) {
				resp.sendRedirect("https://www.youtube.com/watch?v=dQw4w9WgXcQ"); // NEVER GONNA GIVE YOU UP!
			}
			
			try {
				User prueba = usao.getUserByNick(item);
				agrupao.insertAgrupacion(item, id, "");
			}
			catch (Exception e) {
				// Si no está registrado, lo registramos y le mandamos un correo informativo con un link al login de google
				usao.insertUser(item, item+"@gmail.com", "");
				Functions.getInstance().aviso(item, nickname);
			}
						
			resp.sendRedirect("/Grupos");	
		}				
		
		if (lock.equals(f)) {
			
			Agrupaciones seleccion = agrupao.getAgrupByUserAndGrupo(user, id);
			
			agrupao.deleteAgrupacion(seleccion);
						
			resp.sendRedirect("/Grupos");		
		}
	}
}
