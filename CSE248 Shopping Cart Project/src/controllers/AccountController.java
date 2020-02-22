package controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Admin;

public class AccountController {
	
	private Main main;
	
	public void setMain(Main main) {
		this.main = main;
		
		this.username.setText(main.getCurrentUser().getUserName());
		this.password.setText(main.getCurrentUser().getPassword());
		this.email.setText(main.getCurrentUser().getEmail());
		this.firstName.setText(main.getCurrentUser().getName().getFirstName());
		this.middleName.setText(main.getCurrentUser().getName().getMiddleName());
		this.lastName.setText(main.getCurrentUser().getName().getLastName());
		this.street.setText(main.getCurrentUser().getAddress().getStreet());
		this.state.setText(main.getCurrentUser().getAddress().getState());
		this.city.setText(main.getCurrentUser().getAddress().getCity());
		this.zipCode.setText(main.getCurrentUser().getAddress().getZipCode());
		this.country.setText(main.getCurrentUser().getAddress().getCountry());
	}
	
    @FXML
    private Button editAccount;

    @FXML
    private Text back;
    
    @FXML
    private Text username;

    @FXML
    private Text password;

    @FXML
    private Text email;

    @FXML
    private Text firstName;

    @FXML
    private Text middleName;

    @FXML
    private Text lastName;

    @FXML
    private Text street;

    @FXML
    private Text state;

    @FXML
    private Text city;

    @FXML
    private Text zipCode;

    @FXML
    private Text country;

    @FXML
    void goBack(MouseEvent event) {
    	if(main.getCurrentUser().getClass() == Admin.class) {
    		main.showAdminPage();
    	}else {    		
    		main.showMainMenuPage();
    	}
    }

    @FXML
    void editAccount(ActionEvent event) {
    	main.showEditAccountPage();
    }

    @FXML
    void hyperEnter(MouseEvent event) {
    	back.setCursor(Cursor.HAND);
    	back.setUnderline(true);
    	back.setFill(Color.CYAN);
    }

    @FXML
    void hyperOut(MouseEvent event) {
    	back.setUnderline(false);
    	back.setFill(Color.BLACK);
    }

    @FXML
    void mouseNotOnButton(MouseEvent event) {

    }

    @FXML
    void mouseOnButton(MouseEvent event) {

    }

}
