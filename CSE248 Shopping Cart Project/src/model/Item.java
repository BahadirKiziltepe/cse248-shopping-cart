package model;

public class Item {
	private String productName;
	private int itemID;
	private double price;
	private boolean taxable;
	private int stock;
	
	public Item(String productName, int itemID, double price, boolean taxable, int stock) {
		this.productName = productName;
		this.itemID = itemID;
		this.price = price;
		this.taxable = taxable;
		this.stock = stock;
	}

	public void addToStock(int amountToAdd) {
		stock += amountToAdd;
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
	
	
	
}
