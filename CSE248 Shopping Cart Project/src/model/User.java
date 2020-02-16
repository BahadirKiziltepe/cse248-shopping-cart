package model;

import java.util.TreeSet;

public class User extends Account {
	
	private TreeSet<Order> transactionHistory;
	private CreditCard creditCard;

	public User(String userName, String password, Name name, Address address) {
		super(userName, password, name, address);
		
	}
	
	
	
	
}
