package es.upm.dit.isst.amigos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

import es.upm.dit.isst.amigos.dao.*;
import es.upm.dit.isst.amigos.model.*;
import es.upm.dit.isst.amigos.logic.*;

import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class CreadorGruposServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, NumberFormatException {
		
		try {
			Thread.sleep(400);
		} catch (InterruptedException e4) {
		}
		
		UserService userservice = UserServiceFactory.getUserService();
		String nickname = userservice.getCurrentUser().getNickname();
		
		String groupname = req.getParameter("groupname");
		String msg = req.getParameter("msg");
		String maxprice = req.getParameter("maxprice");
		String date = req.getParameter("date");
		String participants = req.getParameter("participants");
		int participants_int = Integer.parseInt(participants);
		boolean error = false;
		
		UserDAO userdao = UserDAOImpl.getInstance();
		GrupoDAO gruposdao = GrupoDAOImpl.getInstance();

		AgrupacionesDAO agrupdao = AgrupacionesDAOImpl.getInstance();			

		for(int i=1; i<=participants_int; i++) {
			if (req.getParameter("excl"+i) != "" ){
				try{
					Integer.valueOf(req.getParameter("excl"+i));
				}catch(Exception e){
					req.getSession().setAttribute("error", "¡Has introducido un valor no numérico en el campo de exclusiones!");
					resp.sendRedirect("avisos.jsp");
					error = true;
				}	
				try {
					if (Integer.parseInt(req.getParameter("excl"+i)) > participants_int || Integer.parseInt(req.getParameter("excl"+i)) <= 0) {				
						req.getSession().setAttribute("error", "¡Algún número en exclusiones no se corresponde con ningún participante!");
						resp.sendRedirect("avisos.jsp");
						error = true;
					}
				}
				catch (Exception e) {
				}				
			}
		}	
		if (error == false) {
			List<Integer> exclusioneslist = new ArrayList<Integer>();
			
			for(int i = 1; i <= participants_int; i++){
				exclusioneslist.add(Integer.valueOf(req.getParameter("excl"+i)));
			}
			for(int i = 0; i < participants_int; i++) {
				Integer numveces = Collections.frequency(exclusioneslist, exclusioneslist.get(i));
				if (numveces.equals(Integer.valueOf(participants_int))){
					resp.sendRedirect("https://www.youtube.com/watch?v=TJL4Y3aGPuA"); // TROLOLOLO
					return;
				} else if(numveces.equals(Integer.valueOf(participants_int - 1)) && exclusioneslist.get(exclusioneslist.get(i)).equals(exclusioneslist.get(i))){
					resp.sendRedirect("https://www.youtube.com/watch?v=TJL4Y3aGPuA"); // TROLOLOLO
					return;
				}
			}
			
			Grupo grupo = gruposdao.insertGrupo(groupname, nickname, maxprice, date, msg); 
			Long id = grupo.getId();
		for(int i=1; i<=participants_int; i++) {
			try { 
				User user = userdao.getUserByNick(req.getParameter("username"+i)); // Comprueba que los usuarios existen
				try {
					Agrupaciones testagr = agrupdao.getAgrupByUserAndGrupo(req.getParameter("username"+i), id);
				}
				catch (Exception e1) {

					agrupdao.insertAgrupacion(req.getParameter("username"+i), id, "", req.getParameter("username"+req.getParameter("excl"+i)));

				}
 
			} catch(Exception e2) {
				//userdao.insertUser(req.getParameter("username"+i), req.getParameter("username"+i)+"@gmail.com", "");
				try {
					Agrupaciones testagr = agrupdao.getAgrupByUserAndGrupo(req.getParameter("username"+i), id);
				}
				catch (Exception e1) {
					agrupdao.insertAgrupacion(req.getParameter("username"+i), id, "", req.getParameter("username"+req.getParameter("excl"+i)));
				}
				Functions.getInstance().aviso(req.getParameter("username"+i), nickname);
				continue;
			}
		}
		resp.sendRedirect("/Grupos");
	}
	}

}
