package com.api.mail.response;

import java.util.Date;
import com.api.mail.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageWrapper {
	@JsonProperty("ID: ")
	private long id;
	@JsonProperty("NombreDelRemitente: ")
	private User remittentName;
	@JsonProperty("NombreDelReceptor: ")
	private User reciver;
	@JsonProperty("Asunto: ")
	private String topic;
	@JsonProperty("Mensaje: ")
	private String message;
	@JsonProperty("HorMail: ")
	private Date time;

	public void setId(long id) {
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
