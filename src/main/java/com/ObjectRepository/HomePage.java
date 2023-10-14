package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	@FindBy(linkText="Organizations")
	private WebElement OrgLink;
	
	@FindBy (linkText="Contacts")
	private WebElement ContactLink;
	
	@FindBy (linkText="Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdministratorLookUpImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgLink() {
		return OrgLink;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getAdministratorLokkUpImg() {
		return AdministratorLookUpImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	// Business Library
	public void clickOnHomePageOrgLink()
	{
		OrgLink.click();
	}
	public void clickOnHomePageContactLink()
	{
		ContactLink.click();
	}
	public void clickOnHomePageOpportunitiesLink()
	{
		OpportunitiesLink.click();
	}
	public void clickOnSignOut(WebDriver driver)
	
	{
		mouseHover(driver, AdministratorLookUpImg);
		SignOutLink.click();
	}
	

}
	