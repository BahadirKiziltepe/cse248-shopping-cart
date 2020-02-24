package controllers;

import application.Main;

/**
 * This is the root controller, makes sure everything works.
 * 
 * @author bahad
 *
 */
public class RootController {

	private Main main;

	/**
	 * It sets up main.
	 * 
	 * @param main this is the main.
	 */
	public void setMain(Main main) {
		this.main = main;
	}
}
