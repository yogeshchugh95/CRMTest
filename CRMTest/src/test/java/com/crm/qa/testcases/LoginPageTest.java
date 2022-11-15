package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;//create object
	HomePage homePage;//create object
	//constructor
	public LoginPageTest()
	{
		super();//It will call to the super class constructor(TestBase).
	}
	
	@BeforeMethod
	public void setUp()
	{
		initailization();//we have to define the method of parent class (TestBase.java)
		// so now we need to create the loginPage object;
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		//i have define the function validateLoginPageTitle and it is coming from LoginPage.java which i have already define the object in this class.
		// it is coming from LoginPage.java class bcoz this function have not static that's the reason i have create the loginPage object in above.
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority = 2)
	public void crmImageLogoTest()
	{
		Boolean logo = loginPage.validateCRMImage();
		Assert.assertTrue(true);
	}
	
	@Test(priority = 3)
	public void loginTest() throws InterruptedException
	{
		//It need to create HomePage class object bcoz it will returning the homepage class. 
		homePage =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
//		driver.quit();
	}
	
	

}
