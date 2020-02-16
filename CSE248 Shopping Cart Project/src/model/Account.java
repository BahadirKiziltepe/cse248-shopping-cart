package model;

public class Account {
	
	private String userName;
	private String password;
	private Name name;
	private Address address;
	
	public Account(String userName,String password,Name name, Address address) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.address = address;
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
	
	
}
