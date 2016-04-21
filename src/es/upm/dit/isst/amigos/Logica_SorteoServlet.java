package es.upm.dit.isst.amigos;
/**
 * @author Clara
 *
 */
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.*;

import es.upm.dit.isst.amigos.logic.*;

@SuppressWarnings("serial")
public class Logica_SorteoServlet extends HttpServlet {
	
	public static String[] Randomize(String[] arr) {
		String[] randomizedArray = new String[arr.length];
	    System.arraycopy(arr, 0, randomizedArray, 0, arr.length);
	    Random rgen = new Random();
	    for (int i = 0; i < randomizedArray.length; i++) {
	    	int randomPosition = rgen.nextInt(randomizedArray.length);
		    String temp = randomizedArray[i];
		    randomizedArray[i] = randomizedArray[randomPosition];
		    randomizedArray[randomPosition] = temp;
	    }
	    return randomizedArray;
	}
	
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
			if (req.getParameter("excl"+i) != "") {
				if (Integer.valueOf(req.getParameter("excl"+i)) > participants_int){
					resp.getWriter().println("Ha metido algún número en exclusión mayor al número de participantes");
					return;
				}
				usernames_excls[i-1] = usernames[Integer.parseInt(req.getParameter("excl"+i)) - 1];
			}
			else {
				usernames_excls[i-1] = "";
			}
		}
		String[] randomizedArray = Functions.getInstance().asignador(usernames, usernames_excls);
		
		Functions.getInstance().enviarEmail(randomizedArray, msg, money, date, mod_name, emails, usernames);
		
		resp.sendRedirect("index.html");
	}
}
