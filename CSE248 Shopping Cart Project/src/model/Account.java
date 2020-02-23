package model;

import java.io.Serializable;

/**
 * Abstract class for User/Admin
 * @author bdabr
 *
 */
public abstract class Account implements Comparable<Account>, Serializable  {
	  private static final long serialVersionUID = 4251085793863071469L;
	
	private String userName;
	private String password;
	private Name name;
	private Address address;
	private String email;
	
	/**
	 * This is the basic Account class (currently, it is an abstract class)
	 * This is used as the skeleton for either an Admin or a User account
	 * @param userName account username
	 * @param password account password
	 * @param name account holder's name
	 * @param address account holder's address
	 * @param email account holder's email address
	 */
	public Account(String userName,String password,Name name, Address address, String email) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
	}
	
	// setters and getters
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(Account o) {
		int num = this.getUserName().compareTo(o.getUserName());
		if (num < 0) {
			return -1;
		}
		if (num > 0) {
			return 1;
		}
		return 0;
	}
	
	
	
}
