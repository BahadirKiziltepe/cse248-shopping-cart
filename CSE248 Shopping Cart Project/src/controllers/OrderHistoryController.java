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

public class OrderHistoryController {
	
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
							
							setText("Date: " + month + "/" + day + "/" + year +
									"\nTotal: " + Double.toString(order.getTotal()));
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
    void viewOrder(ActionEvent event) {
    	main.showOrderPage();
    }
    
    @FXML
    void mainMenu(ActionEvent event) {
    	main.showMainMenuPage();
    }
    
    public void updateList() {
    	orders = FXCollections.observableArrayList();
    	
    	for(Order order : main.getData().getFilteredOrders(main.getCurrentUser().getUserName())) {
    		orders.add(order);
    	}
    	orderList.setItems(orders);
	}

}
