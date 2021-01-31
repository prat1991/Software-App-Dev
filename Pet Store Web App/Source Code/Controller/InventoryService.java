package com.controller;

import com.model.Animal;
import com.model.Cat;
import com.model.Fish;
import com.model.Inventory;
import com.model.Sale;
import com.model.Turtle;

public class InventoryService {
	
	public static void removeItem(Inventory inventory, Animal item) {
		
		for (int i = 0; i<inventory.getAnimalsInStock().size(); i++) {
			if (inventory.getAnimalsInStock().get(i).equals(item)) {
				inventory.getAnimalsInStock().remove(inventory.getAnimalsInStock().get(i));
				break;
			}
		}		
		
	}
	
	public static void addItem(Inventory inventory, Animal item) {
		inventory.getAnimalsInStock().add(item);
	}

//add int amount of animals to i
	public static void restock() {
		if (Cat.inStock <= Animal.MIN) {
			Cat.inStock = Animal.MAX;
		}
		if (Fish.inStock <= Animal.MIN) {
			Fish.inStock = Animal.MAX;
		}
		if (Turtle.inStock <= Animal.MIN) {
			Turtle.inStock = Animal.MAX;
		}
	}
}
