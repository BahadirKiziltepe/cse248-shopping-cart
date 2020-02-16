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

	
	public void addItemToStore(Item itemToAdd) { 
		boolean canAdd = true;
		Item[] temp = (Item[]) allItems.toArray();
		
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].getItemID() == itemToAdd.getItemID()) { // if item with same ID exists, item is not added
				canAdd = false;
			}
		}
		
		if (canAdd == true) {
			allItems.add(itemToAdd);
		} 
		
	}
	
	public void addOrderToStore(Order orderToAdd) {
		allOrders.add(orderToAdd);
	}
	
	
	// QUESTION: does it matter if this tree holds the subclasses of Account??
	public void addAccountToStore(Account accountToAdd) { 
		allAccounts.add(accountToAdd);
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
