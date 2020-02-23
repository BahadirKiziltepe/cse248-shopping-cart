package model_test;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import model.*;


public class TestStoreDataBaseExtensive {
	
	@Test
	public void extensiveStorageTest() {
		StoreDataBase data = new StoreDataBase();
		Name name = new Name("First", "last");
		Address add = new Address("Street", "New York", "Smithtown", "ZipCode", "USA");
		for (int i = 0; i < 1000; i++) {
			User user = new User(Integer.toString(i), Integer.toString(i), name, add, Integer.toBinaryString(i)+"@email.com");
			Item item = new Item(Integer.toString(i), i, 30.0, "Generic", true, 2);
			data.registerUser(user.getUserName(), user);
			data.addItemToStore(item);
		}
		
		StoreDataBase.writeObjectToFile(data, "data_test\\StoreData.bin", true);
		StoreDataBase data2 = new StoreDataBase();
		
		try {
			data2 = (StoreDataBase) StoreDataBase.readObjectFromFile("data_test\\StoreData.bin", true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(data2.getAllAccounts());
		assertEquals(1000,data2.getAllAccounts().size());
		
	}
}
