package model;

public class CreditCard {
	private int cardNumber;
	private int securityCode;
	private int expirationDate; // MMYY format
	
	public CreditCard(int cardNumber, int securityCode, int expirationDate) {
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
		this.expirationDate = expirationDate;
	}
	
	// setters and getters

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	public int getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(int expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
}
