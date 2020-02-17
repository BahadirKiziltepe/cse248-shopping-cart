package model;

import java.util.TreeSet;

public class User extends Account implements Comparable<Account> {
	
	private TreeSet<Order> transactionHistory; 
	private CreditCard savedCard; // this doesn't need to be made during the constructor

	public User(String userName, String password, Name name, Address address, String email) {
		super(userName, password, name, address, email);
		transactionHistory = new TreeSet<Order>();
		savedCard = new CreditCard("0000 0000 0000", 000, 0000);
	}

	// user registeration method moved to the StoreDataBase class
	
	// setters and getters
	
	
	public TreeSet<Order> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(TreeSet<Order> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	public CreditCard getSavedCard() {
		return savedCard;
	}

	public void setSavedCard(CreditCard savedCard) {
		this.savedCard = savedCard;
	}

	


	
	
	
	

	
	
	
	
}
