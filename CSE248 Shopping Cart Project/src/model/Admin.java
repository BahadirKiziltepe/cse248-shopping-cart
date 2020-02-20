package model;

public class Admin extends Account implements Comparable<Account> {

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
