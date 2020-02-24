package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * holds all User/Item/Order data for the entire store
 * @author bdabr
 *
 */
public class StoreDataBase implements Serializable {
	 private static final long serialVersionUID = 7245546982264124437L;
	
	private TreeMap<String, Account> allAccounts;
	private HashMap<Integer, Item> allItems;
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
	 * Adds an item to the store
	 * @param itemToAdd Item being added to store
	 */
	public void addItemToStore(Item itemToAdd) { // This doesn't allow Items of the same name to exist due to the key being the product name
		
		 if(allItems.containsKey(itemToAdd.getItemID())) {
	            allItems.get(itemToAdd.getItemID()).setStock(allItems.get(itemToAdd.getItemID()).getStock()+itemToAdd.getStock());
	        } else {
	            allItems.put(itemToAdd.getItemID(), itemToAdd);
	        }
		
		/* Auto Incrementation
		if (allItems.isEmpty() == false) {
			Set setOfKeys = allItems.keySet();
			Iterator it = setOfKeys.iterator();
			int idValue = itemToAdd.getItemID();
			while (it.hasNext()) {
				String key = (String) it.next();
				if (idValue < allItems.get(key).getItemID()) {
					idValue = allItems.get(key).getItemID();
				}
			}
			idValue++;
			itemToAdd.setItemID(idValue);
			allItems.put(itemToAdd.getProductName(), itemToAdd);
		} else {
			itemToAdd.setItemID(0);
			allItems.put(itemToAdd.getProductName(), itemToAdd);
		}
		*/
	}
	
	public void removeItemFromStore(Item item) {
		allItems.remove(item.getItemID());
	}

	
	/**
	 * Adds a copy of an Order to allOrders
	 * @param orderToAdd copy of order being made
	 */
	public void addOrderToStore(Order orderToAdd) {
		Iterator it = allOrders.iterator();
		int idValue = orderToAdd.getOrderID();
		if (allOrders.isEmpty() == false) {
			while (it.hasNext()) {
				Order temp = (Order) it.next();
				int key = temp.getOrderID();
				if (idValue < key) {
					idValue = key;
				}
			}
			idValue++;
			orderToAdd.setOrderID(idValue);
			allOrders.add(orderToAdd);
		} else {
			orderToAdd.setOrderID(0);
			allOrders.add(orderToAdd);
		}
		
	}
	
	
	/**
	 *  Adds the user to allAccounts
	 * @param userName userName of user being added
	 * @param userToAdd user being registered
	 */
	public void registerUser(String userName, User userToAdd) { 
		allAccounts.put(userName, userToAdd);
	}
	
	/**
	 * Adds the admin to allAccounts
	 * @param adminName userName for Admin being added
	 * @param adminToAdd admin being registered
	 */
	public void registerAdmin(String adminName, Admin adminToAdd) {
		allAccounts.put(adminName, adminToAdd);
	}

	//Saving and Loading
	
	/**
	 * Loads the StoreDataBase instance from a .bin file
	 * @param filePath Where the file is located
	 * @param displayDebug If we'll print debug messages to the console or not
	 * @return Save data if exists
	 * @throws ClassNotFoundException Handles data reading failures
	 */
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
	
	/**
	 * Saves the StoreDataBase instance as an Object in a .bin file
	 * @param object The StoreDataBase instance being saved
	 * @param fileName The name of the .bin file the data is being saved to
	 * @param displayDebug If we'll print debug info to the console or not
	 */
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

	public HashMap<Integer, Item> getAllItems() {
		return allItems;
	}

	public void setAllItems(HashMap<Integer, Item> allItems) {
		this.allItems = allItems;
	}

	public TreeSet<Order> getAllOrders() {
		return allOrders;
	}

	public void setAllOrders(TreeSet<Order> allOrders) {
		this.allOrders = allOrders;
	}
	
	/**
	 * gets a filtered TreeSet based on the userName string
	 * @param userName UserName to sort orders by
	 * @return filteredOrders
	 */
	public TreeSet<Order> getFilteredOrders(String userName){
		Iterator it = allOrders.iterator();
		TreeSet<Order> filteredOrders = new TreeSet<>();
		
		while (it.hasNext()) {
			Order temp = (Order) it.next();
			String key = temp.getOwner().getUserName();
			if (userName.equals(key)) {
				filteredOrders.add(temp);
			}
		}
		return filteredOrders;	
	}
	

	

	
	
	
}