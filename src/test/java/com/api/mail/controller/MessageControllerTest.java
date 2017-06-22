package com.api.mail.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URL;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.api.mail.Main;
import com.api.mail.entities.Message;
import com.api.mail.entities.User;
import com.api.mail.persistence.MessageRepository;
import com.api.mail.persistence.UserRepository;
import com.api.mail.util.SessionData;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@Transactional
public class MessageControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private SessionData sessionData;
	@Autowired
	private UserRepository userRepository;

	private String sessionId;

	private Message message;

	private User remittentFake;

	private User reciverFake;
	private Date date;

	@Before
	public void setUp() {		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		remittentFake= new User("carlos", "marino", "abc street", 223, "MDP", "ARG", "caa@caa.com", "123");
		reciverFake= new User("avc", "marino", "abc street", 223, "MDP", "ARG", "caa@caa.com", "123");
		this.remittentFake = userRepository.save(remittentFake);
		this.reciverFake = userRepository.save(reciverFake);
		this.message = new Message(remittentFake, reciverFake, "test", "hola soy un test", date);

	}

	@Test
	public void getAllMessagesInboxOkTest() throws Exception {
		
		this.sessionId = this.sessionData.addSession(reciverFake);
		this.message = messageRepository.save(message);
		mockMvc.perform(
				get("/api/message/inbox").header("sessionId", this.sessionId)
				.header("usuario", reciverFake.getName())

		)

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void getAllMessagesInboxBadTest() throws Exception {
		this.sessionId = this.sessionData.addSession(reciverFake);
		mockMvc.perform(

				get("/api/message/inbox").header("sessionId", this.sessionId)
				.header("usuario", reciverFake.getName())
		)
				.andExpect(status().isNoContent());

	}
	
	@Test
	public void insertMessageOkTest() throws Exception {
		URL url = Resources.getResource("message.json");
		String json = Resources.toString(url, Charsets.UTF_8);

		mockMvc.perform(post("/api/message/").contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void getAllMessagesOutboxOkTest() throws Exception {
		
		this.sessionId = this.sessionData.addSession(remittentFake);
		this.message = messageRepository.save(message);
		mockMvc.perform(
				get("/api/message/outbox").header("sessionId", this.sessionId)
				.header("usuario", remittentFake.getName())

		)

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
//	@Test
//	public void dropMessageOkTest() throws Exception {
//		this.sessionId = this.sessionData.addSession(remittentFake);
//		this.message = messageRepository.save(message);
//		mockMvc.perform(get("/api/message/1")
//				.header("sessionid", this.sessionId)
//				)
//				.andExpect(status().isOk());
//	}
	
//	@Test
//	public void trashOkTest() throws Exception {
//		
//		this.sessionId = this.sessionData.addSession(reciverFake);
//		this.message.setDeleted(true);
//		this.message = messageRepository.save(message);		
//		mockMvc.perform(
//				get("/api/message/trash").header("sessionId", this.sessionId)
//				.header("usuario", reciverFake.getName())
//
//		)
//
//				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
//	}
	
	@Test
	public void trashBadTest() throws Exception {
		this.sessionId = this.sessionData.addSession(reciverFake);
		mockMvc.perform(

				get("/api/message/trash").header("sessionId", this.sessionId)
				.header("usuario", reciverFake.getName())
		)
				.andExpect(status().isNoContent());

	}
	
	


}
