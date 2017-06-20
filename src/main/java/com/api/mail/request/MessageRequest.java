package com.api.mail.request;

import java.sql.Timestamp;

import com.api.mail.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageRequest {

	@JsonProperty
	private User remittent;
	@JsonProperty
	private User reciver;
	@JsonProperty
	private String topic;
	@JsonProperty
	private String message;
	@JsonProperty
	private Timestamp time;

	public Timestamp getTime() {
		return time;
	}

	public User getRemittent() {
		return remittent;
	}

	public User getReciver() {
		return reciver;
	}

	public String getTopic() {
		return topic;
	}

	public String getMessage() {
		return message;
	}

}
