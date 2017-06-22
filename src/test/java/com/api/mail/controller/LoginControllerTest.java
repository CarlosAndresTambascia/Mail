package com.api.mail.controller;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
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
import com.api.mail.entities.User;
import com.api.mail.persistence.UserRepository;
import com.api.mail.util.SessionData;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@Transactional
public class LoginControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SessionData sessionData;

	private String sessionId;

	private User user;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		this.user = new User("carlos", "tambascia", "edison", 223, "MDP", "Argentina", "charly@mail.com", "123");
		this.sessionId = this.sessionData.addSession(user);
		this.user = userRepository.save(user);

	}

	@Test
	public void loginSuccess() throws Exception {
		mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.content(EntityUtils.toString(new UrlEncodedFormEntity(
						asList(new BasicNameValuePair("user", "carlos"), new BasicNameValuePair("pwd", "123"))))))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void loginFailUnauthorized() throws Exception {
		mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.content(EntityUtils.toString(new UrlEncodedFormEntity(
						asList(new BasicNameValuePair("user", "charly"), new BasicNameValuePair("pwd", "111"))))))
				.andExpect(status().isForbidden());
	}

	@Test
	public void logoutSuccess() throws Exception {
		String sessionid = this.sessionData.addSession(this.user);

		mockMvc.perform(get("/logout").header("sessionid", sessionid)).andExpect(status().isAccepted());
	}
}
