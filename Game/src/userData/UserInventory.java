package userData;

import java.util.ArrayList;

public class UserInventory {
	private int space;
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public UserInventory(){
		this.space = 20;
	}
	public void addItem(Item item){
		this.items.add(item);
	}
	public ArrayList<Item> getItems(){
		return items;
	}
}
