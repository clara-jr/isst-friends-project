package es.upm.dit.isst.amigos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.amigos.dao.UserDAO;
import es.upm.dit.isst.amigos.dao.UserDAOImpl;

@SuppressWarnings("serial")
public class Login_final_Servlet extends HttpServlet {
	UserDAO dao = UserDAOImpl.getInstance();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		UserService userService = UserServiceFactory.getUserService();
		String email = userService.getCurrentUser().getEmail();
		String nick = userService.getCurrentUser().getNickname();
		
		dao.insertUser(nick, email, "");
		
		resp.sendRedirect("/Grupos");
	}
}
