package model;

public class Software extends Item {
	
	private String genre;
	private String publisher;
	
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
