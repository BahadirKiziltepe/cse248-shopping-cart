package controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * user's main menu
 * 
 * @author bahad
 *
 */
public class MainMenuController {

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
	private Button logoutBtn;

	@FXML
	private Button accountBtn;

	@FXML
	private Button storeBtn;

	@FXML
	private Button CartBtn;

	@FXML
	private Button cardBtn;

	@FXML
	private Button orderHistory;

	/**
	 * logs out the current user.
	 * 
	 * @param event use this to log out from your account.
	 */
	@FXML
	void logout(ActionEvent event) {
		main.setCurrentUser(null);
		main.showLoginPage();
	}

	/**
	 * takes you to the account information page.
	 * 
	 * @param event use this to view your account informations.
	 */
	@FXML
	void AccountView(ActionEvent event) {
		main.showAccountPage();
	}

	/**
	 * takes you to the user's shopping cart.
	 * 
	 * @param event use this to view your shopping cart.
	 */
	@FXML
	void CartView(ActionEvent event) {
		main.showCartPage();
	}

	/**
	 * takes you to the credit card page.
	 * 
	 * @param event use this to edit or view your credit card.
	 */
	@FXML
	void editCard(ActionEvent event) {
		main.showCardPage();
	}

	/**
	 * takes you to the store.
	 * 
	 * @param event use this to view store.
	 */
	@FXML
	void StoreView(ActionEvent event) {
		main.showStorePage();
	}

	/**
	 * takes you to the order history.
	 * 
	 * @param event use this to view your order history.
	 */
	@FXML
	void viewOrderHistory(ActionEvent event) {
		main.showOrderHistoryPage();
	}

}
