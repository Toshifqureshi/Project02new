package com.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;



public class WebDriverUtility {
	/**
	 * This Method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This Method will Implicitly wait
	 * @param driver
	 */
	public void implicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	/**
	 * This Method will perform explicitly wait until webElement to be Clickable
	 * @param driver
	 * @param element
	 */
	public void explicitlyWait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This Method will select dropDown by Index
	 * @param element
	 * @param Index
	 */
	public void dropDownByIndex(WebElement element, int Index)
	{
		Select sel= new Select(element);
		sel.selectByIndex(Index);
	}
	/**
	 * This Method will select dropDown by Text
	 * @param element
	 * @param Text
	 */
	public void dropDownByText(WebElement element , String Text)
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(Text);
	}
	/**
	 * This Method will select dropDown by Value
	 * @param element
	 * @param value
	 */
	public void dropDownByValue(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This Method will perform mouseHover action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/**
	 * This Method will Perform double Click on Web Page
	 * @param driver
	 */
	public void doubleClickOnWebPage(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick();
	}
	/**
	 * This Method will perform doubleClick on WebElement
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnWebElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element);
	}
	/**
	 * This Method will Perform Right click on anywhere on WebPage
	 * @param driver
	 */
	public void rightClickOnWebPage(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.contextClick();
	}
	/**
	 * This Method will Perform Right Click on Target WebElement
	 * @param driver
	 * @param element
	 */
	public void rightClickOnWebElement(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element);
	}
	/**
	 * This Method will Take Screenshot
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws IOException
	 */
	public String screnShoot(WebDriver driver, String ScreenShotName) throws IOException
	{
		TakesScreenshot sc= (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\screenshot\\"+ScreenShotName+".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();
		
	}
	/**
	 * This Method will perform window switching action
	 * @param driver
	 * @param ParTitle
	 */
	public void switchToWindow(WebDriver driver,String ParTitle )
	{
		Set<String> allwin = driver.getWindowHandles();
		for (String cwin:allwin)
		{
			String actTitle = driver.switchTo().window(cwin).getTitle();
			if (actTitle.contains(ParTitle))
			{
				break;
			}
		}
	}
	
	

}
