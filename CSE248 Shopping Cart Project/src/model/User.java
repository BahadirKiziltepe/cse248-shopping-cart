package model;

import java.util.TreeSet;

public class User extends Account {
	
	private TreeSet<Order> transactionHistory; 
	private CreditCard savedCard; // this doesn't need to be made during the constructor

	public User(String userName, String password, Name name, Address address, String email) {
		super(userName, password, name, address, email);
		transactionHistory = new TreeSet<Order>();
		savedCard.setCardNumber(000000000000);
		savedCard.setExpirationDate(0000);
		savedCard.setSecurityCode(000);
	}

	public void registerUser(User userToAdd, StoreDataBase users) { // used for first time account registery
		users.getAllAccounts().add(userToAdd);
	}
	
	// setters and getters
	
	
	public TreeSet<Order> getTransactionHistory() {
		return transactionHistory;
	}

	public CreditCard getSavedCard() {
		return savedCard;
	}

	public void setSavedCard(CreditCard savedCard) {
		this.savedCard = savedCard;
	}
	
	
	

	
	
	
	
}
