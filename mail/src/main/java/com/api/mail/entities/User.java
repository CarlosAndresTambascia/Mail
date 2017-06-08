package com.api.mail.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String surname;
	private String adress;
	private int phone;
	private String city;
	private String contry;
	private String mail;
	private String pwd;

	
	public User() {

	}

	public User(String name, String surname, String adress, int phone, String city, String contry, String mail,
			String pwd) {
		super();
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.phone = phone;
		this.city = city;
		this.contry = contry;
		this.mail = mail;
		this.pwd = pwd;
	}

	public User(int id, String name, String surname, String adress, int phone, String city, String contry, String mail,
			String pwd) {
		super();
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.phone = phone;
		this.city = city;
		this.contry = contry;
		this.mail = mail;
		this.pwd = pwd;
		this.id = id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
