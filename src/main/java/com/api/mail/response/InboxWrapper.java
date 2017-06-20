package com.api.mail.response;

import java.util.Date;
import com.api.mail.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InboxWrapper {
	@JsonProperty("NombreDelRemitente: ")
	private String remittentName;
	@JsonProperty("MailDelRemitente: ")
	private String remittentMail;
	@JsonProperty("Apellido del Remitente: ")
	private String remittentSurname;
	@JsonProperty("HoraEnviado: ")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
	private Date time;
	@JsonProperty("MailDelReceptor: ")
	private String reciberMail;
	@JsonProperty("Asunto: ")
	private String topic;
	@JsonProperty("Mensaje: ")
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

	public void setTime(Date time) {
		this.time = time;
	}

	public void setReciberMail(User reciber) {
		this.reciberMail = reciber.getMail();
	}

}
