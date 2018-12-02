package com.actitime.test;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTestClass;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;


public class ValidLoginLogoutTest extends BaseTestClass
{
	@Test(priority=1)
	public void testValidLoginLogout() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		String filePath="./data/TestData.xlsx";
		String un = ExcelData.getData(filePath, "TC01", 1, 0);
		String pwd = ExcelData.getData(filePath, "TC01", 1, 1);
		String loginTitle = ExcelData.getData(filePath, "TC01", 1, 2);
		String enterTimeTrackTitle = ExcelData.getData(filePath, "TC01", 1, 3);
		
		
		lp.verifyPage(loginTitle);
		Thread.sleep(500);
		lp.enterUserName(un);
		Thread.sleep(500);
		lp.enterPassword(pwd);
		Thread.sleep(500);
		lp.clickOnLogin();
		lp.verifyPage(enterTimeTrackTitle);
		Thread.sleep(500);
		ep.clickOnLogout();
		Thread.sleep(500);
		lp.verifyPage(loginTitle);
		
		
	}
}
