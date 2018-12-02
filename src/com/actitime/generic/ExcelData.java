package com.actitime.generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	public static String getData(String path, String sheetName, int rn, int cn)
	{
		try
		{
			FileInputStream fi=new FileInputStream(path);
			Sheet sh = WorkbookFactory.create(fi).getSheet(sheetName);
			String data = sh.getRow(rn).getCell(cn).getStringCellValue();
			return data;
		}
		catch(Exception e)
		{
			return " ";
		}	
	}
	
	public static int getRowCount(String path, String sheetName)
	{
		try
		{
			FileInputStream fi=new FileInputStream(path);
			Sheet sh = WorkbookFactory.create(fi).getSheet(sheetName);
			int rc = sh.getLastRowNum();
			return rc;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	public static int getCellCount(String path, String sheetName, int rn)
	{
		try
		{
			FileInputStream fi=new FileInputStream(path);
			Row r = WorkbookFactory.create(fi).getSheet(sheetName).getRow(rn);
			short cc = r.getLastCellNum();
			
			return cc;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
}
