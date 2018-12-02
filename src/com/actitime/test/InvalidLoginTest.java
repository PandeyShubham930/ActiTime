package com.actitime.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTestClass;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class InvalidLoginTest extends BaseTestClass
{
	String filepath="./data/TestData.xlsx";
	@Test(priority=2)
	public void testInvalidLogin() throws InterruptedException 
	{
		
		LoginPage lp=new LoginPage(driver);
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		String loginTitle = ExcelData.getData(filepath, "TC01", 1, 2);
		String errorMSG = ExcelData.getData(filepath, "TC02", 1, 2);
		
		lp.verifyPage(loginTitle);
		int rc = ExcelData.getRowCount(filepath, "TC02");
		for(int i=1;i<=rc;i++)
		{
			String un = ExcelData.getData(filepath, "TC02", i, 0);
			String pwd = ExcelData.getData(filepath, "TC02", i, 1);
			
			Thread.sleep(1000);
			Reporter.log("User Name>> "+un, true);
			lp.enterUserName(un);
			Reporter.log("Password>> "+pwd, true);
			lp.enterPassword(pwd);
			lp.clickOnLogin();
			String aErrorMSG = lp.verifyErrorMessage();
			Reporter.log("Actual Error message >>"+aErrorMSG, true);
			Reporter.log("Expected Error message>> "+errorMSG, true);
			
			
			
			
			
		}
		
		
	}
}
