package com.PractiseExcersise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyPractiseTest {
	@Test(groups="SmokeSuite")
	public void date1() {
		Date d = new Date();
		String dateprint = d.toString();
		System.out.println(dateprint);
		//Reporter.log(dateprint);
		
	}

	@Test(groups="RegressionSuite")
	public void getSystemDateInFormat() {
		Date d = new Date();
		String[] dArr = d.toString().split(" ");

		String day = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");

		String date = day + "--" + month + "--" + year + "--" + time;
		System.out.println(date);

	}
	@Test
	public void random()
	{
		Random r= new Random();
				int random = r.nextInt(1000);
		System.out.println(random);
		
	}
	
	@Test
	public void excelread() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\October.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Organization");
		Row r = sh.getRow(1);
		Cell c = r.getCell(2);
		System.out.println(c.getStringCellValue());
	}
	@Test
	public void excelWrite() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\October.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("Toshif");
		Row r = sh.createRow(3);
		Cell c = r.createCell(2);
		 c.setCellValue("I Am Great");
		 FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\October.xlsx");
		 wb.write(fos);
		 wb.close();
	
	}
	@Test
	public void propertyfile() throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\october.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		System.out.println(pobj.getProperty("url"));
		
	}
	@Test(dataProvider="getData")
	public void dataProvider(String company, int price)
	{
		System.out.println(company+"---"+price);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
	data[0][0]="apple";
	data[0][1]=1000;
	data[1][0] ="samsung";
	data[1][1] =2000;
	data[2][0]="htc";
	data[2][1]=3000;
	return data;
	}
}
