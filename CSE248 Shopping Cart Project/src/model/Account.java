package model;

public abstract class Account implements Comparable<Account>  {
	
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
	
	//ShortCut Setters
	
	/**
	 * Grabs the account's Name variable and adjusts the firstName
	 * @param firstName User's Given Name
	 */
	public void setFirstName(String firstName) {
        this.name.setFirstName(firstName);
    }
	/**
	 * Grab this account's Name variable and adjusts the middleName
	 * @param middleName User's Middle Name
	 */
    public void setMiddleName(String middleName) {
        this.name.setMiddleName(middleName);
    }
    /**
     * Grab this account's Name variable and adjusts the lastName
     * @param lastName User's Last Name
     */
    public void setLastName(String lastName) {
        this.name.setLastName(lastName);
    }
	/**
	 * Grab this account's Address variable and adjusts the street
	 * @param street User's street
	 */
    public void setStreet(String street) {
        this.address.setStreet(street);
    }
    /**
     * Grab this account's Address variable and adjusts the state
     * @param state User's state
     */
    public void setState(String state) {
        this.address.setState(state);
    }
    /**
     * Grab this account's Address variable and adjusts the city
     * @param city User's city
     */
    public void setCity(String city) {
        this.address.setCity(city);
    }
    /**
     * Grab this account's Address variable and adjusts the zipcode
     * @param zipCode User's zipcode
     */
    public void setZipCode(String zipCode) {
        this.address.setZipCode(zipCode);
    }
    /**
     * Grab this account's Address variable and adjusts the country
     * @param country User's country
     */
    public void setCountry(String country) {
        this.address.setCountry(country);
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
