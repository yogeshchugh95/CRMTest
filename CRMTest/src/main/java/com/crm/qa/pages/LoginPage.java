package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - Object Repository:
	@FindBy(name ="username")//It is annotation and another way to implement locate Element i.e. driver.findElement(By.name("username"));
	//@cacheLookup is the annotation in pagefactory api and it used to store data into cache in memory
	//After implement cacheLookup, whenever you interact with element (WebElement username;) instead of page, get the element from cache.
	//Script performance will be improved after implement cachelookup.
	// For more info: See naveen POM 4 episode from 37:00 timing
//	@CacheLookup
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(xpath ="//input[@value='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath ="//button[contains(text(),'Sign Up')]")
	WebElement signUpbtn;
	
	@FindBy(xpath ="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the Page Objects
	public LoginPage()
	{
		//PageFactory is a class; driver is coming from base class (TestBase.java); 'this' is pointing to the current class object as define above username, password etc 
		//initElements means initialize the web elements with driver and 'this'.
		//All above mentioned variables(like above mentioned WebElement or this keyword) are initializing with it's driver keyword.
		//We also use the object of LoginPage class instead of 'this' keyword (i.e. "LoginPage.class")
		PageFactory.initElements(driver, this);
		
	}
	
	//Action:
	// We used string instead of void bcoz we need to return the value.
	public String validateLoginPageTitle()
	
	{
		return driver.getTitle();
	}
	
	public Boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		loginbtn.click();
//		return null;
		
		//So now it should be return Homepage class object because landing page is HomePage.
		// So i will change the type of void by HomePage in that function bcoz we need to be return Homepage.
		return new HomePage();
		
	}
	
}
