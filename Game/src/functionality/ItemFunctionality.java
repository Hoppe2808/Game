package functionality;

import java.util.ArrayList;

import controllers.ItemController;
import userData.Item;
import userData.Item.Weapon;

public class ItemFunctionality {
	private ItemController iC;
	
	public ItemFunctionality(){
		iC = new ItemController();
	}
	public Item getItem(String name){
		return iC.getSpecificItem(name);
	}
	public Item getRandomItem(){
		return iC.getRandomItem();
	}
	public ArrayList<Item> getAllItems(){
		return iC.getAllWeapons();
	}
}
