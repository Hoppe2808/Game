package mobData;

public class Mob {
	int hp;
	int maxHp;
	int dmg;
	String name;
	
	public Mob(int health, int damage){
		hp = health;
		maxHp = health;
		dmg = damage;
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
}
