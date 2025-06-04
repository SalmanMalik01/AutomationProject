package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver){
		super(driver);
	}


	@FindBy(xpath="//a[normalize-space()='Signup / Login']") 
	WebElement signup_Login;


	@FindBy(linkText = " Products") 
	WebElement btn_product;
	
	public void clickSignupLogin() {
		signup_Login.click();
	}

 
	public void btn_pruduct() {
		btn_product.click();
	}

}
