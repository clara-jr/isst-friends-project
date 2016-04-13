package es.upm.dit.isst.amigos;
/**
 * @author Clara
 *
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.*;

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
				usernames_excls[i-1] = usernames[i-1];
			}
			else {
				usernames_excls[i-1] = "";
			}
		}
		String[] randomizedArray = new String[participants_int];
		boolean excl = true;
		while (excl) {
			randomizedArray = Randomize(usernames);
			excl = false;
		    for (int i = 0; i < randomizedArray.length; i++) {
			    if (usernames_excls[i] != "") {
			    	int id_in = Arrays.binarySearch(randomizedArray, usernames[i]);
			    	if (id_in < randomizedArray.length - 1) {
			    		if (randomizedArray[id_in+1] == usernames_excls[i]) {
				    		excl = true;
						}
			    	}
			    	else {
			    		if (randomizedArray[0] == usernames_excls[i]) {
				    		excl = true;
						}
			    	}
				}
			}
		}
		
		for (int i = 0; i < randomizedArray.length; i++) {
			Message msg_results = new MimeMessage(Session.getDefaultInstance(new Properties(), null));
			try {
				msg_results.setFrom(new InternetAddress("nombre@aplicacion.appspotmail.com", "Amigo Invisible")); // nombre (nombre@...) y dominio (...@aplicacion) de la app en GAE
				msg_results.addRecipient(Message.RecipientType.TO,  new InternetAddress(randomizedArray[i], "Participante en el amigo invisible"));
				msg_results.setSubject("El sorteo para el amigo invisible se ha realizado correctamente");
				if (i < randomizedArray.length - 1) {
					msg_results.setText("Hola " + randomizedArray[i] + " , " + mod_name + " ha organizado un sorteo por el Amigo Invisible con el siguiente asunto: " + msg + "\n Tras realizar el sorteo te informamos de que ¡te ha tocado hacer un regalo a... " + randomizedArray[i+1] + "! \n La cuantía máxima del regalo es de " + money + " € y los regalos se repartirán en la fecha " + date + ". \n ¡A disfrutar del Amigo Invisible! ;)");
				}
				else {
					msg_results.setText("Hola " + randomizedArray[i] + " , " + mod_name + " ha organizado un sorteo por el Amigo Invisible con el siguiente asunto: " + msg + "\n Tras realizar el sorteo te informamos de que ¡te ha tocado hacer un regalo a... " + randomizedArray[0] + "! \n La cuantía máxima del regalo es de " + money + " € y los regalos se repartirán en la fecha " + date + ". \n ¡A disfrutar del Amigo Invisible! ;)");
				}
		        Transport.send(msg_results);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		resp.sendRedirect("index.html");
	}
}
