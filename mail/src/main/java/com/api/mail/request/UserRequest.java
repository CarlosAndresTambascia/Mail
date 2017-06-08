package com.api.mail.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {	
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
	
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getAdress() {
		return adress;
	}
	public int getPhone() {
		return phone;
	}
	public String getCity() {
		return city;
	}
	public String getContry() {
		return contry;
	}
	public String getMail() {
		return mail;
	}
	public String getPwd() {
		return pwd;
	}


}
