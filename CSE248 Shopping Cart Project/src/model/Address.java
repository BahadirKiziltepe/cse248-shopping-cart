package model;

import java.io.Serializable;

/**
 * Used to hold home address for all Accounts
 * @author bdabr
 *
 */
public class Address implements Serializable {

	private String street;
	private String state;
	private String city;
	private String zipCode;
	private String country;
	
	/**
	 * Address for where the account in question lives
	 * @param street Street they live on
	 * @param state State they live in
	 * @param city City/Town they live in
	 * @param zipCode Their ZipCode
	 * @param country Country they live in
	 */
	public Address(String street, String state, String city, String zipCode, String country) {
		this.street = street;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
		
	}
	
	// setters and getters
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
