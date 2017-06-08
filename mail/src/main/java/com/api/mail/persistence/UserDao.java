package com.api.mail.persistence;

import java.util.Collection;
import com.api.mail.entities.User;

public interface UserDao {
	Collection<User> getAllUsers();

	User getUserById(int id);

	void removeUserById(int id);

	void updateUser(User user);

	void insertUser(User user);
}
