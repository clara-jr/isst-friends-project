package es.upm.dit.isst.amigos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Grupos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String moderador;
	private String preciomax;
	private String fecha;
	
	public int getId() {
		return id;
	}
	public String getPreciomax() {
		return preciomax;
	}
	
	public String getModerador() {
		return moderador;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setModerador(String moderador) {
		this.moderador = moderador;
	}
	public void setPreciomax(String preciomax) {
		this.preciomax = preciomax;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
