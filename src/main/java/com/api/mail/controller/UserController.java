package com.api.mail.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.mail.converter.UserConverter;
import com.api.mail.entities.Message;
import com.api.mail.entities.User;
import com.api.mail.persistence.MessageRepository;
import com.api.mail.persistence.UserRepository;
import com.api.mail.request.UserRequest;
import com.api.mail.response.UserWrapper;
import com.google.common.collect.Lists;

@RestController
@RequestMapping(value = "api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	@Autowired
	private UserConverter userConverter;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessageRepository messageRepository;

	// DAME TODOS
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<UserWrapper>> getAllUsers() {

		Iterable<User> it = userRepository.findAll();
		List<User> list = Lists.newArrayList(it);
		if (list.size() > 0) {
			return new ResponseEntity<>(this.convertList(list), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	// CREAR USUARIO
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity insertUser(@RequestBody UserRequest r) {
		try {
			User u = new User();
			u.setAdress(r.getAdress());
			u.setCity(r.getCity());
			u.setContry(r.getContry());
			u.setMail(r.getMail());
			u.setName(r.getName());
			u.setPhone(r.getPhone());
			u.setPwd(r.getPwd());
			u.setSurname(r.getSurname());
			userRepository.save(u);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// BORRAR USUARIO
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public ResponseEntity dropUser(@PathVariable("name") String name) {
		//se borra con todos sus mensajes asociados tanto enviados como recibidos 
		try {
			User u = userRepository.findByName(name);
			List<Message> list = messageRepository.findByReciver(u);
			messageRepository.delete(list);
			List<Message> listr = messageRepository.findByRemittent(u);
			messageRepository.delete(listr);
			userRepository.delete(u);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// BUSCAR POR NOMBRE
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/{name}")
	public @ResponseBody ResponseEntity<UserWrapper> getByName(@PathVariable("name") String name) {
		User user = userRepository.findByName(name);
		if (user != null) {
			UserWrapper u = userConverter.convert(user);
			return new ResponseEntity<UserWrapper>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	private List<UserWrapper> convertList(List<User> users) {
		List<UserWrapper> list = new ArrayList<>();
		for (User u : users) {
			list.add(userConverter.convert(u));
		}
		return list;
	}

}
