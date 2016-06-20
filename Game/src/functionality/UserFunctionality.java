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
	public void addItemToInventory(Item item){
		uI.addItem(item);
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
		return uS.getBaseDmg();
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
		uS.setMaxHP((int) (uS.getMaxHP() * 0.25));
		uS.setCurHP(uS.getMaxHP());
		uS.setBaseDmg((int) (uS.getBaseDmg() * 0.1));
		uS.setArmor((int) (uS.getArmor() * 0.01));
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
