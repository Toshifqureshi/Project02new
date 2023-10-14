package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement ContactLookUpImg;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactLookUpImg() {
		return ContactLookUpImg;
	}
	// Business Library
	
	public void clickOnContactLookUpImg()
	{
		ContactLookUpImg.click();
	}

}
