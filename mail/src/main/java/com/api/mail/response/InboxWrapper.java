package com.api.mail.response;

import java.sql.Timestamp;

import com.api.mail.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InboxWrapper {
	@JsonProperty ("Nombre del Remitente: ")
	private String remittentName;
	@JsonProperty ("Mail del remitente: ")
	private String remittentMail;
	@JsonProperty ("Apellido del Remitente: ")
	private String remittentSurname;
	@JsonProperty ("Hora enviado: ")
	private Timestamp time;
	@JsonProperty ("Mail del Receptor: ")
	private String reciberMail;
	@JsonProperty ("Asunto: ")
	private String topic;
	@JsonProperty ("Mensaje: ")
	private String message;
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setRemittentName(User remittent) {
		this.remittentName = remittent.getName();
	}
	public void setRemittentMail(User remittent) {
		this.remittentMail = remittent.getMail();
	}
	public void setRemittentSurname(User remittent) {
		this.remittentSurname = remittent.getSurname();
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public void setReciberMail(User reciber) {
		this.reciberMail = reciber.getName();
	}
	
	
	
	

	
	
	

}
