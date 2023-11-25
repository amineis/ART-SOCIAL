package model;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
public class User {
	
	public int id;
	public String name;
	public String username;
	public String mdp;
	public String email;
	public int followers;
	public InputStream image;
	public String country;
	public String gender;
	public String admin;
	
	public User(int id, String name, String username, String mdp, String email, int followers, InputStream image,
			String country, String gender, String admin) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.mdp = mdp;
		this.email = email;
		this.followers = followers;
		this.image = image;
		this.country = country;
		this.gender = gender;
		this.admin = admin;
	}
	public User(String username, String mdp, String email) {
		super();
		this.username = username;
		this.mdp = mdp;
		this.email = email;
	}
	public User(String name, String username, String mdp, String email, int followers, InputStream image,
			String country, String gender, String admin) {
		super();
		this.name = name;
		this.username = username;
		this.mdp = mdp;
		this.email = email;
		this.followers = followers;
		this.image = image;
		this.country = country;
		this.gender = gender;
		this.admin = admin;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}

}
