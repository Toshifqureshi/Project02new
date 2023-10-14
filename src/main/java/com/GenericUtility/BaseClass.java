package com.GenericUtility;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ObjectRepository.HomePage;
import com.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ExcelUtility eutil=new ExcelUtility();
	public JavaUtility jutil= new JavaUtility();
	public PropertyFileUtility putil=new PropertyFileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public static WebDriver sDriver;
	public WebDriver driver;
	// Before suite- this will establish connection with DataBase
	
	
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("DataBase connection sucessfull");
	}
	
	/*this is for cross browser execution used in compatibility run
	 * 
	 * (// Before class- this will open browser
	
	//@Parameters("browser")
	//@BeforeTest
	 * )*/
	 
	@BeforeClass(groups={"SmokeSuite","RegressionSuite"})
	
	
	public void bcConfig(/*String BROWSER*/)throws EncryptedDocumentException,IOException
	{
		String BROWSER = putil.propertyFile("browser");
		String URL = putil.propertyFile("url");
		if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			System.out.println("---launched"+BROWSER+"----");
		}
		 else if (BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("---launched"+BROWSER+"----");
		}
		 else if(BROWSER.equalsIgnoreCase("edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		 }
		 else 
		 {
			 System.out.println("browser empty");
		 }
		sDriver=driver;
		wutil.maximizeWindow(driver);
		wutil.implicitlyWait(driver);
		
		driver.get(URL);
	}
	
	// Before Method - this will perform login
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws EncryptedDocumentException, IOException
	{
		String USERNAME = putil.propertyFile("username");
		String PASSWORD = putil.propertyFile("password");
		LoginPage lp= new LoginPage(driver);
		lp.clickOnloginPage(USERNAME, PASSWORD);
		System.out.println("login page sucessfull");
		
	}
	
	// After Method - this will perform logout
	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hp= new HomePage(driver);
		hp.clickOnSignOut(driver);
		
	}
	
	// After class- this will close browser
	@AfterClass(groups={"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("browser closed");
	}
	
	// After Suite- this will close database connection
	@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
	public void asConfig()
	{
		System.out.println("database disconnected sucessfully");
	}

}
