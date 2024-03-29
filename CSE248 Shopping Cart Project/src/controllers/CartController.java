package controllers;

import java.util.Set;
import java.util.TreeSet;

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
import javafx.scene.text.Text;
import javafx.util.Callback;
import model.Item;
import model.Order;
import model.User;

/**
 * user's shopping cart
 * 
 * @author bahad
 *
 */
public class CartController {

	private ObservableList<Item> items;
	private Set<Integer> keys;

	private Main main;

	/**
	 * It sets up main.
	 * 
	 * @param main this is the main.
	 */
	public void setMain(Main main) {
		this.main = main;

		updateList();

		total.setText(Double.toString(((User) main.getCurrentUser()).getCart().totalPriceCalculation()));
		subTotal.setText(Double.toString(((User) main.getCurrentUser()).getCart().subTotalPriceCalculation()));
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
							if (item.isTaxable()) {
								setText("Name: " + item.getProductName() + "\nCategory: " + item.getCategory()
										+ "\nPrice: $" + item.getPrice() + " + " + item.calculateTax() + "\nQuantity: "
										+ item.getStock());
							} else {
								setText("Name: " + item.getProductName() + "\nCategory: " + item.getCategory()
										+ "\nPrice: $" + item.getPrice() + "\nQuantity: " + item.getStock());
							}
						}
					}
				};

				return newItem;
			}
		});
	}

	@FXML
	private Text subTotal;

	@FXML
	private Text total;

	@FXML
	private Text warning;

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

	/**
	 * searches through the list based on the given search key.
	 * 
	 * @param event use this to search an item in your shopping cart.
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
	 * checks out the items that are in the shopping cart
	 * 
	 * @param event use this to buy the selected items.
	 */
	@FXML
	void checkOut(ActionEvent event) {
		if (((User) main.getCurrentUser()).getSavedCard() != null) {
			if (((User) main.getCurrentUser()).getCart().getItemsInCart().size() > 0) {
				warning.setText("");

				Order order = new Order(((User) main.getCurrentUser()).getCart().totalPriceCalculation(),
						((User) main.getCurrentUser()).getCart().subTotalPriceCalculation(), main.getCurrentUser());

				Set<Integer> keys = ((User) main.getCurrentUser()).getCart().getItemsInCart().keySet();
				TreeSet<Item> itemsBought = new TreeSet<>();
				for (Integer i : keys) {
					itemsBought.add(((User) main.getCurrentUser()).getCart().getItemsInCart().get(i));
				}
				order.setItemsbought(itemsBought);
				main.getData().addOrderToStore(order);

				((User) main.getCurrentUser()).getCart().getItemsInCart().clear();
				updateList();

				total.setText(Double.toString(((User) main.getCurrentUser()).getCart().totalPriceCalculation()));
				subTotal.setText(Double.toString(((User) main.getCurrentUser()).getCart().subTotalPriceCalculation()));

				main.saveData(main.getData());
				main.setSelectedItem(null);
			}
		} else {
			warning.setText("Register a valid Credit Card");
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
	 * increases the quantity of a selected item that is in the shopping cart.
	 * 
	 * @param event use this if you need to buy more of a selected item if store
	 *              carries it.
	 */
	@FXML
	void increase(ActionEvent event) {
		if (!main.checkIfInteger(quantity.getText())) {
			quantity.setText("1");
		}

		if (main.getSelectedItem() != null) {
			if (main.getData().getAllItems().get(main.getSelectedItem().getItemID()).getStock() >= Integer
					.parseInt(quantity.getText())) {
				main.getSelectedItem().addToStock(Integer.parseInt(quantity.getText()));
				main.getData().getAllItems().get(main.getSelectedItem().getItemID())
						.subtractFromStock(Integer.parseInt(quantity.getText()));

				main.saveData(main.getData());
				updateList();

				total.setText(Double.toString(((User) main.getCurrentUser()).getCart().totalPriceCalculation()));
				subTotal.setText(Double.toString(((User) main.getCurrentUser()).getCart().subTotalPriceCalculation()));
			}
		}
	}

	/**
	 * decreases the quantity of a selected item that is in the shopping cart, if 0,
	 * removes it.
	 * 
	 * @param event use this if you need to decrease the quantity of a selected item
	 *              or to remove it from your shopping cart.
	 */
	@FXML
	void remove(ActionEvent event) {
		if (!main.checkIfInteger(quantity.getText())) {
			quantity.setText("1");
		}

		if (main.getSelectedItem() != null) {

			if (((User) main.getCurrentUser()).getCart().getItemsInCart().get(main.getSelectedItem().getItemID())
					.getStock() >= Integer.parseInt(quantity.getText())) {
				((User) main.getCurrentUser()).getCart().getItemsInCart().get(main.getSelectedItem().getItemID())
						.subtractFromStock(Integer.parseInt(quantity.getText()));
				main.getData().getAllItems().get(main.getSelectedItem().getItemID())
						.addToStock(Integer.parseInt(quantity.getText()));
			}

			if (main.getSelectedItem().getStock() == 0) {
				((User) main.getCurrentUser()).getCart().getItemsInCart().remove(main.getSelectedItem().getItemID());
			}

			main.saveData(main.getData());
			updateList();

			total.setText(Double.toString(((User) main.getCurrentUser()).getCart().totalPriceCalculation()));
			subTotal.setText(Double.toString(((User) main.getCurrentUser()).getCart().subTotalPriceCalculation()));
		}
	}

	/**
	 * takes you to the store page.
	 * 
	 * @param event use this to view store.
	 */
	@FXML
	void viewStore(ActionEvent event) {
		main.showStorePage();
		main.setSelectedItem(null);
	}

	/**
	 * updates the list.
	 */
	public void updateList() {
		items = FXCollections.observableArrayList();
		keys = ((User) main.getCurrentUser()).getCart().getItemsInCart().keySet();

		for (Integer i : keys) {
			items.add(((User) main.getCurrentUser()).getCart().getItemsInCart().get(i));
		}

		itemList.setItems(items);
	}
}
