package userData;

import java.util.ArrayList;

public class Item {
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	String type;
	String name;
	int mainStat;

	public Item(){

	}
	public void addItem(String type, String name, int mainStat){
		if (type.equals("Weapon")){
			this.weapons.add(new Weapon(name, mainStat));
		}
	}
	
	
	
	private class Weapon{
		String name;
		int damage;
		
		public Weapon(String name, int damage){
			this.name = name;
			this.damage = damage;
		}
		
		
	}
}
