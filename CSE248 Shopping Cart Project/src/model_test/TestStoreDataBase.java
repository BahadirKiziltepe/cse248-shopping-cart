package model_test;
import org.junit.jupiter.api.Test;

import model.*;


public class TestStoreDataBase {
	
	
	@Test
	public void saveAndLoadTesting() {
		StoreDataBase data = new StoreDataBase();
		// String userName, String password, Name name, Address address, String email
		// String street, String state, String city, String zipCode, String country
		// double total, double subTotal, Account owner
		Name nameb = new Name("Brandon","Dabrowski");
		Address addb = new Address("street", "state","city","zipcode","country");
		User user1 = new User("bdubs", "password", nameb, addb, "email@email.com");
		User user2 = new User("franklin", "password", nameb, addb, "email@email.com");
		data.registerUser(user1.getUserName(), user1);
		data.registerUser(user2.getUserName(), user2);
		
		Item item = new Item("Apple",0,  0.50, "Food", false, 3);
		Item item2 = new Item("Banana",1,  0.50, "Food", false, 3);
		Item item3 = new Item("Orange",2,  0.50, "Food", false, 3);
		Item item4 = new Item("Grape",3,0.50,"Food",false,3);
		
		Order order = new Order(60.0,59.99,user1);
		order.addItemToOrder(item);
		order.addItemToOrder(item2);
		
		
		Order order2 = new Order(60.0,59.99,user1);
		order2.addItemToOrder(item3);
		
		Order order3 = new Order(60.0,59.99,user2);
		
		data.addOrderToStore(order);
		data.addOrderToStore(order2);
		data.addOrderToStore(order3);
		
		data.addItemToStore(item);
		data.addItemToStore(item2);
		data.addItemToStore(item3);
		data.addItemToStore(item4);
		
		
		StoreDataBase.writeObjectToFile(data, "StoreData.bin",false);
		
		try {
			StoreDataBase data2 = (StoreDataBase) StoreDataBase.readObjectFromFile("StoreData.bin",false);
			System.out.println(data2.getAllAccounts());
			System.out.println(data2.getAllItems());
			System.out.println(data2.getAllOrders());
			
			System.out.println(data2.getFilteredOrders("franklin"));
			
			
			
			Object[] items =  data2.getAllItems().values().toArray();
			for (int i = 0; i < items.length; i++) {
				System.out.println( items[i].toString());
			}
			
			Object[] orders =  data2.getAllOrders().toArray();
			for (int i = 0; i < orders.length; i++) {
				System.out.println(orders[i].toString());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
	
	
}
