package model;

public class User {
	private String username; // Should be an email address
	private String password;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	
	// Constructor
	public User(String username, String password, String firstName, String lastName, String mobileNumber) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}
	
	// Getters and Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
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
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	// To String
	public String toString() {
		return username + ", " + password + ", " + firstName + ", " + lastName + ", " + mobileNumber;
	}
	
	// To string formatted for SimpleBankingApp.java
	public String toStringFormatted() {
		return String.format("%-25s| %-15s| %-15s| %-15s| %-15s",
				getUsername(), getPassword(), getFirstName(), getLastName(), getMobileNumber());
	}

}
