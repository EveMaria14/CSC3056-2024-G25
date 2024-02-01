package model;
import java.util.Date;

public class Transaction {
	String accountNumber;
	Date transactionDate;
	double transactionAmount;
	
	// Constructor
	public Transaction(String accountNumber, Date transactionDate, double transactionAmount) {
		super();
		this.accountNumber = accountNumber;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
	}
	
	// Getters and Setters
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
}
