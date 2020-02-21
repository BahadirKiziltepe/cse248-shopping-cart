package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class StoreDataBase implements Serializable {
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

	//Saving and Loading
	
	public static Object readObjectFromFile(String filePath, boolean displayDebug) throws ClassNotFoundException {
		try {
				FileInputStream fileIn = new FileInputStream(filePath);
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);
				
				Object obj = objectIn.readObject();
				
				if (displayDebug == true) {
					System.out.printf("%s loaded\n", filePath);
				}
				objectIn.close();
				return obj;
				
		} catch (IOException e) {
			if (displayDebug == true) {
				System.out.printf("could not load %s\n", filePath);
			}
			return null;
		}	
	}
	
	public static void writeObjectToFile(Object object, String fileName, boolean displayDebug) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(object);
			objectOut.close();
			if (displayDebug == true) {
				System.out.printf("saved %s\n",fileName);
			}
		} catch (IOException e) {
			if (displayDebug == true) {
				System.out.printf("could not save %s\n", fileName);
			}
		}
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
