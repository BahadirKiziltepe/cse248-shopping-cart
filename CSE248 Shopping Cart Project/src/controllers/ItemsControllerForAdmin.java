package controllers;

import java.util.Set;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.Item;

public class ItemsControllerForAdmin {

	private ObservableList<Item> items;
	private Set<Integer> keys;
	private Main main;

	public void setMain(Main main) {
		this.main = main;

		items = FXCollections.observableArrayList();
		keys = main.getData().getAllItems().keySet();

		for (Integer i : keys) {
			items.add(main.getData().getAllItems().get(i));
		}
		itemList.setItems(items);

		itemList.setCellFactory(new Callback<ListView<Item>, ListCell<Item>>() {

			@Override
			public ListCell<Item> call(ListView<Item> p) {
				ListCell<Item> newItem = new ListCell<Item>() {
					@Override
					protected void updateItem(Item item, boolean bool) {
						super.updateItem(item, bool);
						if(item != null) {
							setText("ID: " + item.getItemID() + "\nName: " + item.getProductName()
		                    + "\nCategory: " + item.getCategory() + "\nPrice: " + item.getPrice() + "\nStock: "
		                    + item.getStock());
						}
					}
				};

				return newItem;
			}
		});
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
	private ListView<Item> itemList;

	@FXML
	void addItem(ActionEvent event) {
		Item newItem = new Item(itemName.getText(), Integer.parseInt(itemID.getText()), Double.parseDouble(itemPrice.getText()), itemCategory.getText(),
				checkIfTaxable.isSelected(), Integer.parseInt(itemCount.getText()));
		main.getData().addItemToStore(newItem);
		main.saveData(main.getData());

		items = FXCollections.observableArrayList();
		keys = main.getData().getAllItems().keySet();

		for (Integer i : keys) {
			items.add(main.getData().getAllItems().get(i));
		}
		this.itemList.setItems(items);
	}

	@FXML
	void goToMainMenu(ActionEvent event) {
		main.showAdminPage();
	}

	@FXML
	void search(ActionEvent event) {
		ObservableList<Item> itemsToShow = FXCollections.observableArrayList();
		if(searchBar.getText().contentEquals("")) {
			this.itemList.setItems(items);
		} else {
			for(Item i : items) {
				if(i.toString().toLowerCase().contains(searchBar.getText().toLowerCase())) {
					itemsToShow.add(i);
				}
			}
			this.itemList.setItems(itemsToShow);
		}
	}

}