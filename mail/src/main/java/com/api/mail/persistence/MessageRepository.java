package com.api.mail.persistence;

import org.springframework.data.repository.CrudRepository;
import com.api.mail.entities.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
