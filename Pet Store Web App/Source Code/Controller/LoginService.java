package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.model.User;

public class LoginService {
	
	public static User login(String inputPassword, String inputUserName) {
		List<User> users = new ArrayList<User>();
		User user0 = new User("ali", "password123");
		User user1 = new User("zeke", "password123");
		User user2 = new User("pratt", "password123");
		User user3 = new User("diego", "password123");
		users.add(user0);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		for (int i=0; i<users.size(); i++) {
			if (users.get(i).getUsername().equals(inputUserName)) {
				if (users.get(i).getPassword().equals(inputPassword)) {
					return users.get(i);
				}
			}
		}
		
		return null;
		
	}

}
