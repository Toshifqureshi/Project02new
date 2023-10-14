package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	/**
	 * This Method will Read Data from Excel File
	 * @param Sheet
	 * @param RowNum
	 * @param CellNum
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String excelRead(String Sheet, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(CommonFilePath.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet);
		Row r = sh.getRow(RowNum);
		Cell c = r.getCell(CellNum);
		String value = c.getStringCellValue();
		return value;
	}
	/**
	 * This Method will write data in excel
	 * @param Sheet1
	 * @param RowNum
	 * @param CellNum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void excelWrite(String Sheet1, int RowNum, int CellNum, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(CommonFilePath.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(Sheet1);
		Row r = sh.createRow(RowNum);
		Cell c = r.createCell(CellNum);
		c.setCellValue(value);
		FileOutputStream fos= new FileOutputStream(CommonFilePath.excelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	public Object[][] ReadMultipleDataFromExcel(String Sheet5) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(CommonFilePath.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet5);
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
		
	
		Object[][] data = new Object[lastRow][lastCel];
		for(int i=0; i<lastRow; i++)
		{
			for (int j=0;j<lastCel;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	
	

}

