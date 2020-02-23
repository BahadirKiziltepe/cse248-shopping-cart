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
import model.Order;
import model.User;

public class CartController {

	private ObservableList<Item> items;
	private Set<Integer> keys;

	private Main main;

	public void setMain(Main main) {
		this.main = main;

		updateList();
	}

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
							if (item.isTaxable()) {
								setText("ID: " + item.getItemID() + "\nName: " + item.getProductName() + "\nCategory: "
										+ item.getCategory() + "\nPrice: $" + item.getPrice() + " + "
										+ item.calculateTax() + "\nQuantity: " + item.getStock());
							} else {
								setText("ID: " + item.getItemID() + "\nName: " + item.getProductName() + "\nCategory: "
										+ item.getCategory() + "\nPrice: $" + item.getPrice() + "\nQuantity: "
										+ item.getStock());
							}
						}
					}
				};

				return newItem;
			}
		});
	}

	@FXML
	private ListView<Item> itemList;

	@FXML
	private Button searchBtn;

	@FXML
	private TextField searchBar;

	@FXML
	private Button storeBtn;

	@FXML
	private Button mainMenuBtn;

	@FXML
	private Button increase;

	@FXML
	private TextField quantity;

	@FXML
	private Button remove;

	@FXML
	private Button checkOut;

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

	@FXML
	void checkOut(ActionEvent event) {
		Order order = new Order(((User) main.getCurrentUser()).getCart().totalPriceCalculation(), 0,
				main.getCurrentUser());
		main.setSelectedItem(null);
	}

	@FXML
	void goToMainMenu(ActionEvent event) {
		main.showMainMenuPage();
		main.setSelectedItem(null);
	}

	@FXML
	void increase(ActionEvent event) {
		if (main.getSelectedItem() != null) {
			main.getSelectedItem().addToStock(1);
			updateList();
		}
	}

	@FXML
	void remove(ActionEvent event) {
		if (main.getSelectedItem() != null) {
			((User) main.getCurrentUser()).getCart().removeItemFromCart(main.getSelectedItem());
			updateList();
		}
	}

	@FXML
	void viewStore(ActionEvent event) {
		main.showStorePage();
		main.setSelectedItem(null);
	}

	public void updateList() {
		items = FXCollections.observableArrayList();
		keys = 	((User) main.getCurrentUser()).getCart().getItemsInCart().keySet();

		for (Integer i : keys) {
			items.add(main.getData().getAllItems().get(i));
		}

		itemList.setItems(items);
	}
}