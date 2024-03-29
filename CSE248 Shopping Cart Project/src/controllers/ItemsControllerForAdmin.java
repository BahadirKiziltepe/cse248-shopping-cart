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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import model.Item;

/**
 * Allows you to remove/add/order items
 * 
 * @author bahad
 *
 */
public class ItemsControllerForAdmin {

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
								setText("ID: " + item.getItemID() + "\nName: " + item.getProductName() + "\nCategory: "
										+ item.getCategory() + "\nPrice: $" + item.getPrice() + " + "
										+ item.calculateTax() + "\nStock: " + item.getStock());
							} else {
								setText("ID: " + item.getItemID() + "\nName: " + item.getProductName() + "\nCategory: "
										+ item.getCategory() + "\nPrice: $" + item.getPrice() + "\nStock: "
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
	private TextField searchBar;

	@FXML
	private Button searchBtn;

	@FXML
	private Button addBtn;

	@FXML
	private Button deleteBtn;

	@FXML
	private Button orderBtn;

	@FXML
	private Button clearBtn;

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

	/**
	 * adds item to the store, if existing item, increases the stock.
	 * 
	 * @param event use this to add an item to the store or increase its stock.
	 */
	@FXML
	void addItem(ActionEvent event) {
		if (!(itemID.getText().equals("") && itemCount.getText().equals("")) && (itemName.getText().equals("")
				|| itemCategory.getText().equals("") || itemPrice.getText().equals(""))) {
			orderItem(event);
		} else if (!(itemID.getText().equals("") || itemName.getText().equals("") || itemCategory.getText().equals("")
				|| itemPrice.getText().equals("") || itemCount.getText().equals(""))) {
			if (main.checkIfInteger(itemID.getText()) && main.checkIfInteger(itemCount.getText())
					&& main.checkIfDouble(itemPrice.getText())) {
				Item newItem = new Item(itemName.getText(), Integer.parseInt(itemID.getText()),
						Double.parseDouble(itemPrice.getText()), itemCategory.getText(), checkIfTaxable.isSelected(),
						Integer.parseInt(itemCount.getText()));
				main.getData().addItemToStore(newItem);
				updateList();

				main.saveData(main.getData());
			}
		}
	}

	/**
	 * deletes item from store.
	 * 
	 * @param event use this to delete an item.
	 */
	@FXML
	void deleteItem(ActionEvent event) {
		if (main.getSelectedItem() != null) {
			main.getData().getAllItems().remove(main.getSelectedItem().getItemID());
			main.saveData(main.getData());

			updateList();
			main.setSelectedItem(null);
		}
	}

	/**
	 * orders an existing item.
	 * 
	 * @param event use this to order an item.
	 */
	@FXML
	void orderItem(ActionEvent event) {
		if (!main.checkIfInteger(itemCount.getText())) {
			itemCount.setText("1");
		}
		if (main.checkIfInteger(itemID.getText())) {
			if (main.getData().getAllItems().containsKey(Integer.parseInt(itemID.getText()))) {
				main.getData().getAllItems().get(Integer.parseInt(itemID.getText()))
						.addToStock(Integer.parseInt(itemCount.getText()));
				main.saveData(main.getData());

				updateList();
			}
		}
	}

	/**
	 * fills the fields automatically based on the selected item.
	 * 
	 * @param event use this to fill the fields automatically.
	 */
	@FXML
	void updateInfo(MouseEvent event) {
		if (main.getSelectedItem() != null) {
			itemID.setText(Integer.toString(main.getSelectedItem().getItemID()));
			itemName.setText(main.getSelectedItem().getProductName());
			itemCategory.setText(main.getSelectedItem().getCategory());
			itemPrice.setText(Double.toString(main.getSelectedItem().getPrice()));
		}
	}

	/**
	 * clears the fields.
	 * 
	 * @param event use this to clear the fields.
	 */
	@FXML
	void Clear(ActionEvent event) {
		itemID.setText("");
		itemName.setText("");
		itemCategory.setText("");
		itemPrice.setText("");
		itemCount.setText("");
		checkIfTaxable.setSelected(false);
	}

	/**
	 * Goes back to the main menu.
	 * 
	 * @param event use to go to the main menu.
	 */
	@FXML
	void goToMainMenu(ActionEvent event) {
		main.showAdminPage();
		main.setSelectedItem(null);
	}

	/**
	 * searches through the list based on the given search key.
	 * 
	 * @param event use this to search an item in the store.
	 */
	@FXML
	void search(ActionEvent event) {
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
