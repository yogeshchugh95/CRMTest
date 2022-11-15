package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "tasks";
	//constructor
	public ContactsPageTest()
	{
		super();//It will do to call the super class constructor(TestBase).
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initailization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
//		assign to homePage reference variable because after login page will navigate to homepage.
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		System.out.println(homePage);
		testUtil.switchToFrame();
		contactsPage =  homePage.clickOnContactsLink();
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts page missing on the page");
	}
	
	@Test(priority = 2)
	public void selectSingleContactsTest() throws InterruptedException
	{
//		Thread.sleep(2000);
		contactsPage.selectContactsByName("Tom");
	}
	
	@Test(priority = 3)
	public void selectMultipleContactsTest()
	{
		contactsPage.selectContactsByName("Professor");
		contactsPage.selectContactsByName("David Cris");
	}
	
	@DataProvider(name="getCRMTestData")
	public Object[][] getCRMTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 4 , dataProvider="getCRMTestData" ) // for multiple entry new contact form
	//validateCreateNewContact function having four parameters bcoz excel sheet (data driven approach)
	//contains four columns. so make sure parameter should be same as per columns
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) 
	{
		homePage.clickOnNewContactsLink();
		//Sheet will assigned the value to validateCreateNewContact function parameters and 
		//validateCreateNewContact assigned the value to createNewContact function's parameter
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	@Test(priority = 4 )
	public void validate() // for single entry new contact form
	{
		homePage.clickOnNewContactsLink();
		contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
//		driver.quit();
	}

}
