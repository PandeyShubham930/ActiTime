package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BasePage;

public class EnterTimeTrackPage extends BasePage
{
	
	//Decalaration
	@FindBy(id="logoutLink")
	private WebElement logoutBTN;
	
	@FindBy(xpath="//div[@class='popup_menu_button popup_menu_button_support']")
	private WebElement help; 
	
	@FindBy(xpath="//a[.='About your actiTIME']")
	private WebElement aboutYourActiTime;
	
	@FindBy(xpath="//span[.='(build 40469)']")
	private WebElement buildNumber;
	
	//Initialization
	public EnterTimeTrackPage(WebDriver driver) 
	{
		super(driver);	
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public void verifyPage(String eTitle)
	{
		verifyPage(eTitle);
	}
	
	public void clickOnHelp()
	{
		help.click();
	}
	
	public void aboutActiTime()
	{
		aboutYourActiTime.click();
	}
	
	public void verifyBuildNumber()
	{
		verifyElements(buildNumber);
	}
	
	public void clickOnLogout() 
	{
		logoutBTN.click();
	}
}
