package com.api.mail.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.mail.entities.Message;
import com.api.mail.entities.User;
import com.api.mail.persistence.MessageRepository;
import com.api.mail.persistence.UserRepository;
import com.api.mail.request.MessageRequest;
import com.api.mail.response.InboxWrapper;
import com.api.mail.response.MessageWrapper;
import com.api.mail.converter.InboxConverter;
import com.api.mail.converter.MessageConverter;

@RestController
@RequestMapping(value = "api/message", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {
	@Autowired
	private MessageConverter messageConverter;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private InboxConverter inboxConverter;

	// CREAR MENSAJE
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity insertUser(@RequestBody MessageRequest r) {
		try {
			Message m = new Message();
			m.setMessage(r.getMessage());
			m.setReciver(r.getReciver());
			m.setRemittent(r.getRemittent());
			m.setTopic(r.getTopic());
			m.setTime(r.getTime());
			messageRepository.save(m);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// INBOX
	@RequestMapping(value = "/inbox", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<InboxWrapper>> getAllMessagesInbox(
			@RequestHeader("usuario") String userName) {
		User u = userRepository.findByName(userName);
		List<Message> list = messageRepository.findByReciver(u);
		List<Message> listNotDeleted = new ArrayList<>();
		//almaceno en una lista auxiliar donde trabajo con los mensajes que no fueron borrados ya que necesito los mensajes borrados para poder hacer el /trash
		int i;
		for( i=0; i<list.size();i++){
			if(!list.get(i).getDeleted()){
				Message message = list.get(i);
				listNotDeleted.add(message);
			}
		}
		if (listNotDeleted.size() > 0) {
			return new ResponseEntity<>(this.convertListInbox(listNotDeleted), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	// OUTBOX
	@RequestMapping(value = "/outbox", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<InboxWrapper>> getAllMessagesOutbox(
			@RequestHeader("usuario") String userName) {
		User u = userRepository.findByName(userName);
		List<Message> list = messageRepository.findByRemittent(u);
		List<Message> listNotDeleted = new ArrayList<>();
		//almaceno en una lista auxiliar donde trabajo con los mensajes que no fueron borrados ya que necesito los mensajes borrados para poder hacer el /trash
		int i;
		for( i=0; i<list.size();i++){
			if(!list.get(i).getDeleted()){
				Message message = list.get(i);
				listNotDeleted.add(message);
			}
		}
		if (listNotDeleted.size() > 0) {
			return new ResponseEntity<>(this.convertListInbox(listNotDeleted), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	// BORRAR MENSAJE
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity dropMessage(@PathVariable("id") int id) {
		try {
			//modifico una variable deleted ya qae si borro el mensaje no tengo forma de traerme los mensajes borrados
			Message message = messageRepository.findOne((long) id);
			message.setDeleted(true);
			//debo almacenar el mensaje guardado para poder mostrarlo en la el /trash pedido
			messageRepository.save(message);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(value = "/trash", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<List<InboxWrapper>> trash(
			@RequestHeader("usuario") String userName) {
		User u = userRepository.findByName(userName);
		List<Message> list = messageRepository.findByRemittent(u);
		List<Message> listDeleted = new ArrayList<>();
		//almaceno en una lista auxiliar donde trabajo con los mensajes que no fueron borrados ya que necesito los mensajes borrados para poder hacer el /trash
		int i;
		for( i=0; i<list.size();i++){
			if(list.get(i).getDeleted()){
				Message message = list.get(i);
				listDeleted.add(message);
			}
		}
		if (listDeleted.size() > 0) {
			return new ResponseEntity<>(this.convertListInbox(listDeleted), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@SuppressWarnings("unused")
	private List<MessageWrapper> convertList(List<Message> message) {
		List<MessageWrapper> list = new ArrayList<>();
		for (Message m : message) {
			list.add(messageConverter.convert(m));
		}
		return list;
	}

	private List<InboxWrapper> convertListInbox(List<Message> message) {
		List<InboxWrapper> list = new ArrayList<>();
		for (Message m : message) {
			list.add(inboxConverter.convert(m));
		}
		return list;
	}

}
