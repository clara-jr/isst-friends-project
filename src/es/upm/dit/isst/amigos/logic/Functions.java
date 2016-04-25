package es.upm.dit.isst.amigos.logic;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Functions {
	
	private static Functions instance;
	
	private Functions(){
		
	}
	
	public static Functions getInstance(){
		if (instance == null)
			instance = new Functions();
		return instance;
	}
	
	public String[] Randomize(String[] arr) {
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
	
	public String[] asignador (String[] usernames, String[] usernames_excls){
		String[] randomizedArray = new String[usernames.length];
		boolean excl = true;
		int n = 0;
		while (excl) {
			randomizedArray = Randomize(usernames);
			excl = false;
			n++;
			if (n >= 100){
				System.out.println(0);
				return null; //Demasiados intentos, quizá no se pueda realizar el sorteo
			}
		    for (int i = 0; i < randomizedArray.length; i++) {
			    if (usernames_excls[i] != "") {
			    	int id_in = Arrays.asList(randomizedArray).indexOf(usernames[i]);
			    	if (id_in < randomizedArray.length - 1) {
			    		if (randomizedArray[id_in+1] == usernames_excls[i]) {
				    		excl = true;
				    		System.out.println(1);
						}
			    	}
			    	else {
			    		if (randomizedArray[0] == usernames_excls[i]) {
				    		excl = true;
				    		System.out.println(2);
						}
			    	}
				}
			}
		}
		return randomizedArray;
	}

	
	public void enviarEmail(String[] randomizedArray, String msg, String money, String date, String mod_name, String[] emails, String[] usernames) throws IOException{
		for (int i = 0; i < randomizedArray.length; i++) {
			int id_in = Arrays.asList(usernames).indexOf(randomizedArray[i]);
			Message msg_results = new MimeMessage(Session.getDefaultInstance(new Properties(), null));
			try {
				msg_results.setFrom(new InternetAddress("isst-amigoinvisible@isst-grupo17-amigos-1284.appspotmail.com", "Amigo Invisible")); // nombre (nombre@...) y dominio (...@aplicacion) de la app en GAE
				msg_results.addRecipient(Message.RecipientType.TO,  new InternetAddress(emails[id_in], "Participante en el amigo invisible"));
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
	}
	
	public void aviso(String nick, String mod_name) throws IOException{
		Message msg_results = new MimeMessage(Session.getDefaultInstance(new Properties(), null));
		try {
			msg_results.setFrom(new InternetAddress("isst-amigoinvisible@isst-grupo17-amigos-1284.appspotmail.com", "Amigo Invisible")); // nombre (nombre@...) y dominio (...@aplicacion) de la app en GAE
			msg_results.addRecipient(Message.RecipientType.TO,  new InternetAddress(nick+"@gmail.com", "Participante en el amigo invisible"));
			msg_results.setSubject("Invitación para pertenecer a un grupo del Amigo Invisible");
			msg_results.setText("Hola " + nick + " , " + mod_name + " ha organizado un sorteo por el Amigo Invisible en nuestra aplicación y para aceptar la participación en el mismo, debes pinchar en el siguiente enlace: \n http://1-dot-isst-grupo17-amigos-1284.appspot.com/Login");
			Transport.send(msg_results);
		} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public void aviso_eliminado(String nick, String item, String mod_name) throws IOException{
		Message msg_results = new MimeMessage(Session.getDefaultInstance(new Properties(), null));
		try {
			msg_results.setFrom(new InternetAddress("isst-amigoinvisible@isst-grupo17-amigos-1284.appspotmail.com", "Amigo Invisible")); // nombre (nombre@...) y dominio (...@aplicacion) de la app en GAE
			msg_results.addRecipient(Message.RecipientType.TO,  new InternetAddress(nick+"@gmail.com", "Participante en el amigo invisible"));
			msg_results.setSubject("Invitación para pertenecer a un grupo del Amigo Invisible");
			msg_results.setText("Hola " + nick + " , el moderador de uno de tus grupos, " + mod_name + " ha eliminado el siguiente deseo de tu lista de deseos: " + item);
			Transport.send(msg_results);
		} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}