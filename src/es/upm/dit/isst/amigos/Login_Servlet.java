package es.upm.dit.isst.amigos;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.amigos.dao.UserDAO;
import es.upm.dit.isst.amigos.dao.UserDAOImpl;

@SuppressWarnings("serial")
public class Login_Servlet extends HttpServlet {
	UserDAO dao = UserDAOImpl.getInstance();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Iniciar Sesión";
		String user = "";
		String nick = "";
		
		if (req.getUserPrincipal() != null){
			user = req.getUserPrincipal().getName();
			url = userService.createLogoutURL(req.getRequestURI());
			urlLinktext = "Cerrar Sesión";
			if (dao.getUserByEmail(user) == null) {
				nick = userService.getCurrentUser().getNickname();
				dao.insertUser(nick,user,""); //TO DO: QUITAR PARAMETRO DE PERFIL SOCIAL. 
			}
		}
		
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("url", url);
		req.getSession().setAttribute("urlLinktext", urlLinktext);
		req.getSession().setAttribute("nick", nick);
			
		//Para redirigir el flujo de ejecucion de un servlet de control a un JSP:
		resp.sendRedirect("grupos.jsp");
	}
}