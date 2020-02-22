package model;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * This holds items that a user wants to buy
 * @author bdabr
 *
 */
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
	 * Finds total amount of money spent after tax
	 * @return price with tax included
	 */
	public double totalPriceCalculation() {
		Object[] items =  itemsInCart.toArray();
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
