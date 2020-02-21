package model_test;
import org.junit.jupiter.api.Test;

import model.*;


public class TestStoreDataBase {
	
	
	@Test
	public void saveAndLoadTesting() {
		StoreDataBase data = new StoreDataBase();
		// String userName, String password, Name name, Address address, String email
		// String street, String state, String city, String zipCode, String country
		Name nameb = new Name("Brandon","Dabrowski");
		Address addb = new Address("street", "state","city","zipcode","country");
		User user1 = new User("bdubs", "password", nameb, addb, "email@email.com");
		data.registerUser(user1.getUserName(), user1);
		Item item = new Item("Apple",  0.50, "Food", false, 3);
		Item item2 = new Item("Banana",  0.50, "Food", false, 3);
		Item item3 = new Item("Apple",  0.50, "Food", false, 3);
		data.addItemToStore(item);
		data.addItemToStore(item2);
		data.addItemToStore(item3);
		StoreDataBase.writeObjectToFile(data, "StoreData.bin",false);
		
		try {
			StoreDataBase data2 = (StoreDataBase) StoreDataBase.readObjectFromFile("StoreData.bin",false);
			System.out.println(data2.getAllAccounts());
			System.out.println(data2.getAllItems());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
	
	
}
