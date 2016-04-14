package es.upm.dit.isst.amigos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grupo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nombre;
	private String moderador;
	private String preciomax;
	private String fecha;
	
	public Grupo(String nombre, String moderador, String preciomax, String fecha) {
		this.nombre = nombre;
		this.moderador = moderador;
		this.preciomax = preciomax;
		this.fecha = fecha;
	}
	
	public Long getId() {
		return id;
	}
	public String getPreciomax() {
		return preciomax;
	}
	
	public String getModerador() {
		return moderador;
	}
	public void setId(Long id) {
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
