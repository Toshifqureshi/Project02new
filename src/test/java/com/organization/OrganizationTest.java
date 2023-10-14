package com.organization;





import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.ObjectRepository.CreateOrganizationPage;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.OrganizationInfoPage;
import com.ObjectRepository.OrganizationPage;

//@Listeners(com.GenericUtility.Listners.class)
@Listeners(com.GenericUtility.Listner1.class)
public class OrganizationTest extends BaseClass {
	@Test	(groups="SmokeSuite")
	public void organizationPage1() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String eRead = eutil.excelRead("Organization", 4, 2)+jutil.randomNum();
		HomePage hp=new HomePage(driver);
		hp.clickOnHomePageOrgLink();
		
		OrganizationPage op= new OrganizationPage(driver);
		op.clickOnOrgnizationLokkUpImg();
		
		
	
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		cop.createNewOrganizationPage(eRead);
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String Header1 = oip.getOrgInfoPageHeader();
	    Assert.assertTrue(Header1.contains(Header1));
		
		
	}

}
