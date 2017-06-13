package com.api.mail.converter;

import com.api.mail.entities.Message;
import com.api.mail.response.InboxWrapper;

public class InboxConverter {
	public InboxConverter(){
		
	}
	public InboxWrapper convert (Message message){
		InboxWrapper i = new InboxWrapper();
		i.setMessage(message.getMessage());
		i.setReciberMail(message.getReciver());
		i.setRemittentMail(message.getRemittent());
		i.setRemittentName(message.getRemittent());
		i.setRemittentSurname(message.getRemittent());
		i.setTime(message.getTime());
		i.setTopic(message.getTopic());
		return i;
		
	}
}
