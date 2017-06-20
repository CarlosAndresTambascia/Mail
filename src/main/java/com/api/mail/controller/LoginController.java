package com.api.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.mail.entities.User;
import com.api.mail.persistence.UserRepository;
import com.api.mail.response.LoginResponseWrapper;
import com.api.mail.util.SessionData;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

	@Autowired
	private SessionData sessionData;

	@Autowired
	private UserRepository userRepository;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<LoginResponseWrapper> getById(@RequestParam("user") String nombreUsuario,
			@RequestParam("pwd") String pwd) {
		User u = userRepository.findByName(nombreUsuario);
		if (null != u && u.getName().equals(nombreUsuario) && u.getPwd().equals(pwd)) {
			String sessionId = sessionData.addSession(u);
			return new ResponseEntity<LoginResponseWrapper>(new LoginResponseWrapper(sessionId), HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.FORBIDDEN);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/logout")
	public @ResponseBody ResponseEntity getById(@RequestHeader("sessionid") String sessionId) {
		sessionData.removeSession(sessionId);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

}
