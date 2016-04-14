package es.upm.dit.isst.amigos;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;



@SuppressWarnings("serial")
public class Login_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");

		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL("/login_final");

		if (req.getUserPrincipal() != null){
			url = userService.createLogoutURL("/index");
		}

		resp.sendRedirect(url);
	}
}
