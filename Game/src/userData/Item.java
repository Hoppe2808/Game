package userData;

import java.util.ArrayList;

public class Item {
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	String type;
	String name;
	int mainStat;

	public Item(String type, String name, int mainStat){
		this.type = type;
		this.name = name;
		this.mainStat = mainStat;
		if (type.equals("Weapon")){
			this.weapons.add(new Weapon(name, mainStat));
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMainStat() {
		return mainStat;
	}

	public void setMainStat(int mainStat) {
		this.mainStat = mainStat;
	}

	public Weapon getWeapon(String name){
		for (int i = 0; i < weapons.size(); i++){
			if (weapons.get(i).name.equals(name)){
				return weapons.get(i);
			}
		}
		return null;
	}
	public ArrayList<Weapon> getAllWeapons(){
		return weapons;
	}
	
	public class Weapon{
		String name;
		int damage;
		
		public Weapon(String name, int damage){
			this.name = name;
			this.damage = damage;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getDamage() {
			return damage;
		}

		public void setDamage(int damage) {
			this.damage = damage;
		}
		
		
	}
}
