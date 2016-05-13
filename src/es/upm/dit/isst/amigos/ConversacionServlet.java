package es.upm.dit.isst.amigos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.amigos.dao.*;
import es.upm.dit.isst.amigos.logic.Functions;
import es.upm.dit.isst.amigos.model.*;

@SuppressWarnings("serial")
public class ConversacionServlet extends HttpServlet {
	
	GrupoDAO grupodao = GrupoDAOImpl.getInstance();
	AgrupacionesDAO agrupao = AgrupacionesDAOImpl.getInstance();
	UserDAO usao = UserDAOImpl.getInstance();
	ChatDAOImpl chatdao = ChatDAOImpl.getInstance();

	UserService userservice = UserServiceFactory.getUserService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		if (req.getUserPrincipal() == null ){
			resp.getWriter().println("<p>No deberías estar aquí.</p>"
							+ "<a href=\"" + userservice.createLoginURL(req.getRequestURI()) +
                                     "\">Logueate</a> o <a href=\"\\\">vete</a>");
		}
		
		else {
			Long id = Long.valueOf(req.getParameter("grupo_id"));
			String user = userservice.getCurrentUser().getNickname().toLowerCase(Locale.ENGLISH);
			Grupo grupo = grupodao.getGrupoById(id);
			String userto = agrupao.getAgrupByUserAndGrupo(user, id).getAmigoinv();
			
			try {
				Chat chat_vi = chatdao.getChatByFromAndGrupo(id, user);
				chat_vi.setLeidofrom(true);
				chatdao.updateChat(chat_vi);
				String[] conver_vi = chat_vi.getConversacionParsed();
				List<String> lista_vi = new ArrayList<String>();
				lista_vi = Arrays.asList(conver_vi);
				req.getSession().setAttribute("conver_vi", lista_vi);
				req.getSession().setAttribute("userto", userto);
			}
			catch (Exception e) {
				String[] conver_vi = null;
				req.getSession().setAttribute("conver_vi", conver_vi);
				req.getSession().setAttribute("userto", userto);
			}
			
			try {
				Chat chat_invi = chatdao.getChatByToAndGrupo(id, user);
				chat_invi.setLeidoto(true);
				chatdao.updateChat(chat_invi);
				String[] conver_invi = chat_invi.getConversacionParsed();
				List<String> lista_invi = new ArrayList<String>();
				lista_invi = Arrays.asList(conver_invi);
				req.getSession().setAttribute("conver_invi", lista_invi);
			}
			catch (Exception e) {
				String[] conver_invi = null;
				req.getSession().setAttribute("conver_invi", conver_invi);
			}
			
			req.getSession().setAttribute("grupo", grupo);
			
			resp.sendRedirect("conversacion.jsp");
			
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String conver = req.getParameter("conver");
		Long id = Long.valueOf(req.getParameter("grupo_id"));
		String mensaje = "";
		String autor = userservice.getCurrentUser().getNickname().toLowerCase(Locale.ENGLISH);
		
		Agrupaciones agrupacion_vi = agrupao.getAgrupByUserAndGrupo(autor, id);
		Agrupaciones agrupacion_invi = agrupao.getAgrupByAmiInvAndGrupo(autor, id);
		
		if(conver.equals("visible")) {
			Functions.getInstance().chat(agrupacion_vi.getAmigoinv(), grupodao.getGrupoById(id).getNombre());
			Chat chat;
			try {
				chat = chatdao.getChatByFromAndGrupo(id, autor);
			}
			catch (Exception e) {
				chat = chatdao.insertChat(id, autor, agrupacion_vi.getAmigoinv(), true, true);
			}
			mensaje = req.getParameter("conv_vi");
			if (mensaje.equals("AND I SAY")){
				resp.sendRedirect("https://www.youtube.com/watch?v=eh7lp9umG2I");
			}
			chatdao.insertMensaje(chat, mensaje, "anónimo");
			chat.setLeidoto(false);
			chatdao.updateChat(chat);
			
			Grupo grupo = grupodao.getGrupoById(id);
			try {
				Chat chat_vi = chatdao.getChatByFromAndGrupo(id, autor);
				String[] conver_vi = chat_vi.getConversacionParsed();
				List<String> lista_vi = new ArrayList<String>();
				lista_vi = Arrays.asList(conver_vi);
				req.getSession().setAttribute("conver_vi", lista_vi);
			}
			catch (Exception e) {
				String[] conver_vi = null;
				req.getSession().setAttribute("conver_vi", conver_vi);
			}
			try {
				Chat chat_invi = chatdao.getChatByToAndGrupo(id, autor);
				String[] conver_invi = chat_invi.getConversacionParsed();
				List<String> lista_invi = new ArrayList<String>();
				lista_invi = Arrays.asList(conver_invi);
				req.getSession().setAttribute("conver_invi", lista_invi);
			}
			catch (Exception e) {
				String[] conver_invi = null;
				req.getSession().setAttribute("conver_invi", conver_invi);
			}
			req.getSession().setAttribute("grupo", grupo);
			
			resp.sendRedirect("conversacion.jsp");
		}
		
		else if(conver.equals("invisible")) {
			Functions.getInstance().chat(agrupacion_invi.getUser(), grupodao.getGrupoById(id).getNombre());
			Chat chat;
			try {
				chat = chatdao.getChatByToAndGrupo(id, autor);
			}
			catch (Exception e) {
				chat = chatdao.insertChat(id, agrupacion_invi.getUser(), autor, true, true);
			}
			mensaje = req.getParameter("conv_invi");
			if (mensaje.equals("AND I SAY")){
				resp.sendRedirect("https://www.youtube.com/watch?v=eh7lp9umG2I");
			}
			chatdao.insertMensaje(chat, mensaje, autor);
			chat.setLeidofrom(false);
			chatdao.updateChat(chat);
			
			Grupo grupo = grupodao.getGrupoById(id);
			try {
				Chat chat_vi = chatdao.getChatByFromAndGrupo(id, autor);
				String[] conver_vi = chat_vi.getConversacionParsed();
				List<String> lista_vi = new ArrayList<String>();
				lista_vi = Arrays.asList(conver_vi);
				req.getSession().setAttribute("conver_vi", lista_vi);
			}
			catch (Exception e) {
				String[] conver_vi = null;
				req.getSession().setAttribute("conver_vi", conver_vi);
			}
			try {
				Chat chat_invi = chatdao.getChatByToAndGrupo(id, autor);
				String[] conver_invi = chat_invi.getConversacionParsed();
				List<String> lista_invi = new ArrayList<String>();
				lista_invi = Arrays.asList(conver_invi);
				req.getSession().setAttribute("conver_invi", lista_invi);
			}
			catch (Exception e) {
				String[] conver_invi = null;
				req.getSession().setAttribute("conver_invi", conver_invi);
			}
			req.getSession().setAttribute("grupo", grupo);
			
			resp.sendRedirect("conversacion.jsp");
		}
		
		else {
			req.getSession().setAttribute("error", "¡Mensaje enviado!");
			resp.sendRedirect("avisos.jsp");	
		}
	}
}
