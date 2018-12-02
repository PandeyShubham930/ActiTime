package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BasePage;

public class LoginPage extends BasePage
{
	@FindBy(id="username")
	private WebElement userNameTB;
	
	@FindBy(name="pwd")
	private WebElement passwordTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	@FindBy(xpath="(//span[@class='errormsg'])[1]")
	private WebElement errorMSG;
	
	@FindBy(xpath="(//nobr[contains(.,'actiTIME')])[1]")
	private WebElement version;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPage(String eTitle)
	{
		verifyTitle(eTitle);
	}
	
	public void enterUserName(String un)
	{
		userNameTB.sendKeys(un);
	}
	public void enterPassword(String pw)
	{
		passwordTB.sendKeys(pw);
	}
	public void clickOnLogin()
	{
		loginBTN.click();
	}
	
	public String verifyErrorMessage()
	{
		verifyElements(errorMSG);
		
		String aErrorMsg = errorMSG.getText();
		return aErrorMsg;
	}
	
	public String verfiyVersion()
	{
		verifyElements(version);
		String aVersion = version.getText();
		return aVersion;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
