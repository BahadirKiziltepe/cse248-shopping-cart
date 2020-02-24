package controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminController {

	private Main main;

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

    @FXML
    void logout(ActionEvent event) {
    	main.setCurrentUser(null);
    	main.showLoginPage();
    }

    @FXML
    void showAccount(ActionEvent event) {
    	main.setUserPickedByAdmin(main.getCurrentUser());
    	main.showAccountPage();
    }

    @FXML
    void showAccounts(ActionEvent event) {
    	main.showAccountsForAdmin();
    }

    @FXML
    void showItems(ActionEvent event) {
    	main.showItemsForAdmin();
    }

    @FXML
    void showWareHouse(ActionEvent event) {
    	main.showWareHouseForAdmin();
    }
    
}
