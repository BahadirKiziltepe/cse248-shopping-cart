package controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Item;

public class StoreController {
	
	private Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchBtn;

    @FXML
    private ListView<Item> itemList;

    @FXML
    void SearchItems(ActionEvent event) {
    	
    }
}
