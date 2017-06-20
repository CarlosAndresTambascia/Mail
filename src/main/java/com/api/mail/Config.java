package com.api.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.api.mail.converter.InboxConverter;
import com.api.mail.converter.MessageConverter;

@Configuration
public class Config {
	@Autowired
	AuthFilter authFilter;

	@Bean(name = "messageConverter")
	public MessageConverter getMessageConverter() {
		return new MessageConverter();
	}

	@Bean(name = "inboxConverter")
	public InboxConverter getInboxConverter() {
		return new InboxConverter();
	}

	@Bean
	public FilterRegistrationBean myFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(authFilter);
		registration.addUrlPatterns("/api/*");
		return registration;
	}
}
