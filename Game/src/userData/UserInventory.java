package userData;

import java.util.ArrayList;

public class UserInventory {
	private int space;
	private ArrayList<Item> items = new ArrayList<Item>();
	private Item equippedWeapon;
	
	public UserInventory(){
		this.space = 20;
		this.equippedWeapon = null;
	}
	public void addItem(Item item){
		if (items.size() < space){
			this.items.add(item);
		}
	}
	public ArrayList<Item> getItems(){
		return items;
	}
	public Item getEquippedWeapon() {
		return equippedWeapon;
	}
	public void setEquippedWeapon(Item equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}
}
