package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import userData.Item;

public class ItemController {

	Random randomGenerator = new Random();
	private Item item = new Item();
	
	public ItemController(){
	 	item.addItem("Weapon", "Cracked Sword", 3);
		
	}
}
