package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import userData.Item;
import userData.Item.Weapon;

public class ItemController {

	Random randomGenerator = new Random();
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public ItemController(){
	 	Item item = new Item("Weapon", "Cracked Sword", 3);
		items.add(item);
	}
	public Item getSpecificItem(String name){
		for (int i = 0; i < items.size(); i++){
			if (items.get(i).getName().equals(name)){
				return items.get(i);
			}
		}
		return null;
	}
	public Item getRandomItem(){
		Item item = items.get(randomGenerator.nextInt(items.size()));
		return item;
	}
	public ArrayList<Item> getAllWeapons(){
		return items;
	}
}
