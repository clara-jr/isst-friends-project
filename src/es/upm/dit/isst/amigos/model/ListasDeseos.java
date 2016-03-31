package es.upm.dit.isst.amigos.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ListasDeseos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue @Id 
	private int id;
	private String user;
	private String item;
	
	public ListasDeseos(String user, String item){
		this.user = user;
		this.item = item;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	


}
