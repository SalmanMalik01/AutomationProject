package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LogInSingInPage;
import testbase.BaseTest;

public class TC02_LogInTest extends BaseTest {

	@Test(groups = {"sanity","regretion","master"})
	public void TC02_LogIn() {
		
		HomePage hp=new HomePage(driver);
		hp.clickSignupLogin();
		
		LogInSingInPage login=new LogInSingInPage(driver);
		
		login.EnterEmailAddress(p.getProperty("EmialId"));
		login.EnterPassword(p.getProperty("Password"));
		login.clickLogIn();
		String loginconfirm=login.loginConfirmation();
		assertEquals(loginconfirm, "salman malik");
		System.out.println("LOG IN! SUCCESSFULLY");
		
	}
	
	@Test(groups = {"sanity","functional","master"})
	public void TC03_LogOut() {
		LogInSingInPage logOut=new LogInSingInPage(driver);
		logOut.clickLogOut();
		String logOutConfirm=logOut.logOutConfirmation();
		assertEquals(logOutConfirm, "Login to your account");
		System.out.println("LOG OUT! SUCCESSFULLY");
		
	}
	
}
