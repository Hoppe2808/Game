package userData;

public class UserStats {

	int curHP;
	int maxHP;
	int baseDmg;
	int armor;
	int level;
	int[] exp = new int[2];
	
	public UserStats(){
		curHP = 100;
		maxHP = 100;
		baseDmg = 10;
		armor = 5;
		level = 1;
		exp[0] = 0;
		exp[1] = 150;
	}
	public int[] getExp() {
		return exp;
	}
	public void addExp(int id, int exp) {
		this.exp[id] = this.exp[id] + exp;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setExp(int[] exp) {
		this.exp = exp;
	}
	public void setCurHP(int addedHP){
		curHP = curHP + addedHP;
	}
	public int getCurHP(){
		return curHP;
	}
	public void setMaxHP(int addedHP){
		maxHP = maxHP + addedHP;
	}
	public int getMaxHP(){
		return maxHP;
	}
	public void setBaseDmg(int addedDmg){
		baseDmg = baseDmg + addedDmg;
	}
	public int getBaseDmg(){
		return baseDmg;
	}
	public void setArmor(int addedArmor){
		armor = armor + addedArmor;
	}
	public int getArmor(){
		return armor;
	}
	public void levelUp(){
		level++;
	}
	public int getLevel(){
		return level;
	}
}
