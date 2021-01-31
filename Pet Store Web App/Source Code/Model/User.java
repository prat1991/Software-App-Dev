package com.model;

//import java.util.Scanner;

public class User {
	private String username;
	private String password;
	private static String currentUser;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public static String getCurrentUser() {
		return currentUser;
	}
	public static void setCurrentUser(String currentUser) {
		User.currentUser = currentUser;
	}

	
}
