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
						if(item != null) {
							setText(item.getProductName());
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
	void SearchItems(ActionEvent event) {

	}
}
