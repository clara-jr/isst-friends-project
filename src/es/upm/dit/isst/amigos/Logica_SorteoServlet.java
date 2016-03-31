package es.upm.dit.isst.amigos;
/**
 * @author Clara
 *
 */
import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Logica_SorteoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		// Realizar sorteo y enviar correos de resultados
		String mod_name = req.getParameter("mod_name");
		String money = req.getParameter("money");
		String date = req.getParameter("date");
		String msg = req.getParameter("msg");
		String participants = req.getParameter("participants");
		int participants_int = Integer.parseInt(req.getParameter("participants"));
		String[] usernames = new String[participants_int];
		String[] emails = new String[participants_int];
		String[] excls = new String[participants_int];
		for(int i=1; i<=participants_int; i++) {
			  usernames[i-1] = req.getParameter("username"+i);
			  emails[i-1] = req.getParameter("email"+i);
			  excls[i-1] = req.getParameter("excl"+i);
		}
		resp.sendRedirect("index.html");
	}
}
