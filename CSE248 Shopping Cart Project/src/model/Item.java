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
	
}
