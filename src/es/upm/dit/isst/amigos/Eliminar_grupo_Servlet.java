package es.upm.dit.isst.amigos;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.amigos.dao.AgrupacionesDAOImpl;
import es.upm.dit.isst.amigos.dao.GrupoDAOImpl;
import es.upm.dit.isst.amigos.model.Agrupaciones;
import es.upm.dit.isst.amigos.model.Grupo;

@SuppressWarnings("serial")
public class Eliminar_grupo_Servlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Long grupo_id = Long.valueOf(req.getParameter("grupo_id"));
		
		resp.getWriter().println(grupo_id);
		
		AgrupacionesDAOImpl agrupdao = AgrupacionesDAOImpl.getInstance();
		GrupoDAOImpl grupodao = GrupoDAOImpl.getInstance();
		
		List<Agrupaciones> elimagrup = agrupdao.getAgrupacionesByGrupo(grupo_id);
		Grupo elimgrupo = grupodao.getGrupoById(grupo_id);
		
		for(Agrupaciones temp : elimagrup){
			agrupdao.deleteAgrupacion(temp);
		}
		grupodao.deleteGrupo(elimgrupo);
				
		resp.sendRedirect("/Grupos");
		
		
	}
}
