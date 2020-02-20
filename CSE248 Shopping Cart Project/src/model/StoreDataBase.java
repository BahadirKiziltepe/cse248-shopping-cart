package model;

import java.util.TreeMap;
import java.util.TreeSet;

public class StoreDataBase {
	private TreeMap<String, Account> allAccounts;
	private TreeSet<Item> allItems;
	private TreeSet<Order> allOrders;
	
	/**
	 * Holds all user/admin accounts for the store. Also holds all items and copies of all orders made.
	 * Only one instance of this should exist per store.
	 */
	public StoreDataBase() {
		allAccounts = new TreeMap<>();
		allItems = new TreeSet<>();
		allOrders = new TreeSet<>();
	}

	/**
	 * Adds an item to the store. Returns true if successful, false if unsuccessful
	 * @param itemToAdd Item being added to store
	 */
	public boolean addItemToStore(Item itemToAdd) { 
		boolean canAdd = true;
		Item[] temp = (Item[]) allItems.toArray();
		
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].getItemID() == itemToAdd.getItemID()) { // if item with same ID exists, item is not added
				canAdd = false;
				return false;
			}
		}
		
		if (canAdd == true) {
			allItems.add(itemToAdd);
			return true;
		} 
		return false;
		
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
	public void registerUser(String username, User userToAdd) { 
		allAccounts.put(username, userToAdd);
	}
	
	/**
	 * Adds the admin to allAccounts
	 * @param adminToAdd admin being registered
	 */
	public void registerAdmin(String username, Admin adminToAdd) {
		allAccounts.put(username, adminToAdd);
	}
	
	//Methods that return information about the trees
	
	/**
	 * @return Returns allItems TreeSet as an Object[] array
	 */
	public Object[] returnItemsAsArray() {
		return allItems.toArray();
	}
	
	/**
	 * @return Returns allOrders TreeSet as an Object[] array
	 */
	public Object[] returnOrdersAsArray() {
		return allOrders.toArray();
	}
	
	// Getters and setters
	
	public TreeMap<String, Account> getAllAccounts() {
		return allAccounts;
	}


	public void setAllAccounts(TreeMap<String, Account> allAccounts) {
		this.allAccounts = allAccounts;
	}


	public TreeSet<Item> getAllItems() {
		return allItems;
	}


	public void setAllItems(TreeSet<Item> allItems) {
		this.allItems = allItems;
	}


	public TreeSet<Order> getAllOrders() {
		return allOrders;
	}


	public void setAllOrders(TreeSet<Order> allOrders) {
		this.allOrders = allOrders;
	}
	
	
	
}
