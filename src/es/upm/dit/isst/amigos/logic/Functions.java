package es.upm.dit.isst.amigos.logic;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.*;

import es.upm.dit.isst.amigos.dao.AgrupacionesDAOImpl;

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
		
		return randomizedArray;
		
	}

	
	public void enviarEmail(String[] randomizedArray, String msg, String money, String date, String mod_name, String[] emails, String[] usernames) throws IOException{
		
		for (int i = 0; i < randomizedArray.length; i++) {
			
			int id_in = Arrays.binarySearch(usernames, randomizedArray[i]);
			
			Message msg_results = new MimeMessage(Session.getDefaultInstance(new Properties(), null));
			try {
				msg_results.setFrom(new InternetAddress("nombre@aplicacion.appspotmail.com", "Amigo Invisible")); // nombre (nombre@...) y dominio (...@aplicacion) de la app en GAE
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
	
	
}
