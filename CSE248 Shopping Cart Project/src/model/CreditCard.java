package model;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Holds credit card infortmation for any Users
 * @author Brandon Dabrowski
 *
 */
public class CreditCard implements Serializable {
	private String cardNumber;
	private int securityCode;
	private int expirationDate; // MMYY format
	
	/**
	 * A credit card used by the User class for purchasing items
	 * @param cardNumber Credit Card's main number
	 * @param securityCode Credit card's security code
	 * @param expirationDate Credit Card's Experation date
	 */
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
