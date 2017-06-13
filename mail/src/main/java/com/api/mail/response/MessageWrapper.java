package com.api.mail.response;

import java.sql.Timestamp;

import com.api.mail.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageWrapper {
	@JsonProperty ("ID: ")
	private int id;
	@JsonProperty ("Nombre del Remitente: ")
	private User remittentName;
	@JsonProperty ("Nombre del Receptor: ")
	private User reciver;
	@JsonProperty ("Asunto: ")
	private String topic;
	@JsonProperty ("Mensaje: ")
	private String message;
	@JsonProperty ("Hora mail: ")
	private Timestamp time;
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setRemittent(User remittent) {
		this.remittentName = remittent;
	}
	public void setReciver(User reciver) {
		this.reciver = reciver;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
	

}
