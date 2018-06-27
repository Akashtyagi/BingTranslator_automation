package com.qa.akash.Bing_JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Translate_page 
{
	WebDriver driver;
	WebElement input_text_field;
	JavascriptExecutor js;
	
	public Translate_page(WebDriver driver)
	{
		this.driver = driver;

		js = (JavascriptExecutor)driver;
	}
	
	public void test()
	{
		// Select input language
		js.executeScript("document.querySelector('#t_sl').value= 'en'");
		
		//Enter input text
		//input_text_field = driver.findElement(By.xpath())
	}

	

}
