package model;

public class Item {
	private String productName;
	private int itemID;
	private double price;
	private boolean taxable;
	private int stock;
	
	public Item(String productName,  double price, boolean taxable, int stock, StoreDataBase itemStorage) {
		this.productName = productName;
		this.price = price;
		this.taxable = taxable;
		this.stock = stock;
		
		int max = 0;
		Item[] temp = (Item[]) itemStorage.getAllItems().toArray();
		for (int i = 0; i < temp.length; i++) {
			if (max < temp[i].itemID) {
				max = temp[i].itemID;
			}
		}
		
		this.itemID = max +1;
		
		// itemID of item being created will be +1 of highest itemID in storage
		
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
