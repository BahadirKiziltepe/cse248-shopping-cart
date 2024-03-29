package controllers;

import java.util.Set;

import application.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.Item;
import model.User;

/**
 * view store page
 * @author bahad
 *
 */
public class StoreController {

	private ObservableList<Item> items;
	private Set<Integer> keys;

	private Main main;

	/**
	 * It sets up main.
	 * @param main this is the main.
	 */
	public void setMain(Main main) {
		this.main = main;

		updateList();
	}

	/**
	 * Initializes the list view
	 */
	public void initialize() {
		itemList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Item>() {

			@Override
			public void changed(ObservableValue<? extends Item> observable, Item oldItem, Item newItem) {
				main.setSelectedItem(newItem);
			}
		});

		itemList.setCellFactory(new Callback<ListView<Item>, ListCell<Item>>() {

			@Override
			public ListCell<Item> call(ListView<Item> p) {
				ListCell<Item> newItem = new ListCell<Item>() {
					@Override
					protected void updateItem(Item item, boolean bool) {
						super.updateItem(item, bool);
						if (bool || item == null) {
							setText(null);
						} else {
							if (item.getStock() <= 10) {
								if (item.isTaxable()) {
									setText("Name: " + item.getProductName() + "\nCategory: " + item.getCategory()
											+ "\nPrice: $" + String.format("%.2f", item.getPrice()) + " + "
											+ item.calculateTax() + "\nStock: " + item.getStock());
								} else {
									setText("Name: " + item.getProductName() + "\nCategory: " + item.getCategory()
											+ "\nPrice: $" + String.format("%.2f", item.getPrice()) + "\nStock: "
											+ item.getStock());
								}
							} else {
								if (item.isTaxable()) {
									setText("Name: " + item.getProductName() + "\nCategory: " + item.getCategory()
											+ "\nPrice: $" + String.format("%.2f", item.getPrice()) + " + "
											+ item.calculateTax());
								} else {
									setText("Name: " + item.getProductName() + "\nCategory: " + item.getCategory()
											+ "\nPrice: $" + String.format("%.2f", item.getPrice()));
								}
							}
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
	private ListView<Item> itemList;

	@FXML
	private Button add;

	@FXML
	private TextField quantity;

	@FXML
	private Button cartBtn;

	@FXML
	private Button mainMenuBtn;

	/**
	 * Searches the list based on the given search key.
	 * 
	 * @param event use this to find items in the list.
	 */
	@FXML
	void SearchItems(ActionEvent event) {
		ObservableList<Item> itemsToShow = FXCollections.observableArrayList();
		if (searchBar.getText().contentEquals("")) {
			itemList.setItems(items);
		} else {
			for (Item i : items) {
				if (i.toString().toLowerCase().contains(searchBar.getText().toLowerCase())) {
					itemsToShow.add(i);
				}
			}
			itemList.setItems(itemsToShow);
		}
	}

	/**
	 * adds the selected item to user's shopping cart.
	 * @param event use this to add n item to your shopping cart.
	 */
	@FXML
	void addToCart(ActionEvent event) {
		if(!main.checkIfInteger(quantity.getText())) {
			quantity.setText("1");
		}
		
		if (main.getSelectedItem().getStock() >= Integer.parseInt(quantity.getText())) {
			Item newItem = new Item(main.getSelectedItem());
			newItem.setStock(Integer.parseInt(quantity.getText()));
			((User) main.getCurrentUser()).getCart().addItemToCart(newItem);
			
			main.getSelectedItem().subtractFromStock(Integer.parseInt(quantity.getText()));
			
			main.saveData(main.getData());
			updateList();
		}
	}

	/**
	 * Goes back to the main menu.
	 * 
	 * @param event use to go to the main menu.
	 */
	@FXML
	void goToMainMenu(ActionEvent event) {
		main.showMainMenuPage();
		main.setSelectedItem(null);
	}

	/**
	 * it takes you to your shopping car.
	 * 
	 * @param event use this to view your shopping cart.
	 */
	@FXML
	void viewCart(ActionEvent event) {
		main.showCartPage();
		main.setSelectedItem(null);
	}

	/**
	 * updates the list.
	 */
	public void updateList() {
		items = FXCollections.observableArrayList();
		keys = main.getData().getAllItems().keySet();

		for (Integer i : keys) {
			items.add(main.getData().getAllItems().get(i));
		}

		itemList.setItems(items);
	}
}
