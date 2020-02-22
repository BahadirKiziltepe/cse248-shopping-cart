package model;

import java.io.Serializable;
import java.util.TreeSet;

public class ShoppingCart implements Serializable{
	private TreeSet<Item> itemsInCart;
	
	/**
	 * Holds all items that are being considered for purchase
	 */
	public ShoppingCart() {
		itemsInCart = new TreeSet<>();
	}

	/**
	 * Adds an Item to the shopping cart
	 * @param itemToAdd Item being added to the shopping cart
	 */
	public void addItemToCart(Item itemToAdd) {
		itemsInCart.add(itemToAdd);
	}
	
	/**
	 * Removes item from the shopping cart
	 * @param item Item being removed from the cart
	 */
	public void removeItemFromCart(Item item) {
		itemsInCart.remove(item);
	}
	
	/**
	 * Returns all items from the cart as an Object[] array.
	 * @return returns items as Array of Objects
	 */
	public Object[] returnAsArray() {
		return itemsInCart.toArray();
	}
	
	/**
	 * Empties the cart of items
	 */
	public void emptyCart() {
		itemsInCart.clear();
	}
	
	// getters and setters
	
	public TreeSet<Item> getItemsInCart() {
		return itemsInCart;
	}

	public void setItemsInCart(TreeSet<Item> itemsInCart) {
		this.itemsInCart = itemsInCart;
	}
	
	
	
}
