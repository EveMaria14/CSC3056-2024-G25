package tests;

import model.User;
import utils.TestUtils;

public class UserTest {

	public static void main(String[] args) {
		
		// Call User Constructor Tests
		testUserConstructor();
	
	}
	
	public static void testUserConstructor() {
		
		// 1 - Setup
		
		String testUsername = "mike";
		String testPassword = "myPassword";
		String testFirstName = "Mike";
		String testLastName = "Smith";
		String testMobileNumber = "07716478392";
		
		// 2 - Run the object under test (constructor)
		
		User testUser = new User(testUsername, testPassword, testFirstName, testLastName, testMobileNumber);
		
		// 3- Verify (assert)
		
		// Username
		if (testUser.getUsername() == testUsername) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		}
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC1 failed: username did not match" + TestUtils.TEXT_COLOR_RESET);
		}
		
		// Password
		if (testUser.getPassword() == testPassword) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC2 passed" + TestUtils.TEXT_COLOR_RESET);
		}
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC2 failed: password did not match: " + testUser.getPassword() + " = " + testPassword + TestUtils.TEXT_COLOR_RESET);
		}
		
		// First Name
		if (testUser.getFirstName() == testFirstName) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC3 passed" + TestUtils.TEXT_COLOR_RESET);
		}
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC3 failed: firstName did not match" + TestUtils.TEXT_COLOR_RESET);
		}
		
		// Last Name
		if (testUser.getLastName() == testLastName) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC4 passed" + TestUtils.TEXT_COLOR_RESET);
		}
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC4 failed: lastName did not match" + TestUtils.TEXT_COLOR_RESET);
		}
		
		// Mobile Number
		if (testUser.getMobileNumber() == testMobileNumber) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC5 passed" + TestUtils.TEXT_COLOR_RESET);
		}
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC5 failed: mobileNumber did not match" + TestUtils.TEXT_COLOR_RESET);
		}

	}

}
