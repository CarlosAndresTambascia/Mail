package com.api.mail.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.api.mail.entities.User;

@Repository
@Qualifier("fakeData")
public class FakeUserDao implements UserDao {
	private static Map<Integer, User> users;
	// creo unos valores cargados por defecto para probar mi codigo
	static {

		users = new HashMap<Integer, User>() {

			{
				put(1, new User(1, "John", "Travolta", "Abc Street", 223222222, "mdp", "arg", "aaa@aaa.com", "111"));
				put(2, new User(2, "John", "Travolta", "Abc Street", 223222222, "mdp", "arg", "aaa@aaa.com", "111"));
				put(3, new User(3, "John", "Travolta", "Abc Street", 223222222, "mdp", "arg", "aaa@aaa.com", "111"));
			}
		};
	}

	public Collection<User> getAllUsers() {
		return this.users.values();
	}

	public User getUserById(int id) {
		return this.users.get(id);
	}

	public void removeUserById(int id) {
		this.users.remove(id);

	}

	public void updateUser(User user) {
		User u = users.get(user.getId());
		u.setAdress(user.getAdress());
		u.setCity(user.getCity());
		u.setContry(user.getContry());
		u.setMail(user.getMail());
		u.setName(user.getName());
		u.setPhone(user.getPhone());
		u.setPwd(user.getPwd());
		u.setSurname(user.getSurname());
	}

	public void insertUser(User user) {
		this.users.put(user.getId(), user);
	}

}
