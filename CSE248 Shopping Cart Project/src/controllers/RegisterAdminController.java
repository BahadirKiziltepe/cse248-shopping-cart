package controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Address;
import model.Admin;
import model.Name;

/**
 * registers a new admin
 * 
 * @author bahad
 *
 */
public class RegisterAdminController {

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
	private TextField username;

	@FXML
	private TextField password;

	@FXML
	private TextField email;

	@FXML
	private TextField firstName;

	@FXML
	private TextField middleName;

	@FXML
	private TextField lastName;

	@FXML
	private TextField street;

	@FXML
	private TextField state;

	@FXML
	private TextField city;

	@FXML
	private TextField zipCode;

	@FXML
	private TextField country;

	@FXML
	private Button createAccount;

	@FXML
	private Text login;

	/**
	 * creates a new account as admin.
	 * 
	 * @param event use this to create an admin.
	 */
	@FXML
	void CreateNewAccount(ActionEvent event) {
		if (!(username.getText().equals("") || password.getText().equals("") || email.getText().equals("")
				|| firstName.getText().equals("") || lastName.getText().equals("") || street.getText().equals("")
				|| state.getText().equals("") || city.getText().equals("") || zipCode.getText().equals("")
				|| country.getText().equals(""))) {
			if (!main.getData().getAllAccounts().containsKey(username.getText())) {
				Name name;
				if (middleName.getText().equals("")) {
					name = new Name(firstName.getText(), lastName.getText());
				} else {
					name = new Name(firstName.getText(), middleName.getText(), lastName.getText());
				}
				Address address = new Address(street.getText(), state.getText(), city.getText(), zipCode.getText(),
						country.getText());

				Admin account = new Admin(username.getText(), password.getText(), name, address, email.getText());

				main.getData().registerAdmin(username.getText(), account);
				main.saveData(main.getData());

				main.showLoginPage();
			}
		}
	}

	@FXML
	void mouseOnButton(MouseEvent event) {
		createAccount.setCursor(Cursor.HAND);
		createAccount.setUnderline(true);
	}

	@FXML
	void mouseNotOnButton(MouseEvent event) {
		createAccount.setUnderline(false);
	}

	/**
	 * takes you to the login scene.
	 * 
	 * @param event use this to go back to the login page without saving
	 *              ingormations.
	 */
	@FXML
	void setSceneLogin(MouseEvent event) {
		main.showLoginPage();
	}

	@FXML
	void hyperEnter(MouseEvent event) {
		login.setCursor(Cursor.HAND);
		login.setUnderline(true);
		login.setFill(Color.CYAN);
	}

	@FXML
	void hyperOut(MouseEvent event) {
		login.setUnderline(false);
		login.setFill(Color.BLACK);
	}

}
