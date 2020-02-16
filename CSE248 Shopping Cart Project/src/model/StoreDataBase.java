package model;

import java.util.TreeSet;

public class StoreDataBase {
	private TreeSet<Account> allAccounts;
	private TreeSet<Item> allItems;
	private TreeSet<Order> allOrders;
	
	public StoreDataBase() {
		allAccounts = new TreeSet<Account>();
		allItems = new TreeSet<Item>();
		allOrders = new TreeSet<Order>();
	}

	
	public void addItemToStore(Item itemToAdd) { // does NOT check for duplicates yet
		allItems.add(itemToAdd);
	}
	
	// Getters (no setters)
	
	public TreeSet<Account> getAllAccounts() {
		return allAccounts;
	}

	public TreeSet<Item> getAllItems() {
		return allItems;
	}

	public TreeSet<Order> getAllOrders() {
		return allOrders;
	}

	
	
	
}
