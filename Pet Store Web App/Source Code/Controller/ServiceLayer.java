package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.model.Animal;
import com.model.Cat;
import com.model.Fish;
import com.model.Inventory;
import com.model.Turtle;
import com.model.User;

public class ServiceLayer {
	
	public void init() {
	// TODO move hard code elsewhere

	
	Inventory inventory = new Inventory();
	
	for (int i = 0; i < Animal.MAX; i++) {
		Cat cat = new Cat();
		inventory.getAnimalsInStock().add(cat);
		
		Fish fish = new Fish();
		inventory.getAnimalsInStock().add(fish);
		
		Turtle turtle = new Turtle();
		inventory.getAnimalsInStock().add(turtle);
	}

	// TODO create users
	

	}
	

}
