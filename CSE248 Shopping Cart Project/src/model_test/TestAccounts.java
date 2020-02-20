package model_test;

import model.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestAccounts {

	
	@Test
	public void testAccountCreation() {
		StoreDataBase data = new StoreDataBase();
		
		Name nameb = new Name("brandon", "dabrowksi","dante");
		Name namea = new Name("John","Apple","Seed");
		
		Address addb = new Address("9 norton drive", "new york", "smithtown", "11787", "USA");
		Address adda = new Address("7 Oak Road","Florida","Saplin","78451","USA");
		
		User brandon = new User("bdoubled","password",nameb,addb,"email.com");
		User brandon2 = new User("bdubs","password",nameb,addb,"email.com");
		Admin john = new Admin("appleMan","adminpassword",namea,adda,"apple.com");
		
		data.registerAdmin(john);
		data.registerUser(brandon);
		data.registerUser(brandon2);
		
		assertEquals(3,data.getAllAccounts().size());
		
		
	}
}
