package com.api.mail.controller;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.net.URL;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.context.WebApplicationContext;
//import com.api.mail.Main;
//import com.api.mail.entities.Message;
//import com.api.mail.entities.User;
//import com.api.mail.persistence.MessageRepository;
//import com.api.mail.util.SessionData;
//import com.google.common.base.Charsets;
//import com.google.common.io.Resources;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Main.class)
//@Transactional
public class MessageTest {
//
//	private MockMvc mockMvc;
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//	@Autowired
//	private MessageRepository messageRepository;
//	@Autowired
//	private SessionData sessionData;
//
//	private String sessionId;
//
//	private Message message;
/*
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		this.message = new Message("hola", "2017-06-09 00:00:00", "edison", 223, "MDP", "Argentina", "charly@mail.com", "123");
		this.sessionId = this.sessionData.addSession(user);

	}
*/	/*
	@Test
	public void insertMessageTest() throws Exception {
		URL url = Resources.getResource("message.json");
		String json = Resources.toString(url, Charsets.UTF_8);

		mockMvc.perform(post("/api/message/").contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
				.andExpect(status().isCreated());
	}*/
	/*
	@Test
	public void getAllMessagesInboxOkTest() throws Exception {
		this.user = messageRepository.save(user);

		mockMvc.perform(

				get("/api/user/").header("sessionId", this.sessionId)

		)

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

	}
*/
}
