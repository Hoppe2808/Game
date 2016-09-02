package functionality;

import userData.UserStats;

import java.util.ArrayList;

import userData.Item;
import userData.UserInventory;
import userData.UserMenus;

public class UserFunctionality {

	private UserStats uS;
	private UserMenus uM;
	private UserInventory uI;
	double armorBuffer = 0;
	
	public UserFunctionality(){
		uS = new UserStats();
		uM = new UserMenus();
		uI = new UserInventory();
	}
	
	public ArrayList<Item> getUserInventory() {
		return uI.getItems();
	}

	public void setuI(UserInventory uI) {
		this.uI = uI;
	}
	public Item getEquippedWeapon(){
		return this.uI.getEquippedWeapon();
	}
	public void setEquippedWeapon(Item weap){
		this.uI.setEquippedWeapon(weap);
	}
	public Item addItemToInventory(Item item){
		uI.addItem(item);
		return item;
	}
	public int getUserHealthCurrent(){
		return uS.getCurHP();
	}
	public int getUserHealthMax(){
		return uS.getMaxHP();
	}
	public void setUserHealthCurrent(int hp){
		if (uS.getCurHP() > 0) {
			uS.setCurHP(hp);
		}
	}
	public int getUserDMG(){
		int damage;
		if(!(uI.getEquippedWeapon() == null)){
			Item weapon = uI.getEquippedWeapon();
			damage = uS.getBaseDmg() + weapon.getMainStat();
		} else {
			damage = uS.getBaseDmg();
		}
		return damage;
	}
	public void setUserDMG(int dmg){
		uS.setBaseDmg(dmg);
	}
	public int getUserArmor(){
		return uS.getArmor();
	}
	public void setUserArmor(int armor){
		uS.setArmor(armor);
	}
	public void setMenu(int nr) {
		uM.setMenu(nr);
	}
	public int getMenu(){
		return uM.getMenu();
	}
	public int getLevel(){
		return uS.getLevel();
	}
	public void levelUp(){
		uS.levelUp();
		uS.setMaxHP((int) (uS.getMaxHP() * 0.30));
		uS.setCurHP(uS.getMaxHP());
		uS.setBaseDmg((int) (uS.getBaseDmg() * 0.15));
		if (uS.getArmor() < 100){
			armorBuffer = armorBuffer + 0.5;
			if (armorBuffer == 1) {
				uS.setArmor(1);
				armorBuffer = 0;
			}
		} else {
			uS.setArmor((int) (uS.getArmor() * 0.01));
		}
	}
	public void addExp(int id, int exp){
		uS.addExp(id, exp);
	}
	public void setExp(int[] exp){
		uS.setExp(exp);
	}
	public int[] getExp(){
		return uS.getExp();
	}
}
