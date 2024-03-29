package controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Admin;

/**
 * this is the Login page
 * 
 * @author bahad
 *
 */
public class LoginController {

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
	private PasswordField password;

	@FXML
	private TextField username;

	@FXML
	private Button btnLogn;

	@FXML
	private Text createAccount;

	/**
	 * logs you in
	 * 
	 * @param event use this to log in
	 */
	@FXML
	void Login(ActionEvent event) {
		if (username.getText().equals("")) {
			if (password.getText().equals((main.getData().getAllAccounts().get("admin").getPassword()))) {
				main.showRegisterAdminPage();
			}
		}

		if (main.getData().getAllAccounts().containsKey(username.getText())) {
			if (main.getData().getAllAccounts().get(username.getText()).getPassword().equals(password.getText())) {
				main.setCurrentUser(main.getData().getAllAccounts().get(username.getText()));
				if (main.getData().getAllAccounts().get(username.getText()).getClass() == Admin.class) {
					main.showAdminPage();
				} else {
					main.showMainMenuPage();
				}
			}
		}
	}

	@FXML
	void mouseOnButton(MouseEvent event) {
		btnLogn.setCursor(Cursor.HAND);
		btnLogn.setUnderline(true);
	}

	@FXML
	void mouseNotOnButton(MouseEvent event) {
		btnLogn.setUnderline(false);
	}

	/**
	 * takes you to the creating account page.
	 * 
	 * @param event use this to create a new account.
	 */
	@FXML
	void createNewAccount(MouseEvent event) {
		main.showRegisterPage();
	}

	@FXML
	void hyperEnter(MouseEvent event) {
		createAccount.setCursor(Cursor.HAND);
		createAccount.setUnderline(true);
		createAccount.setFill(Color.CYAN);
	}

	@FXML
	void hyperOut(MouseEvent event) {
		createAccount.setUnderline(false);
		createAccount.setFill(Color.BLACK);
	}

}