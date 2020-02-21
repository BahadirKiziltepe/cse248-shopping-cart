package model;

<<<<<<< HEAD
import java.util.TreeMap;
import java.util.TreeSet;

public class StoreDataBase {
	private TreeMap<String, Account> allAccounts;
	private TreeSet<Item> allItems;
=======
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
>>>>>>> 477743188668a973078e83f69536df9e177c203c
	private TreeSet<Order> allOrders;

	/**
	 * Holds all user/admin accounts for the store. Also holds all items and copies
	 * of all orders made. Only one instance of this should exist per store.
	 */
	public StoreDataBase() {
		allAccounts = new TreeMap<>();
<<<<<<< HEAD
		allItems = new TreeSet<>();
=======
		allItems = new HashMap<>();
>>>>>>> 477743188668a973078e83f69536df9e177c203c
		allOrders = new TreeSet<>();
		
		Name adminName = new Name("Admin", "Admin");
		Address adminAddress = new Address("a", "b", "c", "123", "d");
		Account admin = new Admin("admin", "111", adminName, adminAddress, "@");
		
		allAccounts.put(admin.getUserName(), admin);
	}

	/**
	 * Adds an item to the store. Returns true if successful, false if unsuccessful
	 * 
	 * @param itemToAdd Item being added to store
	 */
<<<<<<< HEAD
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

=======
	public void addItemToStore(Item itemToAdd) { 
	
		//MAKE ITEM ADDING METHOD
		
>>>>>>> 477743188668a973078e83f69536df9e177c203c
	}

	// Methods that add to the trees

	/**
	 * Adds a copy of an Order to allOrders
	 * 
	 * @param orderToAdd copy of order being made
	 */
	public void addOrderToStore(Order orderToAdd) {
		allOrders.add(orderToAdd);
	}

	/**
	 * Adds the user to allAccounts
	 * 
	 * @param userToAdd user being registered
	 */
<<<<<<< HEAD
	public void registerUser(String username, User userToAdd) {
		allAccounts.put(username, userToAdd);

=======
	public void registerUser(String userName, User userToAdd) { 
		allAccounts.put(userName, userToAdd);
>>>>>>> 477743188668a973078e83f69536df9e177c203c
	}

	/**
	 * Adds the admin to allAccounts
	 * 
	 * @param adminToAdd admin being registered
	 */
<<<<<<< HEAD
	public void registerAdmin(String username, Admin adminToAdd) {
		allAccounts.put(username, adminToAdd);
	}

	// Methods that return information about the trees

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

=======
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
	
>>>>>>> 477743188668a973078e83f69536df9e177c203c
	public TreeMap<String, Account> getAllAccounts() {
		return allAccounts;
	}

	public void setAllAccounts(TreeMap<String, Account> allAccounts) {
		this.allAccounts = allAccounts;
	}

<<<<<<< HEAD
	public TreeSet<Item> getAllItems() {
		return allItems;
	}

	public void setAllItems(TreeSet<Item> allItems) {
=======
	public HashMap<String, Item> getAllItems() {
		return allItems;
	}

	public void setAllItems(HashMap<String, Item> allItems) {
>>>>>>> 477743188668a973078e83f69536df9e177c203c
		this.allItems = allItems;
	}

	public TreeSet<Order> getAllOrders() {
		return allOrders;
	}

	public void setAllOrders(TreeSet<Order> allOrders) {
		this.allOrders = allOrders;
	}
<<<<<<< HEAD

=======
	
	

	

	
	
	
>>>>>>> 477743188668a973078e83f69536df9e177c203c
}
