package main;

import controllers.GameController;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GameController gameController = new GameController();
		gameController.gameMainFlow();
	}

}
