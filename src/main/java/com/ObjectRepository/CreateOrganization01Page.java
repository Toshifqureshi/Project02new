package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;



public class CreateOrganization01Page extends WebDriverUtility {
	
	@FindBy(name="accountname")
	private WebElement OrgNameEdt01;
	
	@FindBy (xpath="//input[@style=\"width:74%;\"]")
	private WebElement WebsiteEdt01;
	
	@FindBy (xpath="//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement MemebrLookUpImgclick01;
	
	@FindBy (name="search_text")
	private WebElement SearchEdt01;
	
	@FindBy (name="search")
	private WebElement SearchBtn01;
	
	@FindBy (xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement Savt01;
	
	public CreateOrganization01Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt01() {
		return OrgNameEdt01;
	}

	public WebElement getWebsiteEdt01() {
		return WebsiteEdt01;
	}

	public WebElement getMemebrLookUpImgclick01() {
		return MemebrLookUpImgclick01;
	}

	public WebElement getSearchEdt01() {
		return SearchEdt01;
	}

	public WebElement getSearchBtn01() {
		return SearchBtn01;
	}

	public WebElement getSavt01() {
		return Savt01;
	}

	
	
	// Business Library
	
	public void createOrg01Page( WebDriver driver, String OrgName01, String sample)
	{
		OrgNameEdt01.sendKeys(OrgName01);
		//WebsiteEdt01.sendKeys(Website);
		MemebrLookUpImgclick01.click();
		switchToWindow(driver, "Accounts");
		SearchEdt01.sendKeys(sample);
		
		driver.findElement(By.xpath("//a[.='"+ sample+"']")).click();
		SearchBtn01.click();
		//switchToWindow(driver, "Accounts");
		Savt01.click();
		
		
		
		
		
		
		
	}

}
