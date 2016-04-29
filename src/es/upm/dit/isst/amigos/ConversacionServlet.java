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
public class ConversacionServlet extends HttpServlet {
	
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
			
			// TODO: Conseguir conversación y pasarla con setAttribute
			
			resp.sendRedirect("conversacion.jsp");
			
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		req.getSession().setAttribute("error", "¡Mensaje enviado!");
		resp.sendRedirect("avisos.jsp");	
	}
}
