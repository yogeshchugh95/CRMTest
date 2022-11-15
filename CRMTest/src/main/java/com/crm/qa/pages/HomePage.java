package com.crm.qa.pages;

//import java.awt.event.ActionEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'User: yogesh chugh')]")
	WebElement userNameLabel;
	
//	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	@FindBy(xpath = "//a[contains(@title, 'Contacts')]")
	WebElement contactLinks;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLinks;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLinks;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement taskLinks;
	
	//Initializing the page Objects:
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public Boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactsLink()
	{
		contactLinks.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLinks.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTaskLink()
	{
		taskLinks.click();
		return new TaskPage();
	}
	
	public void clickOnNewContactsLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactLinks).build().perform();
		newContactLinks.click();
	}

}
