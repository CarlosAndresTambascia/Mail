package com.api.mail.converter;

import org.springframework.stereotype.Component;

import com.api.mail.entities.Message;
import com.api.mail.response.MessageWrapper;

@Component
public class MessageConverter {
	public MessageConverter(){
		
	}
	public MessageWrapper convert (Message message){
		MessageWrapper m = new MessageWrapper();
		m.setId(message.getId());
		m.setMessage(message.getMessage());
		m.setReciver(message.getReciver());
		m.setRemittent(message.getRemittent());
		m.setTopic(message.getTopic());
		return m;		
	}
	

}
