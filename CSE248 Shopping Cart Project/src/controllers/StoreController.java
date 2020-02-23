package controllers;

import java.util.Set;

import application.Main;
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

public class StoreController {

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
						if (bool || item == null) {
							setText(null);
						} else {
							if (item.getStock() <= 10) {
								if (item.isTaxable()) {
									setText("Name: " + item.getProductName() + "\nCategory: " + item.getCategory()
											+ "\nPrice: $" + String.format("%2f", item.getPrice()) + " + " + item.calculateTax() + "\nLess than 10 in stock...");
								} else {
									setText("Name: " + item.getProductName() + "\nCategory: " + item.getCategory()
											+ "\nPrice: $" + String.format("%2f", item.getPrice()) + "\nLess than 10 in stock...");
								}
							} else {
								if (item.isTaxable()) {
									setText("Name: " + item.getProductName() + "\nCategory: " + item.getCategory()
											+ "\nPrice: $" + String.format("%2f", item.getPrice()) + " + " + item.calculateTax());
								} else {
									setText("Name: " + item.getProductName() + "\nCategory: " + item.getCategory()
											+ "\nPrice: $" + String.format("%2f", item.getPrice()));
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

    @FXML
    void SearchItems(ActionEvent event) {

    }

    @FXML
    void addToCart(ActionEvent event) {
    	
    }

    @FXML
    void goToMainMenu(ActionEvent event) {
    	main.showMainMenuPage();
    }

    @FXML
    void viewCart(ActionEvent event) {
    	main.showCartPage();
    }
}
