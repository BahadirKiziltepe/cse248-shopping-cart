package model;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class StoreDataBase {
	private TreeMap<String, Account> allAccounts;
	private HashMap<String, Item> allItems;
	private TreeSet<Order> allOrders;
	
	/**
	 * Holds all user/admin accounts for the store. Also holds all items and copies of all orders made.
	 * Only one instance of this should exist per store.
	 */
	public StoreDataBase() {
		allAccounts = new TreeMap<>();
		allItems = new HashMap<>();
		allOrders = new TreeSet<>();
	}

	/**
	 * Adds an item to the store. Returns true if successful, false if unsuccessful
	 * @param itemToAdd Item being added to store
	 */
	public void addItemToStore(Item itemToAdd) { 
	
		//MAKE ITEM ADDING METHOD
		
	}
	
	//Methods that add to the trees
	
	/**
	 * Adds a copy of an Order to allOrders
	 * @param orderToAdd copy of order being made
	 */
	public void addOrderToStore(Order orderToAdd) {
		allOrders.add(orderToAdd);
	}
	
	
	/**
	 *  Adds the user to allAccounts
	 * @param userToAdd user being registered
	 */
	public void registerUser(String userName, User userToAdd) { 
		allAccounts.put(userName, userToAdd);
	}
	
	/**
	 * Adds the admin to allAccounts
	 * @param adminToAdd admin being registered
	 */
	public void registerAdmin(String adminName, Admin adminToAdd) {
		allAccounts.put(adminName, adminToAdd);
	}

	
	
	// Getters and setters
	
	public TreeMap<String, Account> getAllAccounts() {
		return allAccounts;
	}

	public void setAllAccounts(TreeMap<String, Account> allAccounts) {
		this.allAccounts = allAccounts;
	}

	public HashMap<String, Item> getAllItems() {
		return allItems;
	}

	public void setAllItems(HashMap<String, Item> allItems) {
		this.allItems = allItems;
	}

	public TreeSet<Order> getAllOrders() {
		return allOrders;
	}

	public void setAllOrders(TreeSet<Order> allOrders) {
		this.allOrders = allOrders;
	}
	
	

	

	
	
	
}
