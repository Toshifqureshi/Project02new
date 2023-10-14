package com.organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.ObjectRepository.CreateOrganization01Page;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.OrganizationPage;

public class Organization01 extends BaseClass {
	@Test
	public void orgCreate01() throws EncryptedDocumentException, IOException
	
	{
		HomePage hp= new HomePage(driver);
		hp.clickOnHomePageOrgLink();
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrgnizationLokkUpImg();
		CreateOrganization01Page cop1=new CreateOrganization01Page(driver);
		 String eread = eutil.excelRead("Organization", 4, 2)+jutil.randomNum();
		cop1.createOrg01Page(driver, eread, eread);
	}

}
