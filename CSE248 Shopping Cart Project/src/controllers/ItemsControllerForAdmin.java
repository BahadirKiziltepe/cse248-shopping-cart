package controllers;

import java.util.Set;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Item;

public class ItemsControllerForAdmin {

	private ObservableList<String> items;
	private Set<Integer> keys;
	private Main main;

	public void setMain(Main main) {
		this.main = main;

		items = FXCollections.observableArrayList();
		keys = main.getData().getAllItems().keySet();

		for (Integer i : keys) {
			Item item = main.getData().getAllItems().get(i);
			String itemDetails = "ID: " + item.getItemID() + "\nName: " + item.getProductName()
			+ "\nCategory: " + item.getCategory() + "\nPrice: " + item.getPrice() + "\nStock: "
			+ item.getStock();
			items.add(itemDetails);
		}
		this.itemList.setItems(items);
	}

	@FXML
	private TextField searchBar;

	@FXML
	private Button searchBtn;

	@FXML
	private Button addBtn;

	@FXML
	private TextField itemID;

	@FXML
	private TextField itemName;

	@FXML
	private TextField itemCategory;

	@FXML
	private TextField itemPrice;

	@FXML
	private TextField itemCount;

	@FXML
	private CheckBox checkIfTaxable;

	@FXML
	private Button mainMenu;

	@FXML
	private ListView<String> itemList;

	@FXML
	void addItem(ActionEvent event) {
		Item newItem = new Item(itemName.getText(), Double.parseDouble(itemPrice.getText()), itemCategory.getText(),
				checkIfTaxable.isSelected(), Integer.parseInt(itemCount.getText()));
		newItem.setItemID(Integer.parseInt(itemID.getText()));
		main.getData().addItemToStore(newItem);
		main.saveData(main.getData());

		items = FXCollections.observableArrayList();
		for (Integer i : keys) {
			Item item = main.getData().getAllItems().get(i);
			String itemDetails = "ID: " + item.getItemID() + "\nName: " + item.getProductName()
					+ "\nCategory: " + item.getCategory() + "\nPrice: " + item.getPrice() + "\nStock: "
					+ item.getStock();
			items.add(itemDetails);
		}
		this.itemList.setItems(items);
	}

	@FXML
	void goToMainMenu(ActionEvent event) {
		main.showAdminPage();
	}

	@FXML
	void search(ActionEvent event) {
		ObservableList<String> itemsToShow = FXCollections.observableArrayList();
		if(searchBar.getText().contentEquals("")) {
			this.itemList.setItems(items);
		} else {
			for(String s : items) {
				if(s.toLowerCase().contains(searchBar.getText().toLowerCase())) {
					itemsToShow.add(s);
				}
			}
			this.itemList.setItems(itemsToShow);
		}
	}

}
