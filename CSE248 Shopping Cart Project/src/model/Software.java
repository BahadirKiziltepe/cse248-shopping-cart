package model;

public class Software extends Item {
	
	private String genre;
	private String publisher;
	
	/**
	 * Creates a Software Instance. Is a subclass of Item.
	 * @param productName Name of software
	 * @param price price of software
	 * @param taxable if the software is taxable or not
	 * @param stock How many of this software is in stock
	 * @param itemStorage StoreDataBase that holds all store information, used for item management in this case
	 * @param genre Genre of software (productivity, action, stealth, etc)
	 * @param publisher Publisher of the software
	 */
	public Software(String productName, double price, boolean taxable, int stock, StoreDataBase itemStorage, String genre, String publisher) {
		super(productName, price, taxable, stock, itemStorage);
		this.genre = genre;
		this.publisher = publisher;
	}

	// setters and getters
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	

}
