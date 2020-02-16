package model;

import java.util.Date;

public class Food extends Item {
	
	 
	private Date experationDate;
	
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
