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
import model.Admin;
import model.Order;

/**
 * view order history
 * 
 * @author bahad
 *
 */
public class OrderHistoryController {

	private ObservableList<Order> orders;

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

							setText("Date: " + month + "/" + day + "/" + year + "\nTotal: "
									+ Double.toString(order.getTotal()));
						}
					}
				};

				return newItem;
			}
		});
	}

	@FXML
	private ListView<Order> orderList;

	@FXML
	private Button cancelBtn;

	@FXML
	private Button viewBtn;

	@FXML
	private Button mainMenu;

	/**
	 * cancels the changes
	 * 
	 * @param event use this if you do not want to save changes.
	 */
	@FXML
	void cancelOrder(ActionEvent event) {
		if (main.getSelectedOrder() != null) {
			main.getSelectedOrder().setOwner(null);
			main.getData().getAllOrders().remove(main.getSelectedOrder());
			main.setSelectedOrder(null);
			main.saveData(main.getData());

			if (main.getCurrentUser().getClass() == Admin.class) {
				main.showWareHouseForAdmin();
			} else {
				main.showOrderHistoryPage();
			}
		}
	}

	/**
	 * takes you to selected order.
	 * 
	 * @param event use this to view the selected order.
	 */
	@FXML
	void viewOrder(ActionEvent event) {
		if (main.getSelectedOrder() != null) {
			main.showOrderPage();
		}
	}

	/**
	 * Goes back to the main menu.
	 * 
	 * @param event use to go to the main menu.
	 */
	@FXML
	void mainMenu(ActionEvent event) {
		main.showMainMenuPage();
		main.setSelectedOrder(null);
	}

	/**
	 * updates the list.
	 */
	public void updateList() {
		orders = FXCollections.observableArrayList();

		for (Order order : main.getData().getFilteredOrders(main.getCurrentUser().getUserName())) {
			orders.add(order);
		}
		orderList.setItems(orders);
	}

}
