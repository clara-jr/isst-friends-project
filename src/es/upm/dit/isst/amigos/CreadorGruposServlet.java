package es.upm.dit.isst.amigos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Properties;

import es.upm.dit.isst.amigos.dao.*;
import es.upm.dit.isst.amigos.model.*;

import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class CreadorGruposServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		UserService userservice = UserServiceFactory.getUserService();
		String nickname = userservice.getCurrentUser().getNickname();
		
		String groupname = req.getParameter("groupname");
		String maxprice = req.getParameter("maxprice");
		String date = req.getParameter("date");
		String participants = req.getParameter("participants");
		int participants_int = Integer.parseInt(participants);
		
		UserDAO userdao = UserDAOImpl.getInstance();
		GrupoDAO gruposdao = GrupoDAOImpl.getInstance();
		AgrupacionesDAO agrupdao = AgrupacionesDAOImpl.getInstance();		
		
		Grupo grupo = gruposdao.insertGrupo(groupname, nickname, maxprice, date);
		Long id = grupo.getId();
		for(int i=1; i<=participants_int; i++) {
			try { 
				User user = userdao.getUserByNick(req.getParameter("username"+i)); // Comprueba que los usuarios existen
				try {
					Agrupaciones testagr = agrupdao.getAgrupByUserAndGrupo(req.getParameter("username"+i), id);
				}
				catch (Exception e1) {
					agrupdao.insertAgrupacion(req.getParameter("username"+i), id, "");
				}
 
			} catch(Exception e2) {
				continue;
			}
		}
		
		resp.sendRedirect("/Grupos");
	}
}