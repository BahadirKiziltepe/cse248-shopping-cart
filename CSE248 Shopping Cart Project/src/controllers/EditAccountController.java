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

public class EditAccountController {

	private Main main;

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

    @FXML
    void cancelChanges(MouseEvent event) {
    	main.showMainMenuPage();
    }

    @FXML
    void changeAccount(ActionEvent event) {
    	if(password.getText().equals("")) {
    		; //nop
    	} else {
    		main.getCurrentUser().setPassword(password.getText());
    	}
    	
    	if(email.getText().equals("")) {
    		; //nop
    	} else {
    		main.getCurrentUser().setEmail(email.getText());
    	}
    	
    	if(firstName.getText().equals("")) {
    		; //nop
    	} else {
    		main.getCurrentUser().getName().setFirstName(firstName.getText());
    	}
    	
    	if(middleName.getText().equals("")) {
    		; //nop
    	} else {
    		main.getCurrentUser().getName().setMiddleName(middleName.getText());
    	}
    	
    	if(lastName.getText().equals("")) {
    		; //nop
    	} else {
    		main.getCurrentUser().getName().setLastName(lastName.getText());
    	}
    	
    	if(street.getText().equals("")) {
    		; //nop
    	} else {
    		main.getCurrentUser().getAddress().setStreet(street.getText());
    	}
    	
    	if(state.getText().equals("")) {
    		; //nop
    	} else {
    		main.getCurrentUser().getAddress().setState(state.getText());
    	}
    	
    	if(city.getText().equals("")) {
    		; //nop
    	} else {
    		main.getCurrentUser().getAddress().setCity(city.getText());
    	}
    	
    	if(zipCode.getText().equals("")) {
    		; //nop
    	} else {
    		main.getCurrentUser().getAddress().setZipCode(zipCode.getText());
    	}
    	
    	if(country.getText().equals("")) {
    		; //nop
    	} else {
    		main.getCurrentUser().getAddress().setCountry(country.getText());
    	}
    	
    	main.showAccountPage();
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