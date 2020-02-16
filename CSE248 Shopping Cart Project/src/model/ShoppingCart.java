package model;

import java.util.TreeSet;

public class ShoppingCart {
	private TreeSet<Item> itemsInCart;
	
	public ShoppingCart() {
		itemsInCart = new TreeSet<>();
	}

	public void addItemToCart(Item itemToAdd) {
		itemsInCart.add(itemToAdd);
	}
	
	// getters and setters
	
	public TreeSet<Item> getItemsInCart() {
		return itemsInCart;
	}

	public void setItemsInCart(TreeSet<Item> itemsInCart) {
		this.itemsInCart = itemsInCart;
	}
	
	
	
}
