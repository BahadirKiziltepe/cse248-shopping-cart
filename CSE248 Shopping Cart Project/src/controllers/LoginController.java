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

public class LoginController {

	private Main main;

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

	@FXML
	void Login(ActionEvent event) {
		if (main.getData().getAllAccounts().containsKey(username.getText())) {
			if (main.getData().getAllAccounts().get(username.getText()).getPassword().equals(password.getText())) {
				main.setCurrentUser(main.getData().getAllAccounts().get(username.getText()));
				main.showMainMenuPage();
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