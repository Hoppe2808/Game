package controllers;

import java.awt.EventQueue;

import controllers.MobController;
import functionality.UserFunctionality;
import functionality.MobFunctionality;
import userInterface.MainFrame;

public class GameController {
	UserFunctionality uF = new UserFunctionality();
	MobFunctionality mF = new MobFunctionality();
	private int menu;
	private int isMobAlive;
	
	public void gameMainFlow(){

		menu = uF.getMenu();
		if (menu == 0){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MainFrame frame = new MainFrame(uF, mF);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else if(menu == 1){
			
		}
		
	}
	
}
