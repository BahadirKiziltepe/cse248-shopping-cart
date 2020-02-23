package model;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * A subclass of Account that can log onto the store and purchase items
 * @author bdabr
 *
 */
public class User extends Account implements Comparable<Account>, Serializable {
	private static final long serialVersionUID = 4179981295807154516L;
	
	private CreditCard savedCard; // this doesn't need to be made during the constructor
	private ShoppingCart cart;

	/**
	 * Creates a User account (the most common type of account). This is a subclass of the Account class.
	 * @param userName User's username
	 * @param password User's password
	 * @param name User's name
	 * @param address User's home address
	 * @param email User's email address
	 */
	public User(String userName, String password, Name name, Address address, String email) {
		super(userName, password, name, address, email);
		savedCard = new CreditCard("000000000000", 000, 0000);
		cart = new ShoppingCart();
	}

	// user registeration method moved to the StoreDataBase class **
	
	
	
	// setters and getters

	public CreditCard getSavedCard() {
		return savedCard;
	}

	public void setSavedCard(CreditCard savedCard) {
		this.savedCard = savedCard;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	
}
