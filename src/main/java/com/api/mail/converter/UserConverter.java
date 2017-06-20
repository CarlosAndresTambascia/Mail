package com.api.mail.converter;

import org.springframework.stereotype.Component;

import com.api.mail.entities.User;
import com.api.mail.response.UserWrapper;

@Component
public class UserConverter {
	public UserConverter() {

	}

	public UserWrapper convert(User user) {
		UserWrapper u = new UserWrapper();
		u.setAdress(user.getAdress());
		u.setCity(user.getCity());
		u.setContry(user.getContry());
		u.setMail(user.getMail());
		u.setName(user.getName());
		u.setPhone(user.getPhone());
		u.setSurname(user.getSurname());
		return u;
	}

}
