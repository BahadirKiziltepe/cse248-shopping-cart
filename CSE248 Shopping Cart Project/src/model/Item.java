package model;

public class Item {
	private String productName;
	private int itemID;
	private double price;
	private boolean taxable;
	private int stock;
	
	/**
	 * Creates an instance of an item (Item is an abstract class, currently)
	 * Upon creation, we check the StoreDataBase to make sure the new Item has a unique ItemID
	 * @param productName Name of Item
	 * @param price Price of Item
	 * @param taxable If the Item can be taxed or not
	 * @param stock How many of the Item is in stock
	 * @param itemStorage The store's database 
	 */
	public Item(String productName,  double price, boolean taxable, int stock, StoreDataBase itemStorage) {
		this.productName = productName;
		this.price = price;
		this.taxable = taxable;
		this.stock = stock;
		
		int max = 0;
		if (itemStorage.getAllItems().size() < 1) {
			Object[] temp = itemStorage.returnItemsAsArray();
			Item[] temp2 = (Item[]) temp;
			for (int i = 0; i < temp2.length; i++) {
				if (max < temp2[i].itemID) {
					max = temp2[i].itemID;
				}
			}
		}
		
		this.itemID = max +1;
		
		// itemID of item being created will be +1 of highest itemID in storage
		
	}
	
	/**
	 * Increases the stock of an Item in the StoreDataBase
	 * @param amountToAdd amount of an Item being added to the store for purchase
	 */
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
