package model;

import java.math.BigInteger;

public class CreditCard {
	private String cardNumber;
	private int securityCode;
	private int expirationDate; // MMYY format
	
	public CreditCard(String cardNumber, int securityCode, int expirationDate) {
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
		this.expirationDate = expirationDate;
	}
	
	// setters and getters

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
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
