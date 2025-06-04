package TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LogInSingInPage;
import testbase.BaseTest;
import utilities.DataProviders;

public class TC03_LogInDDT extends BaseTest{


	@Test(dataProvider ="LoginData", dataProviderClass=DataProviders.class , groups = {"sanity","regretion","master"}) // getting data provider from different class
	public void TC03_LoginDDT(String Email,String pw ) {

		logger.info("Starting login test with email: " + Email);
		HomePage hp=new HomePage(driver);
		hp.clickSignupLogin();

		logger.info("Clicked on Signup/Login");

		LogInSingInPage login=new LogInSingInPage(driver);

		login.EnterEmailAddress(Email);
		login.EnterPassword(pw);
		login.clickLogIn();

		logger.info("Submitted login form");

		//LogInSingInPage logOut=new LogInSingInPage(driver);
		boolean target=login.isLogOutbtnExite();

		if (driver.getPageSource().contains("Logout") && target) {
			login.clickLogOut();
			assertTrue(true, "Login successful and logout button clicked.");
		} else {
			assertTrue(false, "Login failed or logout button not found.");
		}


	}

}

