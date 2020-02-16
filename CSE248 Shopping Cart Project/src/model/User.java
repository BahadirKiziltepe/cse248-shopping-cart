package model;

import java.util.TreeSet;

public class User extends Account {
	
	private TreeSet<Order> transactionHistory; 
	private CreditCard creditCard; // this doesn't need to be made during the constructor

	public User(String userName, String password, Name name, Address address) {
		super(userName, password, name, address);
		transactionHistory = new TreeSet<Order>();
		creditCard.setCardNumber(000000000000);
		creditCard.setExpirationDate(0000);
		creditCard.setSecurityCode(000);
	}
	
	
	
	
}
