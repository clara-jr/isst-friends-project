package com.AmigoInvisible.isst.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ListasDeseos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String item1;
	private String item2;
	private String item3;
	private String item4;
	private String item5;
	private String item6;
	private String item7;
	private String item8;
	private String item9;
	private String item10;
	
	public ListasDeseos(int id, String item1, String item2, String item3, String item4, String item5, String item6,
			String item7, String item8, String item9, String item10){
		this.id = id;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.item5 = item5;
		this.item6 = item6;
		this.item7 = item7;
		this.item8 = item8;
		this.item9 = item9;
		this.item10 = item10;
	}
	
	public List<String> getItems(){
		List<String> strings = new ArrayList<String>();
		strings.add(item1);
		strings.add(item2);
		strings.add(item3);
		strings.add(item4);
		strings.add(item5);
		strings.add(item6);
		strings.add(item7);
		strings.add(item8);
		strings.add(item9);
		strings.add(item10);
		return strings;
	}

	public int getId() {
		return id;
	}

	public String getItem1() {
		return item1;
	}

	public String getItem2() {
		return item2;
	}

	public String getItem3() {
		return item3;
	}

	public String getItem4() {
		return item4;
	}

	public String getItem5() {
		return item5;
	}

	public String getItem6() {
		return item6;
	}

	public String getItem7() {
		return item7;
	}

	public String getItem8() {
		return item8;
	}

	public String getItem9() {
		return item9;
	}

	public String getItem10() {
		return item10;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public void setItem3(String item3) {
		this.item3 = item3;
	}

	public void setItem4(String item4) {
		this.item4 = item4;
	}

	public void setItem5(String item5) {
		this.item5 = item5;
	}

	public void setItem6(String item6) {
		this.item6 = item6;
	}

	public void setItem7(String item7) {
		this.item7 = item7;
	}

	public void setItem8(String item8) {
		this.item8 = item8;
	}

	public void setItem9(String item9) {
		this.item9 = item9;
	}

	public void setItem10(String item10) {
		this.item10 = item10;
	}
	
	/*public void setItems(List<String> listadestrings){
		item1 = listadestrings.get

	}*/
}
