package com.api.mail.persistence;

import org.springframework.data.repository.CrudRepository;
import com.api.mail.entities.Message;
import com.api.mail.entities.User;

import java.util.List;


public interface MessageRepository extends CrudRepository<Message, Long> {
	List<Message> findByRemittent(User user);
	List<Message> findByReciver(User user);
	

}
