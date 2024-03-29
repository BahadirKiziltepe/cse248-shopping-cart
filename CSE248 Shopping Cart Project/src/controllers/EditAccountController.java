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
import model.Admin;

/**
 * Allows editing account informations.
 * 
 * @author bahad
 *
 */
public class EditAccountController {

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
	private Button confirmChanges;

	@FXML
	private Text cancel;

	/**
	 * cancels the changes
	 * 
	 * @param event use this if you do not want to save changes.
	 */
	@FXML
	void cancelChanges(MouseEvent event) {
		if (main.getCurrentUser().getClass() == Admin.class) {
			if (main.isViewAccounts()) {
				main.showAccountsForAdmin();
			} else {
				main.showAccountPage();
			}
		} else {
			main.showAccountPage();
		}
	}

	/**
	 * changes the selected account's informations based on given keys. admin can
	 * change an accounts information in this page as well
	 * 
	 * @param event use this to edit an account.
	 */
	@FXML
	void changeAccount(ActionEvent event) {
		if (main.getCurrentUser().getClass() == Admin.class) {
			if (password.getText().equals("")) {
				; // nop
			} else {
				main.getUserPickedByAdmin().setPassword(password.getText());
			}

			if (email.getText().equals("")) {
				; // nop
			} else {
				main.getUserPickedByAdmin().setEmail(email.getText());
			}

			if (firstName.getText().equals("")) {
				; // nop
			} else {
				main.getUserPickedByAdmin().getName().setFirstName(firstName.getText());
			}

			if (middleName.getText().equals("")) {
				; // nop
			} else {
				main.getUserPickedByAdmin().getName().setMiddleName(middleName.getText());
			}

			if (lastName.getText().equals("")) {
				; // nop
			} else {
				main.getUserPickedByAdmin().getName().setLastName(lastName.getText());
			}

			if (street.getText().equals("")) {
				; // nop
			} else {
				main.getUserPickedByAdmin().getAddress().setStreet(street.getText());
			}

			if (state.getText().equals("")) {
				; // nop
			} else {
				main.getUserPickedByAdmin().getAddress().setState(state.getText());
			}

			if (city.getText().equals("")) {
				; // nop
			} else {
				main.getUserPickedByAdmin().getAddress().setCity(city.getText());
			}

			if (zipCode.getText().equals("")) {
				; // nop
			} else {
				main.getUserPickedByAdmin().getAddress().setZipCode(zipCode.getText());
			}

			if (country.getText().equals("")) {
				; // nop
			} else {
				main.getUserPickedByAdmin().getAddress().setCountry(country.getText());
			}
			if (main.isViewAccounts()) {
				main.showAccountsForAdmin();
			} else {
				main.showAccountPage();
			}
		} else {
			if (password.getText().equals("")) {
				; // nop
			} else {
				main.getCurrentUser().setPassword(password.getText());
			}

			if (email.getText().equals("")) {
				; // nop
			} else {
				main.getCurrentUser().setEmail(email.getText());
			}

			if (firstName.getText().equals("")) {
				; // nop
			} else {
				main.getCurrentUser().getName().setFirstName(firstName.getText());
			}

			if (middleName.getText().equals("")) {
				; // nop
			} else {
				main.getCurrentUser().getName().setMiddleName(middleName.getText());
			}

			if (lastName.getText().equals("")) {
				; // nop
			} else {
				main.getCurrentUser().getName().setLastName(lastName.getText());
			}

			if (street.getText().equals("")) {
				; // nop
			} else {
				main.getCurrentUser().getAddress().setStreet(street.getText());
			}

			if (state.getText().equals("")) {
				; // nop
			} else {
				main.getCurrentUser().getAddress().setState(state.getText());
			}

			if (city.getText().equals("")) {
				; // nop
			} else {
				main.getCurrentUser().getAddress().setCity(city.getText());
			}

			if (zipCode.getText().equals("")) {
				; // nop
			} else {
				main.getCurrentUser().getAddress().setZipCode(zipCode.getText());
			}

			if (country.getText().equals("")) {
				; // nop
			} else {
				main.getCurrentUser().getAddress().setCountry(country.getText());
			}
			main.showAccountPage();
		}
		main.saveData(main.getData());
	}

	@FXML
	void hyperEnter(MouseEvent event) {
		cancel.setCursor(Cursor.HAND);
		cancel.setUnderline(true);
		cancel.setFill(Color.CYAN);
	}

	@FXML
	void hyperOut(MouseEvent event) {
		cancel.setUnderline(false);
		cancel.setFill(Color.BLACK);
	}

	@FXML
	void mouseNotOnButton(MouseEvent event) {
		confirmChanges.setUnderline(false);
	}

	@FXML
	void mouseOnButton(MouseEvent event) {
		confirmChanges.setCursor(Cursor.HAND);
		confirmChanges.setUnderline(true);
	}

}
