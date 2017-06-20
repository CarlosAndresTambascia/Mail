package com.api.mail.controller;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.api.mail.response.LoginResponseWrapper;
import com.api.mail.response.UserWrapper;

import junit.framework.TestCase;

public class LoginTest extends TestCase {

	RestTemplate restTemplate;

	@Test
	public void testLoginOk() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8090/login";
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("user", "Carlos");
		params.set("pwd", "123");
		ResponseEntity<LoginResponseWrapper> response = restTemplate.postForEntity(url, params,
				LoginResponseWrapper.class);
		assertNotNull(response.getBody().getSessionId());
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testGetPersona() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8090/login";
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("user", "finopablo");
		params.set("pwd", "1234");

		ResponseEntity<LoginResponseWrapper> response = restTemplate.postForEntity(url, params,
				LoginResponseWrapper.class);
		String sessionId = response.getBody().getSessionId();

		HttpHeaders headers = new HttpHeaders();
		headers.set("sessionid", sessionId);
		HttpEntity entity = new HttpEntity(headers);

		url = "http://localhost:8090/api/persona/1";

		HttpEntity<UserWrapper> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, UserWrapper.class);
		/*
		 * UserWrapper u = responseEntity.getBody();
		 * 
		 * assertEquals(u.getApellido(), "FUNES MORI");
		 */

	}
}
