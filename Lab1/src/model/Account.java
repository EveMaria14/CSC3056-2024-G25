package model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
	String accountNumber;
	String usernameOfAccountHolder;
	String accountType; // Standard or Saving
	Date accountOpeningDate;
	
	// Constructor
	public Account(String accountNumber, String usernameOfAccountHolder, String accountType, Date accountOpeningDate) {
		super();
		this.accountNumber = accountNumber;
		this.usernameOfAccountHolder = usernameOfAccountHolder;
		this.accountType = accountType;
		this.accountOpeningDate = accountOpeningDate;
	}
	
	// Getters and Setters
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUsernameOfAccountHolder() {
		return usernameOfAccountHolder;
	}
	public void setUsernameOfAccountHolder(String usernameOfAccountHolder) {
		this.usernameOfAccountHolder = usernameOfAccountHolder;
	}

	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getAccountOpeningDate() {
		return accountOpeningDate;
	}
	public void setAccountOpeningDate(Date accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}
	
	// To String
	public String toString() {
		return accountNumber + ", " + usernameOfAccountHolder + ", " + accountType + ", " + accountOpeningDate;
	}
	
	//to string formatted for SimpleBankingApp.java
	public String toStringFormatted() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String formattedOpeningDate = dateFormat.format(getAccountOpeningDate());
		
		return String.format("%-10s| %-30s| %-10s| %-15s",
				getAccountNumber(), getUsernameOfAccountHolder(), getAccountType(), formattedOpeningDate);
	}
}
