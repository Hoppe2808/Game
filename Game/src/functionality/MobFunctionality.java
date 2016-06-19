package functionality;

import controllers.MobController;
import mobData.Mob;
import java.util.Random;

public class MobFunctionality {
	private MobController mC = new MobController();
	Mob mob;
	
	public Mob getRandomMob(int lvl){
		mC.createMob(lvl);
		mob = mC.getCurrentMob();
		return mob;
	}

}
