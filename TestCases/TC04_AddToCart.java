package TestCases;

import pageObject.HomePage;
import testbase.BaseTest;

public class TC04_AddToCart extends BaseTest {

	
	public void AddToCart() {
		
		HomePage homepage=new HomePage(driver);
		homepage.btn_pruduct();
		
	}
	
}
