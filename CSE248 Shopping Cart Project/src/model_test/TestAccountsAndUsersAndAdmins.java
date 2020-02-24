package model_test;

import model.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestAccountsAndUsersAndAdmins {

	
	@Test
	public void testAccountCreationAndVariables() {
		StoreDataBase data = new StoreDataBase();
		
		Name nameb = new Name("brandon", "dabrowksi","dante");
		Name namea = new Name("John","Apple","Seed");
		
		Address addb = new Address("9 apple", "new york", "town", "78912", "USA");
		Address adda = new Address("7 Oak Road","Florida","Saplin","78451","USA");
		
		User brandon = new User("bdoubled","password",nameb,addb,"email.com");
		User brandon2 = new User("bdubs","password",nameb,addb,"email.com");
		Admin john = new Admin("appleMan","adminpassword",namea,adda,"apple.com");
		Admin john2 = new Admin("appleManYEEEEEEEEEEEEEEEEEEE","adminpassword",namea,adda,"apple.com");
		
		CreditCard cc = new CreditCard("1234 1234 1234", 123, 1202);
		
		
		data.registerAdmin(john.getUserName(), john);
		data.registerAdmin(john2.getUserName(), john2);
		data.registerUser(brandon.getUserName(), brandon);
		data.registerUser(brandon2.getUserName(), brandon2);
		
		brandon.setSavedCard(cc);
		
		assertEquals(4,data.getAllAccounts().size());
		assertEquals("bdoubled",brandon.getUserName());
		assertEquals("password",brandon.getPassword());
		assertEquals("email.com",brandon.getEmail());
		assertEquals(nameb,brandon.getName());
		assertEquals(addb,brandon.getAddress());
		assertEquals(cc,brandon.getSavedCard());
		
		System.out.println(data.getAllAccounts());
	}
}
