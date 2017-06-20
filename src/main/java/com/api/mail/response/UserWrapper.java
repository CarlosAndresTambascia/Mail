package com.api.mail.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserWrapper {
	@JsonProperty("Nombre: ")
	private String name;
	@JsonProperty("Apellido: ")
	private String surname;
	@JsonProperty("Direccion: ")
	private String adress;
	@JsonProperty("Celular: ")
	private int phone;
	@JsonProperty("Ciudad: ")
	private String city;
	@JsonProperty("Pais: ")
	private String contry;
	@JsonProperty("Mail: ")
	private String mail;

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

}
