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

public class Filtro implements Filter {

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
		
		if (req.getUserPrincipal() != null ){
			UserService userservice = UserServiceFactory.getUserService();
			
			
			ChatDAOImpl chatdao = ChatDAOImpl.getInstance();
			GrupoDAOImpl grupodao = GrupoDAOImpl.getInstance();
	
			List<Chat> chatsfrom;
			List<Chat> chatsto;
			Set<Long> noleidosid = new HashSet<Long>();
			List<Grupo> noleidos = new ArrayList<Grupo>();
			
			chatsfrom = chatdao.getChatByFrom(userservice.getCurrentUser().getNickname());
			chatsto = chatdao.getChatByTo(userservice.getCurrentUser().getNickname());
	
			for (Chat temp : chatsfrom){
				if (!temp.getLeidofrom()){
					noleidosid.add(temp.getGrupo());
				}
			}
			for (Chat temp : chatsto){
				if (!temp.getLeidoto()){
					noleidosid.add(temp.getGrupo());
				}
			}
			for (Long temp : noleidosid){
				noleidos.add(grupodao.getGrupoById(temp));
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
