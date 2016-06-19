package functionality;

import userData.UserStats;
import userData.UserMenus;

public class UserFunctionality {

	private UserStats uS;
	private UserMenus uM;
	
	public UserFunctionality(){
		uS = new UserStats();
		uM = new UserMenus();
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
}
