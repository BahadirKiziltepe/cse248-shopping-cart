package model;

import java.util.TreeSet;

public class StoreDataBase {
	private TreeSet<Account> allAccounts;
	private TreeSet<Item> allItems;
	private TreeSet<Order> allOrders;
	
	
	public StoreDataBase() {
		
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
	
	
	// QUESTION: does it matter if this tree holds the subclasses of Account?? yes it does... 
	// 	for now we'll use 2 tree sets (one for users and one for admin) and see from there
	// if we can use Generics properly to fix it all into one single TreeSet
	
	public void registerUser(User userToAdd) { 
		allAccounts.add(userToAdd);
	}
	public void registerAdmin(Admin adminToAdd) {
		allAccounts.add(adminToAdd);
	}
	
	// Getters and setters
	
	public TreeSet<Account> getAllAccounts() {
		return allAccounts;
	}


	public void setAllAccounts(TreeSet<Account> allAccounts) {
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
