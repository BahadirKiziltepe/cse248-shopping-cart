package model;

public class Account {
	
	private String userName;
	private String password;
	private Name name;
	private Address address;
	private String email;
	
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
	
	
}
