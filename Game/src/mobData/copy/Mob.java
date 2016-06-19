package mobData.copy;

public class Mob {
	int hp;
	int maxHp;
	int dmg;
	
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
}
