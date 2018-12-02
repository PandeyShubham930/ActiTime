package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils 
{
	public static void getScreenshot(WebDriver driver, String name) 
	{
		TakesScreenshot t=(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(src, new File("./screenshot."+name+".png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void selectByIndex(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public static void selectByVisibleText(WebElement element, String vText)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(vText);
	}
	
	public static List<String> getOptions(WebElement element)
	{
		Select sel=new Select(element);
		List<WebElement> allOptions = sel.getOptions();
		List<String> allText=new ArrayList();
		for(WebElement options:allOptions)
		{
			String text = options.getText();
			allText.add(text);
		}
		return allText;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
