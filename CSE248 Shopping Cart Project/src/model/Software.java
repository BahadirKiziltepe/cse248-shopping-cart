package model;

public class Software extends Item {
	
	private String genre;
	private String publisher;
	
	public Software(String productName, int itemID, double price, boolean taxable, int stock, String genre, String publisher) {
		super(productName, itemID, price, taxable, stock);
		this.genre = genre;
		this.publisher = publisher;
	}

}
