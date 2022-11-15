package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	//It have create the object reference
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initailization();
		loginPage = new LoginPage();
//		System.out.println("loginpage: "+loginPage);
		testUtil = new TestUtil();
//		System.out.println("TestUtil Class: "+ testUtil);
		contactsPage = new ContactsPage();
//		System.out.println("Contact Page: "+contactsPage);
//		System.out.println("Before login Homepage value is: "+homePage);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		System.out.println("Home page value is: "+homePage);
//		testUtil.switchToFrame();
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitle()
	{
		String homePagetitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePagetitle, "CRMPRO", "HomePage Title not matched");
	}
	
	@Test(priority = 2)
	public void verifyUserName() throws InterruptedException
	{
		testUtil.switchToFrame();// this function definition coming from Util class.
		Thread.sleep(2000);
		Boolean userName = homePage.verifyCorrectUserName();
		Assert.assertTrue(userName);
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest()
	{
		 contactsPage =  homePage.clickOnContactsLink();// clickOnContactsLink() is returning the contact page object from HomePage.java class.
	}
	@AfterMethod
	public void tearDown()
	{
//		driver.quit();
	}

}
