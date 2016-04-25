package es.upm.dit.isst.amigos;
/**
 * @author Clara
 *
 */
import java.io.IOException;

import javax.servlet.http.*;

import es.upm.dit.isst.amigos.logic.*;

@SuppressWarnings("serial")
public class Logica_SorteoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		
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
		for(int i=1; i<=participants_int; i++) {			
			if (req.getParameter("excl"+i) != "") {
				try{
					Integer.valueOf(req.getParameter("excl"+i));
				}catch(Exception e){
					req.getSession().setAttribute("error", "¡Has introducido un valor no numérico en el campo de exclusiones!");
					resp.sendRedirect("avisos.jsp");
				}
				if (Integer.parseInt(req.getParameter("excl"+i)) > participants_int){
					req.getSession().setAttribute("error", "¡Algún número en exclusiones es mayor que el número de participantes!");
					resp.sendRedirect("avisos.jsp");	
				}
				usernames_excls[i-1] = usernames[Integer.parseInt(req.getParameter("excl"+i)) - 1];
			}
			else {
				usernames_excls[i-1] = "";
			}
		}
		String[] randomizedArray = Functions.getInstance().asignador(usernames, usernames_excls);
		
		Functions.getInstance().enviarEmail(randomizedArray, msg, money, date, mod_name, emails, usernames);
		
		resp.sendRedirect("index");
	}
}
