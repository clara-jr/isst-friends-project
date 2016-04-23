package es.upm.dit.isst.amigos;
/**
 * @author Clara
 *
 */
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class IndexServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		
		if (req.getUserPrincipal() != null){
			resp.sendRedirect("/Grupos");
		}
		else resp.sendRedirect("index.jsp");
	}
}

