package model;

import java.util.TreeSet;

public class User extends Account {
	
	private TreeSet<Order> transactionHistory;

	public User(String userName, String password, Name name, Address address) {
		super(userName, password, name, address);
		
	}
	
	
	
	
}
