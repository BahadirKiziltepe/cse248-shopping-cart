package model;

import java.util.Date;

public class Food extends Item {
	
	 
	private Date experationDate;
	
	/**
	 * Creates a Food object, a subclass of the Item class
	 * @param productName Name of Food
	 * @param price Price of food
	 * @param taxable If taxable or not
	 * @param stock Amount of Food in stock
	 * @param itemStorage StoreDataBase used for storing Items for sale
	 * @param experationDate Date the food expires
	 */
	public Food(String productName,  double price, boolean taxable, int stock, StoreDataBase itemStorage, Date experationDate) {
		super(productName, price, taxable, stock, itemStorage);
		this.experationDate = experationDate;
	}

	// getters/setters
	
	public Date getExperationDate() {
		return experationDate;
	}

	public void setExperationDate(Date experationDate) {
		this.experationDate = experationDate;
	}
	
	

}
