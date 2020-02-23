package controllers;

import java.util.Calendar;
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
import javafx.scene.text.Text;
import javafx.util.Callback;
import model.Admin;
import model.Item;
import model.User;

public class OrderController {
	
	private ObservableList<Item> items;
	
	private Main main;

	public void setMain(Main main) {
		this.main = main;
		
		updateList();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(main.getSelectedOrder().getOrderDate());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONDAY) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		owner.setText(main.getSelectedOrder().getOwner().getUserName());
		date.setText(month + "/" + day + "/" + year);
		total.setText(Double.toString(main.getSelectedOrder().getTotal()));
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
										+ item.getCategory() + "\nPrice: $" + item.getPrice() + " + " + item.calculateTax() + "\nStock: "
										+ item.getStock());
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
    private ListView<Item> itemList;

    @FXML
    private Button backBtn;

    @FXML
    private Text owner;

    @FXML
    private Text date;

    @FXML
    private Text total;
    
    @FXML
    private Text subTotal;

    @FXML
    private Button cancelBtn;

    @FXML
    void cancelOrder(ActionEvent event) {
		main.getSelectedOrder().setOwner(null);
		main.getData().getAllOrders().remove(main.getSelectedOrder());
		main.setSelectedOrder(null);
		main.saveData(main.getData());
		
		if(main.getCurrentUser().getClass() == Admin.class) {
			main.showWareHouseForAdmin();
		} else {
			main.showOrderHistoryPage();
		}
    }

    @FXML
    void goBack(ActionEvent event) {
    	if(main.getCurrentUser().getClass() == Admin.class) {
    		main.showWareHouseForAdmin();
    	} else {
    		main.showOrderHistoryPage();
    	}
    }
    
	public void updateList() {
		items = FXCollections.observableArrayList();

		for (Item i : main.getSelectedOrder().getItemsbought()) {
			items.add(i);
		}

		itemList.setItems(items);
	}

}
