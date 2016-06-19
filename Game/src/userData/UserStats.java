package userData;

public class UserStats {

	int curHP;
	int maxHP;
	int baseDmg;
	int armor;
	
	public UserStats(){
		curHP = 100;
		maxHP = 100;
		baseDmg = 10;
		armor = 5;
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
}
