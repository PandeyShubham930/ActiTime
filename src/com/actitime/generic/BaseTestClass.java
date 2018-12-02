package com.actitime.generic;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



abstract public class BaseTestClass implements Auto_Constant
{
	public WebDriver driver;
	static
	{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(firfox_key, firefox_value);
	}
	
	
	
	@Parameters({"nodeURL","browser","appURL"})
	@BeforeMethod
	public void preCondition(String nodeURL, String browser, String appURL) throws MalformedURLException
	{
		
		URL url=new URL(nodeURL);
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName(browser);
		driver=new RemoteWebDriver(url, dc);
		//driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(appURL);
	}
	
	@AfterMethod
	public void postCondition(ITestResult res)
	{
	int status = res.getStatus();
	if(status==2)
	{
	String name = res.getName();
	GenericUtils.getScreenshot(driver, name);
	}		
		driver.quit();	
	}
}
