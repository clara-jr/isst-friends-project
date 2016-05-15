package es.upm.dit.isst.amigos;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;




import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import es.upm.dit.isst.amigos.dao.*;
import es.upm.dit.isst.amigos.model.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class Filtro implements Filter {

	FilterConfig filterConfig = null;
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		
		if (req.getUserPrincipal() != null ){
			UserService userservice = UserServiceFactory.getUserService();
			
			
			ChatDAOImpl chatdao = ChatDAOImpl.getInstance();
	
			List<Chat> chatsfrom;
			List<Chat> chatsto;

			Set<Long> noleidos = new HashSet<Long>();
			
			chatsfrom = chatdao.getChatByFrom(userservice.getCurrentUser().getNickname().toLowerCase(Locale.ENGLISH));
			chatsto = chatdao.getChatByTo(userservice.getCurrentUser().getNickname().toLowerCase(Locale.ENGLISH));
	
			for (Chat temp : chatsfrom){
				if (!temp.getLeidofrom()){
					noleidos.add(temp.getGrupo());
				}
			}
			for (Chat temp : chatsto){
				if (!temp.getLeidoto()){
					noleidos.add(temp.getGrupo());
				}
			}
			req.getSession().setAttribute("gruposnoleidos", noleidos);
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
