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
public class DeseosServlet extends HttpServlet {
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
			List<ListasDeseos> deseos = ListasDeseosDAOImpl.getInstance().getListaByUser(usuario.getNick());
	
			req.getSession().setAttribute("deseos", deseos);
						
			resp.sendRedirect("deseos.jsp");
			
		}
	}
}
