package tests;

import java.util.Calendar;
import java.util.Date;

import model.Account;
import utils.TestUtils;

public class AccountTest {
	
	public static void testConstructor() {
		// Create a Calendar instance
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.JANUARY, 1);
        
        // Setup
      
        String testAccountNumber = "111";
    	String testUsernameOfAccountHolder = "mike";
    	String testAccountType = "savings";
    	Date testAccountOpeningDate = calendar.getTime();
    	
    	// Run the object under test
    	
        Account testAccount = new Account(testAccountNumber, testUsernameOfAccountHolder, testAccountType, testAccountOpeningDate);
        
        // Verify (assert)
        
        // AccountNumber
 		if (testAccount.getAccountNumber() == testAccountNumber) {
 			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestAccountConstructor-TC1 passed" + TestUtils.TEXT_COLOR_RESET);
 		}
 		else {
 			System.out.println(TestUtils.TEXT_COLOR_RED + "TestAccountConstructor-TC1 failed: accountNumber did not match" + TestUtils.TEXT_COLOR_RESET);
 		}
 		
 		// UsernameOfAccountHolder
 		if (testAccount.getUsernameOfAccountHolder() == testUsernameOfAccountHolder) {
 			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestAccountConstructor-TC2 passed" + TestUtils.TEXT_COLOR_RESET);
 		}
 		else {
 			System.out.println(TestUtils.TEXT_COLOR_RED + "TestAccountConstructor-TC2 failed: usernameOfAccountHolder did not match" + TestUtils.TEXT_COLOR_RESET);
 		}
 		
 		// AccountType
 		if (testAccount.getAccountType() == testAccountType) {
 			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestAccountConstructor-TC3 passed" + TestUtils.TEXT_COLOR_RESET);
 		}
 		else {
 			System.out.println(TestUtils.TEXT_COLOR_RED + "TestAccountConstructor-TC3 failed: accountType did not match" + TestUtils.TEXT_COLOR_RESET);
 		}
 		
 		// AccountOpeningDate
 		if (testAccount.getAccountOpeningDate() == testAccountOpeningDate) {
 			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestAccountConstructor-TC4 passed" + TestUtils.TEXT_COLOR_RESET);
 		}
 		else {
 			System.out.println(TestUtils.TEXT_COLOR_RED + "TestAccountConstructor-TC4 failed: accountOpeningDate did not match" + TestUtils.TEXT_COLOR_RESET);
 		}
 		
 		// Assertions
		
		assert testAccount.getAccountNumber() == testAccountNumber;
		assert testAccount.getUsernameOfAccountHolder() == testUsernameOfAccountHolder;
		assert testAccount.getAccountType() == testAccountType;
		assert testAccount.getAccountOpeningDate() == testAccountOpeningDate;

		System.out.println("All account test assertions for constructor passed (none failed)");
	}
	
	public static void testSetters() {
		// Create a Calendar instance
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.JANUARY, 1);
        
        // Setup
      
        String testAccountNumber = "111";
    	String testUsernameOfAccountHolder = "mike";
    	String testAccountType = "savings";
    	Date testAccountOpeningDate = calendar.getTime();
    	
    	// Run the object under test
    	
        Account testAccount = new Account(testAccountNumber, testUsernameOfAccountHolder, testAccountType, testAccountOpeningDate);
        
        String newAccountNumber = "111";
    	String newUsernameOfAccountHolder = "mike";
    	String newAccountType = "savings";
    	Date newAccountOpeningDate = calendar.getTime();
        
        testAccount.setAccountNumber(newAccountNumber);
        testAccount.setUsernameOfAccountHolder(newUsernameOfAccountHolder);
        testAccount.setAccountType(newAccountType);
        testAccount.setAccountOpeningDate(newAccountOpeningDate);
        
        // Verify (assert)
        
        // AccountNumber
 		if (testAccount.getAccountNumber() == newAccountNumber) {
 			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestAccountSetter-TC1 passed" + TestUtils.TEXT_COLOR_RESET);
 		}
 		else {
 			System.out.println(TestUtils.TEXT_COLOR_RED + "TestAccountSetter-TC1 failed: accountNumber did not match" + TestUtils.TEXT_COLOR_RESET);
 		}
 		
 		// UsernameOfAccountHolder
 		if (testAccount.getUsernameOfAccountHolder() == newUsernameOfAccountHolder) {
 			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestAccountSetter-TC2 passed" + TestUtils.TEXT_COLOR_RESET);
 		}
 		else {
 			System.out.println(TestUtils.TEXT_COLOR_RED + "TestAccountSetter-TC2 failed: usernameOfAccountHolder did not match" + TestUtils.TEXT_COLOR_RESET);
 		}
 		
 		// AccountType
 		if (testAccount.getAccountType() == newAccountType) {
 			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestAccountSetter-TC3 passed" + TestUtils.TEXT_COLOR_RESET);
 		}
 		else {
 			System.out.println(TestUtils.TEXT_COLOR_RED + "TestAccountSetter-TC3 failed: accountType did not match" + TestUtils.TEXT_COLOR_RESET);
 		}
 		
 		// AccountOpeningDate
 		if (testAccount.getAccountOpeningDate() == newAccountOpeningDate) {
 			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestAccountSetter-TC4 passed" + TestUtils.TEXT_COLOR_RESET);
 		}
 		else {
 			System.out.println(TestUtils.TEXT_COLOR_RED + "TestAccountSetter-TC4 failed: accountOpeningDate did not match" + TestUtils.TEXT_COLOR_RESET);
 		}
 		
 		// Assertions
		
 		assert testAccount.getAccountNumber() == newAccountNumber;
		assert testAccount.getUsernameOfAccountHolder() == newUsernameOfAccountHolder;
		assert testAccount.getAccountType() == newAccountType;
		assert testAccount.getAccountOpeningDate() == newAccountOpeningDate;
		
		System.out.println("All account test assertions for setters passed (none failed)");
		
	}

	public static void main(String[] args) {

		// Call tests for constructor and setters
		
		testConstructor();
		testSetters();
	}

}
