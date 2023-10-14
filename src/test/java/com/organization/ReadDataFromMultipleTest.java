package com.organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.ObjectRepository.CreateOrganizationPage;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.OrganizationInfoPage;
import com.ObjectRepository.OrganizationPage;

public class ReadDataFromMultipleTest extends BaseClass{
	
	@Test(dataProvider="getData")
	public void readMultipleData(String ORGNAME, String INDUSTRY) throws EncryptedDocumentException, IOException
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnHomePageOrgLink();
		
		OrganizationPage op= new OrganizationPage(driver);
		op.clickOnOrgnizationLokkUpImg();
		
		 //Object[][] eread = eutil.ReadMultipleDataFromExcel("Multiple");
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		cop.createNewOrganizationPage(ORGNAME, INDUSTRY);
		
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgInfoPageHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		
				
		
		
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eutil.ReadMultipleDataFromExcel("Multiple");
		return data;
	}
	

}
