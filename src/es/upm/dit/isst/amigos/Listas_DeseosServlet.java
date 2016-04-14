package es.upm.dit.isst.amigos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.amigos.dao.*;
import es.upm.dit.isst.amigos.model.*;

@SuppressWarnings("serial")
public class Listas_DeseosServlet extends HttpServlet {
	
	ListasDeseosDAO dao = ListasDeseosDAOImpl.getInstance();
	UserService userservice = UserServiceFactory.getUserService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		if (req.getUserPrincipal() == null ){
			resp.getWriter().println("<p>No deberías estar aquí.</p>"
							+ "<a href=\"" + userservice.createLoginURL(req.getRequestURI()) +
                                     "\">Logueate</a> o <a href=\"\\\">vete</a>");
		}
		else{
			
			User usuario = UserDAOImpl.getInstance().getUserByEmail(userservice.getCurrentUser().getEmail());
			List<ListasDeseos> deseos = ListasDeseosDAOImpl.getInstance().getListaByUser(usuario.getEmail());
	
			req.getSession().setAttribute("deseos", new ArrayList<ListasDeseos>(deseos));
						
			resp.sendRedirect("deseos.jsp");
			
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {	
		String item = req.getParameter("item");
		String lock = req.getParameter("lock");
		String v = "true";
		String f = "false";
		boolean existe = true;
		
		if(lock.equals(v)) {
			
			try {
				dao.getItem(req.getUserPrincipal().toString(), item);
			}
			catch (Exception e) {
				existe = false;
			}
				
			if (existe == false) {				
			dao.insertLista(req.getUserPrincipal().toString(), item);
			}
			
			User usuario = UserDAOImpl.getInstance().getUserByEmail(userservice.getCurrentUser().getEmail());
			List<ListasDeseos> deseos = ListasDeseosDAOImpl.getInstance().getListaByUser(usuario.getEmail());

			req.getSession().setAttribute("deseos", new ArrayList<ListasDeseos>(deseos));
			resp.sendRedirect("deseos.jsp");
		}				
		
		if (lock.equals(f)) {
			
			ListasDeseos seleccion = dao.getItem(req.getUserPrincipal().toString(), item);
			
			if (item != null) {
				dao.removeLista(seleccion);
			}		
			
			User usuario = UserDAOImpl.getInstance().getUserByEmail(userservice.getCurrentUser().getEmail());
			List<ListasDeseos> deseos = ListasDeseosDAOImpl.getInstance().getListaByUser(usuario.getEmail());

			req.getSession().setAttribute("deseos", new ArrayList<ListasDeseos>(deseos));
			resp.sendRedirect("deseos.jsp");
		}
	}
}