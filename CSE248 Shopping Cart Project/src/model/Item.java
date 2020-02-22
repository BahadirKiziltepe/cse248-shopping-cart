package model;

import java.io.Serializable;

public class Item implements Comparable<Item>, Serializable {
	private String productName;
	private int itemID;
	private double price;
	private String category;
	private boolean taxable;
	private int stock;

	/**
	 * Creates an Item
	 * @param productName Name of Item
	 * @param itemID ID number of Item
	 * @param price price of Item
	 * @param category Category of Item
	 * @param taxable If Item is taxable or not
	 * @param stock How many of the item is in stock
	 */
	public Item(String productName, int itemID,  double price, String category, boolean taxable, int stock) {
		this.productName = productName;
		this.price = price;
		this.taxable = taxable;
		this.stock = stock;
		this.category = category;
		this.itemID = itemID;
	}
	
	/**
	 * Increases the stock of an Item in the StoreDataBase
	 * @param amountToAdd amount of an Item being added to the store for purchase
	 */
	public void addToStock(int amountToAdd) {
		stock += amountToAdd;
	}
	
	/**
	 * Calculates the tax for an individual item
	 * @return tax
	 */
	public double calculateTax() {
		double tax = Double.parseDouble(String.format("%.2f", price * 0.0875));
		return tax;
	}
	
	
	// Setters/getters
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isTaxable() {
		return taxable;
	}

	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ID:" + itemID + " Name:" + productName
                + " Category:" + category + " Price:" + price + " Stock:"
                + stock;
	}
	
	@Override
	public int compareTo(Item other) {
		if (this.itemID > other.itemID) {
			return 1;
		}
		if (this.itemID < other.itemID) {
			return -1;
		}
		return 0;
	}

	
}
