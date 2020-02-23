package model;

import java.io.Serializable;

/**
 * Account subclass that has special privleges compared to the User type
 * @author bdabr
 *
 */
public class Admin extends Account implements Comparable<Account>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4977953296203922926L;

	/**
	 * Creates an Admin account
	 * @param userName Admin username
	 * @param password Admin password
	 * @param name Admin's name
	 * @param address Admin's address
	 * @param email Admin's email address
	 */
	public Admin(String userName, String password, Name name, Address address, String email) {
		super(userName, password, name, address, email);
	}

	
	
	

}
