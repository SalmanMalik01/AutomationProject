package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInSingInPage extends BasePage {

	public LogInSingInPage(WebDriver driver){
		super(driver);
	}


	//for SingIn

	@FindBy(xpath="//input[@placeholder='Name']") 
	WebElement name;

	@FindBy(xpath="//input[@data-qa='signup-email']") 
	WebElement emailAddress;


	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement btn_signup;

	public void Entername(String lname) {
		name.sendKeys(lname);
	}

	public void EnterEmail(String Email) {
		emailAddress.sendKeys(Email);
	}

	public void clicksignup() {
		btn_signup.click();
	}


	//For LogIn


	@FindBy(xpath="//input[@data-qa='login-email']") 
	WebElement EmailAddress;

	@FindBy(xpath="//input[@placeholder='Password']") 
	WebElement password;

	@FindBy(xpath="//button[normalize-space()='Login']") 
	WebElement btn_login;


	@FindBy(xpath="//b[normalize-space()='salman malik']") 
	WebElement LogInConfirmation;


	@FindBy(xpath="//a[normalize-space()='Logout']") 
	WebElement btn_logout;


	@FindBy(xpath="//h2[normalize-space()='Login to your account']") 
	WebElement logOutConfirmation;

	public void EnterEmailAddress(String Email) {
		EmailAddress.sendKeys(Email);
	}

	public void EnterPassword(String pws) {
		password.sendKeys(pws);
	}

	public void clickLogIn() {
		btn_login.click();
	}

	public void clickLogOut() {
		btn_logout.click();
	}

	public String loginConfirmation() {
		try {
			return (LogInConfirmation.getText());
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public String logOutConfirmation() {
		try {
			return (logOutConfirmation.getText());
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	
	public boolean isLogOutbtnExite() {
		try {
		return (btn_logout.isDisplayed());
		}catch(Exception e) {
			return false;
		}
	}
	

}
