package model;

public class Software extends Item {
	
	private String genre;
	private String publisher;
	
	public Software(String productName, int itemID, double price, boolean taxable, int stock, String genre, String publisher) {
		super(productName, itemID, price, taxable, stock);
		this.genre = genre;
		this.publisher = publisher;
	}

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
