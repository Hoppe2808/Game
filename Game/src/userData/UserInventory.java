package userData;

import java.util.ArrayList;

public class UserInventory {
	private int space;
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public UserInventory(){
		this.space = 20;
	}
	private void addItem(Item item){
		this.items.add(item);
	}
}
