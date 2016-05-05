package es.upm.dit.isst.amigos;
/**
 * @author Clara
 *
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.*;

import es.upm.dit.isst.amigos.logic.*;

@SuppressWarnings("serial")
public class Logica_SorteoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String mod_name = req.getParameter("mod_name");
		String money = req.getParameter("money");
		String date = req.getParameter("date");
		String msg = req.getParameter("msg");
		String participants = req.getParameter("participants");
		int participants_int = Integer.parseInt(participants);
		String[] usernames = new String[participants_int];
		String[] emails = new String[participants_int];
		String[] usernames_excls = new String[participants_int];
		for(int i=1; i<=participants_int; i++) {
			usernames[i-1] = req.getParameter("username"+i);
			emails[i-1] = req.getParameter("email"+i);
		}
		for(int i = 0; i < usernames.length; i++){
			for(int j = i+1; j < usernames.length; j++){
				if(usernames[i].equals(usernames[j])){
					req.getSession().setAttribute("error", "¡Has introducido dos nombres iguales en los participantes!");
					resp.sendRedirect("avisos.jsp");
					return;
				}
			}
		}
		for(int i = 0; i < emails.length; i++){
			for(int j = i+1; j < emails.length; j++){
				if(emails[i].equals(emails[j])){
					req.getSession().setAttribute("error", "¡Has introducido dos emails iguales!");
					resp.sendRedirect("avisos.jsp");
					return;
				}
			}
		}
		boolean emptyInput = false;
		int contExcl = 0;
		for(int i=1; i<=participants_int; i++) {			
			try{
				Integer.valueOf(req.getParameter("excl"+i));
			}catch(Exception e){
				usernames_excls[i-1] = "";
				emptyInput = true;
				/*req.getSession().setAttribute("error", "¡Has introducido un valor no numérico en el campo de exclusiones!");
				resp.sendRedirect("avisos.jsp");
				return;*/
			}
			/*if (Integer.parseInt(req.getParameter("excl"+i)) > participants_int || Integer.parseInt(req.getParameter("excl"+i)) <= 0){
				req.getSession().setAttribute("error", "¡Algún número en exclusiones no se corresponde con ningún participante!");
				resp.sendRedirect("avisos.jsp");
				return;
			}*/
			
			if (!emptyInput) {
				usernames_excls[i-1] = usernames[Integer.parseInt(req.getParameter("excl"+i)) - 1];
				if (i > 1 && usernames_excls[i-1].equals(usernames_excls[i-2])) {
					contExcl++;
				}	
			}
			emptyInput = false;
		}
		if (contExcl == (participants_int - 1)){ //Todos excluyen al mismo
			resp.sendRedirect("https://www.youtube.com/watch?v=TJL4Y3aGPuA"); // TROLOLOLO
		}

		String[] randomizedArray = Functions.getInstance().asignador(usernames, usernames_excls);
		try {
			if (randomizedArray.equals(null)) ;
		} catch (Exception e) {
			resp.sendRedirect("https://www.youtube.com/watch?v=TJL4Y3aGPuA"); // TROLOLOLO
			return;
		}
		
		Functions.getInstance().enviarEmail(randomizedArray, msg, money, date, mod_name, emails, usernames);
		
		resp.setContentType("text/plain");
		resp.sendRedirect("index");
	}
}
