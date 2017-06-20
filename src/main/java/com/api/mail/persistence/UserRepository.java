package com.api.mail.persistence;

import org.springframework.data.repository.CrudRepository;

import com.api.mail.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByName(String name);
}
