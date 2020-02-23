package controllers;

import model.*;
import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterController {
	
	private Main main;
	
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

	@FXML
	void CreateNewAccount(ActionEvent event) {
		Name name;
		if(middleName.getText().equals("")) {
			name = new Name(firstName.getText(), lastName.getText());
		} else {
			name = new Name(firstName.getText(), middleName.getText(), lastName.getText());
		}
		Address address = new Address(street.getText(), state.getText(), city.getText(), zipCode.getText(), country.getText());
		
		User account = new User(username.getText(), password.getText(), name, address, email.getText());
		
		main.getData().registerUser(username.getText(), account);
		main.saveData(main.getData());
		
		main.showLoginPage();
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