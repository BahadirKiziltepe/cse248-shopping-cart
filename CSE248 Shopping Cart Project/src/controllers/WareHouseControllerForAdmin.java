package controllers;

import java.util.Calendar;

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
import javafx.util.Callback;
import model.Item;
import model.Order;
import model.User;

public class WareHouseControllerForAdmin {

	private ObservableList<Order> orders;

	private Main main;

	public void setMain(Main main) {
		this.main = main;

		updateList();
	}

	public void initialize() {
		orderList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Order>() {

			@Override
			public void changed(ObservableValue<? extends Order> observable, Order oldOrder, Order newOrder) {
				main.setSelectedOrder(newOrder);
			}
		});

		orderList.setCellFactory(new Callback<ListView<Order>, ListCell<Order>>() {

			@Override
			public ListCell<Order> call(ListView<Order> p) {
				ListCell<Order> newItem = new ListCell<Order>() {
					@Override
					protected void updateItem(Order order, boolean bool) {
						super.updateItem(order, bool);
						if (bool || order == null) {
							setText(null);
						} else {
							Calendar cal = Calendar.getInstance();
							cal.setTime(order.getOrderDate());
							int year = cal.get(Calendar.YEAR);
							int month = cal.get(Calendar.MONDAY) + 1;
							int day = cal.get(Calendar.DAY_OF_MONTH);

							setText("User: " + order.getOwner().getUserName() + "\nDate: " + month + "/" + day + "/"
									+ year + "\nTotal: " + Double.toString(order.getTotal()));
						}
					}
				};

				return newItem;
			}
		});
	}

	@FXML
	private Button cancelBtn;

	@FXML
	private ListView<Order> orderList;

	@FXML
	private Button viewBtn;

	@FXML
	private Button mainMenu;

	@FXML
	void cancelOrder(ActionEvent event) {
		main.getSelectedOrder().setOwner(null);
		main.getData().getAllOrders().remove(main.getSelectedOrder());
		main.setSelectedOrder(null);
		
		updateList();
		main.saveData(main.getData());
	}

	@FXML
	void viewOrder(ActionEvent event) {
		if (main.getSelectedOrder() != null) {
			main.showOrderPage();
		}
	}

	@FXML
	void mainMenu(ActionEvent event) {
		main.showAdminPage();
	}

	public void updateList() {
		orders = FXCollections.observableArrayList();

		for (Order order : main.getData().getAllOrders()) {
			orders.add(order);
		}
		orderList.setItems(orders);
	}

}
