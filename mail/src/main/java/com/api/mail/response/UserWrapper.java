package com.api.mail.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserWrapper {
	@JsonProperty
	private String name;
	@JsonProperty
	private String surname;
	@JsonProperty
	private String adress;
	@JsonProperty
	private int phone;
	@JsonProperty
	private String city;
	@JsonProperty
	private String contry;
	@JsonProperty
	private String mail;
	@JsonProperty
	private String pwd;
	@JsonProperty
	private int id;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
