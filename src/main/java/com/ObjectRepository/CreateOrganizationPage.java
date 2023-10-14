package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	
	
	@FindBy (name="accountname")
	private WebElement OrganizationNameEdt;	
	
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy (xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement NewOrgSaveBtn;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	


	
	public WebElement getOrganizationNameEdt() {
		return OrganizationNameEdt;
	}





	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}





	public WebElement getNewOrgSaveBtn() {
		return NewOrgSaveBtn;
	}





	// Business Library
	/**
	 * This Method create organization page
	 * @param OrgName
	 */
	public void createNewOrganizationPage(String OrgName)
	{
		
		OrganizationNameEdt.sendKeys(OrgName);
		NewOrgSaveBtn.click();
	}
	/**
	 * This Method will create organization with industry
	 * @param OrgName
	 * @param Industry
	 */
	public void createNewOrganizationPage(String OrgName, String Industry)
	{
		
		OrganizationNameEdt.sendKeys(OrgName);
		dropDownByText(IndustryDropDown, Industry);
		
		NewOrgSaveBtn.click();
	}
	

}
