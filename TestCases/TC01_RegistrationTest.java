package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LogInSingInPage;
import pageObject.RegistrationPage;
import testbase.BaseTest;

public class TC01_RegistrationTest extends BaseTest {

	@Test(groups = {"sanity","regretion","master"})
	public void TC01_CreateAccount() throws InterruptedException {
		
		logger.info("****Starting TC01_CreateAccount*****");

		HomePage hp=new HomePage(driver);
		hp.clickSignupLogin();

		LogInSingInPage lsp=new LogInSingInPage(driver);
		lsp.Entername("salmanmalik12");

		lsp.EnterEmail(randomAlphaNumebric()+"@gmail.com");

		lsp.clicksignup();

		RegistrationPage regisPage=new RegistrationPage(driver);
		logger.info("****Data entering for Registration*****");
		regisPage.ClickMr();
		regisPage.setPassword(randomNumber());
		regisPage.selectDay("2");
		regisPage.selectMonth("March");
		regisPage.selectYear("2001");
		regisPage.setFirstname(randomString());
		regisPage.setLastname(randomString());
		regisPage.setCompany(randomString());
		regisPage.setAddress(randomString());
		regisPage.setAddress2(randomString());
		regisPage.selectCountry("India");
		regisPage.setState(randomString());
		regisPage.setCity(randomString());
		regisPage.setZipCode(randomNumber());
		regisPage.Submit();

		logger.info("****End Data Entering*****");
		
		String confMsg=regisPage.get_Msgconfirm();
		assertEquals(confMsg, "ACCOUNT CREATED!");
		System.out.println("ACCOUNT CREATED! SUCCESSFULLY");

		logger.info("****End TC01_CreateAccount*****");
	
	}



}
