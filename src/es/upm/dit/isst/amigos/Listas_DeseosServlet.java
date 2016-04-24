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
			List<ListasDeseos> deseos = ListasDeseosDAOImpl.getInstance().getListaByUser(usuario.getNick());
	
			req.getSession().setAttribute("deseos", new ArrayList<ListasDeseos>(deseos));
						
			resp.sendRedirect("deseos.jsp");
			
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {	
		String item = req.getParameter("item");
		String lock = req.getParameter("lock");
		String v = "true";
		String f = "false";
		
		if(lock.equals(v)) {
			try {
				dao.getItem(userservice.getCurrentUser().getNickname(), item);
				req.getSession().setAttribute("error", "¡Ese deseo ya está en la lista!");
				resp.sendRedirect("avisos.jsp");
			}
			catch (Exception e) {
				dao.insertLista(userservice.getCurrentUser().getNickname(), item);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
				}
				resp.sendRedirect("/listas_deseos");
			}			
		}				
		
		if (lock.equals(f)) {
			ListasDeseos seleccion = dao.getItem(userservice.getCurrentUser().getNickname(), item);
			
			if (item != null) {
				dao.removeLista(seleccion);
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
			}
			resp.sendRedirect("/listas_deseos");
		}
	}
}