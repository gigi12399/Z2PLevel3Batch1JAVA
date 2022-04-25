package lms.model.entity;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;

public class Member {
	private int card_id;
	private String name;
	private String roll_no;
	private String class_year;
	private int acedemic_year;
	private LocalDate created_date;
	private LocalDate expired_date;
	
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}
	public String getClass_year() {
		return class_year;
	}
	public void setClass_year(String class_year) {
		this.class_year = class_year;
	}
	public int getAcedemic_year() {
		return acedemic_year;
	}
	public void setAcedemic_year(int acedemic_year) {
		this.acedemic_year = acedemic_year;
	}
	public LocalDate getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}
	public LocalDate getExpired_date() {
		return expired_date;
	}
	public void setExpired_date(LocalDate expired_date) {
		this.expired_date = expired_date;
	}
	 
	
}
