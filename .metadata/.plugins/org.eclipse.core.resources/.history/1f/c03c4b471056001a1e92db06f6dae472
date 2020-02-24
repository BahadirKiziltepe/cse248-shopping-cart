package model;

import java.io.Serializable;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This holds items that a user wants to buy
 * @author bdabr
 *
 */
public class ShoppingCart implements Serializable{
	private TreeMap<Integer,Item> itemsInCart;
	
	/**
	 * Holds all items that are being considered for purchase
	 */
	public ShoppingCart() {
		itemsInCart = new TreeMap<>();
	}

	/**
	 * Adds an Item to the shopping cart
	 * @param itemToAdd Item being added to the shopping cart
	 * @param quantity amount being added
	 */
	public void addItemToCart(Item itemToAdd, int quantity) {
		if (itemsInCart.containsKey(itemToAdd.getItemID())) {
			itemsInCart.get(itemToAdd.getItemID()).addToStock(quantity);
		} else {
			itemsInCart.put(itemToAdd.getItemID(), itemToAdd);
		}
		
	}
	
	/**
	 * Removes item from the shopping cart
	 * @param item Item being removed from the cart
	 */
	public void removeItemFromCart(Item item) {
		itemsInCart.remove(item.getItemID());
	}
	
	/**
	 * Finds total amount of money spent after tax
	 * @return price with tax included
	 */
	public double totalPriceCalculation() {
		Object[] items =  itemsInCart.values().toArray();
		double totalPrice = 0;
		for (int i = 0; i < items.length; i++) {
			if (((Item) items[i]).isTaxable() == true) {
				totalPrice += ((Item) items[i]).calculateTax();
			}
			totalPrice += ((Item) items[i]).getPrice();
		}
		return  Double.parseDouble(String.format("%.2f", totalPrice));
	}
	
	/**
	 * Finds total amount of money spent before tax
	 * @return price without taxes
	 */
	public double subTotalPriceCalculation() {
		Object[] items =  itemsInCart.values().toArray();
		double subTotalPrice = 0;
		for (int i = 0; i < items.length; i++) {
			subTotalPrice += ((Item) items[i]).getPrice();
		}
		return  Double.parseDouble(String.format("%.2f", subTotalPrice));
	}
	

	
	
	/**
	 * Returns all items from the cart as an Object[] array.
	 * @return returns items as Array of Objects
	 */
	public Object[] returnAsArray() {
		return itemsInCart.values().toArray();
	}
	
	/**
	 * Empties the cart of items
	 */
	public void emptyCart() {
		itemsInCart.clear();
	}

	
	// getters and setters
	
	public TreeMap<Integer, Item> getItemsInCart() {
		return itemsInCart;
	}

	public void setItemsInCart(TreeMap<Integer, Item> itemsInCart) {
		this.itemsInCart = itemsInCart;
	}
	
	
	
}
