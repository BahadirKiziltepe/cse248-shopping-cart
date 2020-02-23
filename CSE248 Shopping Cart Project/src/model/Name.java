package model;

import java.io.Serializable;

/**
 * Data for any Account's actual name information
 * @author bdabr
 *
 */
public class Name implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8097859334566425037L;
	private String firstName;
	private String lastName;
	private String middleName;
	
	/**
	 * Holds an account's name info
	 * @param firstName First Name
	 * @param lastName Last Name 
	 * @param middleName Middle Name / Middle Initial
	 */
	public Name(String firstName, String lastName, String middleName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	}
	
	/**
	 * Hold's an account's name info (Doesn't have a middle name
	 * @param firstName First Name
	 * @param lastName Last Name
	 */
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = null;
	}
	/**
	 * @return gives first, middle and last name as string
	 */
	public String toString() {
		return firstName + " " +  middleName + " " +  lastName;
	}
	
	//setters and getters
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
		
}
