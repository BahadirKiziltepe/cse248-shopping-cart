package model_test;

import java.util.TreeSet;

import model.*;

public class TestMain {

	public static void main(String[] args) {
		StoreDataBase data = new StoreDataBase();
		
		// String userName, String password, Name name, Address address, String email
		Name nameb = new Name("brandon", "dabrowksi","dante");
		Name namea = new Name("John","Apple","Seed");
		// String street, String state, String city, String zipCode, String country
		Address addb = new Address("9 norton drive", "new york", "smithtown", "11787", "USA");
		Address adda = new Address("7 Oak Road","Florida","Saplin","78451","USA");
		
		// String userName, String password, Name name, Address address, String email
		User brandon = new User("bdoubled","password",nameb,addb,"email.com");
		User brandon2 = new User("bdoubled","password",nameb,addb,"email.com");
		Admin john = new Admin("appleMan","adminpassword",namea,adda,"apple.com");
		
		TreeSet<Account> tree = new TreeSet<>();
		tree.add(john);
		tree.add(brandon);
		tree.add(brandon2); // doesn't get added if account username is the same
		System.out.println(tree);
		
		
		///// REGISTERING USERS/ADMINS  && CALLING THEIR INFO /////
		data.registerUser(brandon);
		data.registerAdmin(john);
	
		
		Object[] acc  =  data.returnAccountsAsArray();
		for (int i = 0; i < acc.length; i++) {
			System.out.println(((Account) acc[i]).getName().getFirstName());
		}
		///////////////////////////////////////////////////////////
	
		
	}

}
