package es.upm.dit.isst.amigos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;




import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.amigos.dao.*;
import es.upm.dit.isst.amigos.model.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class FiltroAcceso implements Filter {

	FilterConfig filterConfig = null;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        if(req.getRequestURI().matches("^/_ah/(.*)")){
        	filterChain.doFilter(request, response);
        	return;
        }

        if (req.getUserPrincipal() == null ){			
			if (!(req.getRequestURI().equals("/index.jsp") || req.getRequestURI().equals("/index") || req.getRequestURI().equals("/participantes.jsp") || req.getRequestURI().equals("/mensaje.jsp") ||
					req.getRequestURI().equals("/sortear.jsp") || req.getRequestURI().equals("/logica_sorteo") || req.getRequestURI().equals("/avisos.jsp") || req.getRequestURI().equals("/") || req.getRequestURI().equals("/Login") ||
					req.getRequestURI().equals(((String)req.getSession().getAttribute("urllogin")).split("\\?")[0]))){
				req.getSession().setAttribute("error", "No estas logueado, por lo que no puedes acceder a esta página");
				resp.sendRedirect("avisos.jsp");
				return;
			}
		}

		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;

	}

}
