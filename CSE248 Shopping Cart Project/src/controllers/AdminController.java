package controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * admin's main menu.
 * 
 * @author bahad
 *
 */
public class AdminController {

	private Main main;

	/**
	 * It sets up main.
	 * 
	 * @param main this is the main.
	 */
	public void setMain(Main main) {
		this.main = main;
	}

	@FXML
	private Button accountsBtn;

	@FXML
	private Button itemsBtn;

	@FXML
	private Button wareHouseBtn;

	@FXML
	private Button accountBtn;

	@FXML
	private Button logoutBtn;

	/**
	 * logs out the current admin.
	 * 
	 * @param event use this to log out from your account.
	 */
	@FXML
	void logout(ActionEvent event) {
		main.setCurrentUser(null);
		main.showLoginPage();
	}

	/**
	 * takes you to page to view the account's informations.
	 * 
	 * @param event use this to see your account details.
	 */
	@FXML
	void showAccount(ActionEvent event) {
		main.setUserPickedByAdmin(main.getCurrentUser());
		main.showAccountPage();
	}

	/**
	 * takes you to the page to view all users.
	 * 
	 * @param event use this to view users.
	 */
	@FXML
	void showAccounts(ActionEvent event) {
		main.showAccountsForAdmin();
	}

	/**
	 * takes you to the page to view and edit items.
	 * 
	 * @param event use this to edit/add/delete/order items.
	 */
	@FXML
	void showItems(ActionEvent event) {
		main.showItemsForAdmin();
	}

	/**
	 * takes you to the page to view orders.
	 * 
	 * @param event use this to manage orders.
	 */
	@FXML
	void showWareHouse(ActionEvent event) {
		main.showWareHouseForAdmin();
	}

}
