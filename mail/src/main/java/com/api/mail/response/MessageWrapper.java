package com.api.mail.response;

import java.sql.Timestamp;

import com.api.mail.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageWrapper {
	@JsonProperty
	private int id;
	@JsonProperty
	private User remittentName;
	@JsonProperty
	private User reciver;
	@JsonProperty
	private String topic;
	@JsonProperty
	private String message;
	@JsonProperty
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
