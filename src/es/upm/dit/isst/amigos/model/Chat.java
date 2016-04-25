package es.upm.dit.isst.amigos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chat implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	private Long grupo;
	private String from;
	private String to;
	private String conversacion;
	private Boolean leidofrom;
	private Boolean leidoto;
	
	public Chat(Long grupo, String from, String to, String conversacion, boolean leidofrom, boolean leidoto){
		this.grupo = grupo;
		this.from = from;
		this.to = to;
		this.conversacion = conversacion;
		this.leidofrom = Boolean.valueOf(leidofrom);
		this.leidoto = Boolean.valueOf(leidoto);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGrupo() {
		return grupo;
	}

	public void setGrupo(Long grupo) {
		this.grupo = grupo;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getConversacion() {
		return conversacion;
	}

	public void setConversacion(String conversacion) {
		this.conversacion = conversacion;
	}

	public Boolean getLeidofrom() {
		return leidofrom;
	}

	public void setLeidofrom(Boolean leidofrom) {
		this.leidofrom = leidofrom;
	}

	public Boolean getLeidoto() {
		return leidoto;
	}

	public void setLeidoto(Boolean leidoto) {
		this.leidoto = leidoto;
	}

	
	
	
	


}
