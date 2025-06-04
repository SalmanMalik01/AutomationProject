package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver){
		super(driver);
	}



	@FindBy(xpath="//input[@id='id_gender1']") 
	WebElement btn_mr;

	@FindBy(xpath="//input[@id='password']") 
	WebElement txt_password;

	@FindBy(xpath="//select[@id='days']") 
	WebElement slt_day;

	@FindBy(xpath="//select[@id='months']") 
	WebElement slt_month;

	@FindBy(xpath="//select[@id='years']") 
	WebElement slt_year;

	@FindBy(xpath="//input[@id='first_name']") 
	WebElement txt_firstName;

	@FindBy(xpath="//input[@id='last_name']") 
	WebElement txt_lastName;

	@FindBy(xpath="//input[@id='company']") 
	WebElement txt_company;

	@FindBy(xpath="//input[@id='address1']") 
	WebElement txt_address;

	@FindBy(xpath="//input[@id='address2']") 
	WebElement txt_address2;

	@FindBy(xpath="//select[@id='country']") 
	WebElement slt_country;

	@FindBy(xpath="//input[@id='state']") 
	WebElement txt_state;

	@FindBy(xpath="//input[@id='city']") 
	WebElement txt_city;

	@FindBy(xpath="//input[@id='zipcode']") 
	WebElement txt_zipcode;

	@FindBy(xpath="//input[@id='mobile_number']") 
	WebElement txt_mobileNumber;


	@FindBy(xpath="//button[normalize-space()='Create Account']") 
	WebElement btn_createAccount;


	@FindBy(xpath="//b[normalize-space()='Account Created!']") 
	WebElement msg_confirmation;




	@FindBy(xpath="//a[normalize-space()='Continue']") 
	WebElement btn_Continue;


	public void ClickMr (){
		btn_mr.click();
	}

	public void setPassword (String pass){
		txt_password.sendKeys(pass);;
	}

	public void selectDay (String day){
		Select select=new Select(slt_day);
		select.selectByVisibleText(day);

	}

	public void selectMonth (String month){
		Select select=new Select(slt_month);
		select.selectByVisibleText(month);
	}

	public void selectYear (String year){
		Select select=new Select(slt_year);
		select.selectByVisibleText(year);
	}

	public void setFirstname (String fname){
		txt_firstName.sendKeys(fname);
	}

	public void setLastname (String lname){
		txt_lastName.sendKeys(lname);
	}

	public void setCompany (String companyName){
		txt_company.sendKeys(companyName);
	}

	public void setAddress (String Address){
		txt_address.sendKeys(Address);
	}

	public void setAddress2 (String Address2){
		txt_address2.sendKeys(Address2);
	}


	public void selectCountry (String country){
		Select select =new Select(slt_country);
		select.selectByVisibleText(country);
	}

	public void setState (String State){
		txt_state.sendKeys(State);
	}

	public void setCity (String City){
		txt_city.sendKeys(City);
	}

	public void setZipCode (String ZipCode){
		txt_zipcode.sendKeys(ZipCode);
	}

	public void setMobileNumber (String mobileNum){
		txt_mobileNumber.sendKeys(mobileNum);
	}

	public void Submit(){
		btn_createAccount.submit();
	}

	public String get_Msgconfirm() {
		try {
			return (msg_confirmation.getText());
		} catch (Exception e) {
			return(e.getMessage());
		}

	}

	public void clickContinue(){
		btn_Continue.click();
	}

}
