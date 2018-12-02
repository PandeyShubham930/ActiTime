package com.actitime.test;



import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTestClass;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class VerifyVersionTest extends BaseTestClass
{
	String filepath="./data/TestData.xlsx";
	
	@Test(priority=3)
	public void testVerifyVersion() 
	{
		String loginTitle = ExcelData.getData(filepath, "TC01", 1, 2);
		String eVersion = ExcelData.getData(filepath, "TC03", 1, 0);
		LoginPage lp=new LoginPage(driver);
		lp.verifyPage(loginTitle);
		
		String aVersion = lp.verfiyVersion();
		Reporter.log("Actual Version>> "+aVersion, true);
		Reporter.log("Expected Version>> "+eVersion, true);
		
		Assert.assertEquals(aVersion, eVersion);
		Reporter.log("Version is Matching", true);
		
		
	}
}
