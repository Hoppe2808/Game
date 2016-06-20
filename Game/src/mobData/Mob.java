package mobData;

public class Mob {
	int hp;
	int maxHp;
	int dmg;
	String name;
	double dropChance;
	
	public Mob(int health, int damage, double dropChance){
		hp = health;
		maxHp = health;
		dmg = damage;
		this.dropChance = dropChance;
	}
	public void setHealth(int health){
		if (hp + health < 0){
			hp = 0;
		} else {
			hp = hp + health;
		}
	}
	public int getHealth(){
		return hp;
	}
	public void setDmg(int damage){
		dmg = dmg + damage;
	}
	public int getDamage(){
		return dmg;
	}
	public int getMaxHp(){
		return maxHp;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public double getDropChance() {
		return dropChance;
	}
	public void setDropChance(double dropChance) {
		this.dropChance = dropChance;
	}
}
