package com.api.mail.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;

@Entity
@Table(name = "Message")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne(cascade = CascadeType.PERSIST)
	private User remittent;
	@OneToOne(cascade = CascadeType.PERSIST)
	private User reciver;
	private String topic;
	private String message;
	private Date time;
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean deleted;

	public Message() {
		this.deleted = false;
	}

	public Message(User remittent, User reciver, String topic, String message, Date time) {
		super();
		this.remittent = remittent;
		this.reciver = reciver;
		this.topic = topic;
		this.message = message;
		this.time = time;
		this.deleted = false;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public User getRemittent() {
		return remittent;
	}

	public void setRemittent(User remittent) {
		this.remittent = remittent;
	}

	public User getReciver() {
		return reciver;
	}

	public void setReciver(User reciver) {
		this.reciver = reciver;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getId() {
		return id;
	}

	@Column(nullable = true)
	public boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;

	}

}
