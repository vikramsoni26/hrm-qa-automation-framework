package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void loginTest() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login("Admin", "admin123");
		
	    Assert.assertTrue(
	    		loginPage.isDashboardDisplayed(),
	    		"Dashboard is not displayed after succesful login"
	    		);
		
		
		        System.out.println("Valid login test passed");
	}
	
	@Test
	public void invalidLoginTest() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login("Admin", "wrongPassword");
		
		Assert.assertTrue(
				loginPage.isErrorMessageDisplayed(),
				"Error message is not displayed for invalid login"
				);
		
		System.out.println("Invalid Login Test Passed");
	}
	
	@Test
	public void logoutTest() {

	    LoginPage loginPage = new LoginPage(driver);

	    loginPage.login("Admin", "admin123");

	    DashboardPage dashboardPage = new DashboardPage(driver);

	    dashboardPage.logout();

	    Assert.assertTrue(
	            dashboardPage.isLoginPageDisplayed(),
	            "Login page is not displayed after logout"
	    );

	    System.out.println("Logout test passed");
	}

}
