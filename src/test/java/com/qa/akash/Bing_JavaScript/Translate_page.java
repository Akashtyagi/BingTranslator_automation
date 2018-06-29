package com.qa.akash.Bing_JavaScript;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.w3c.dom.xpath.XPathResult;

public class Translate_page 
{
	WebDriver driver;
	JavascriptExecutor js;
	WebElement webelement;
	String ExpectedUrl;
	Boolean boolean_condition;
	WebElement textarea;
	WebElement switchtab;
	WebElement cleartext;
	WebElement privacy_cookies;
	WebElement legal;
	WebElement advertise;
	WebElement help;
	WebElement feedback;
	WebElement suggestion;
	
	public Translate_page(WebDriver driver)
	{
		this.driver = driver;

		js = (JavascriptExecutor)driver;
	}
	
	
	public void main_page()
	{
		driver.get("https://www.bing.com/translator");
	}
	
	
	public void select_input_language() throws InterruptedException		// Assert error
	{
//		Thread.sleep(3000);
		js.executeScript("document.querySelector('#t_sl').value= 'en'");
	}
	
	
	public void select_output_language() throws InterruptedException		// Assert error
	{
//		Thread.sleep(3000);
		js.executeScript("document.querySelector('#t_tl').value= 'fr'");
	}
	
	
	public void translate() throws InterruptedException
	{
		select_input_language();		// Input text language.
		select_output_language();		// Output text language.
		textarea = driver.findElement(By.xpath("(//textarea)[1]"));
		js.executeScript("arguments[0].value = 'Hello Akash'", textarea);	
		
//		suggestion = driver.findElement(By.xpath("  //*[@id='t_asc']"));
//		boolean_condition = suggestion.isDisplayed();
//		System.out.println("suugestion "+boolean_condition);// Input Text
		//boolean_condition = driver.findElement(By.xpath("//textarea[@placeholder='Enter text or webpage URL here']"))boolean_condition;
		//System.out.println("Hello 1"+boolean_condition);
		//Thread.sleep(1000);
	}
	
	public void voice_change_in() throws InterruptedException
	{
		webelement = driver.findElement(By.xpath("//*[@id='t_inauoption']"));
		js.executeScript("arguments[0].click();", webelement);
		webelement = driver.findElement(By.xpath("//*[@id='t_genradio_M_0']"));
		js.executeScript("arguments[0].checked = true",webelement);							// Change radio button to Male
		js.executeScript("document.querySelector('select#t_dropsel_0').value='en-CA'");		// Change pronunciation lang
	}
	
	public void voice_change_out() throws InterruptedException
	{
		webelement = driver.findElement(By.xpath("//*[@id='t_outauoption']"));
		js.executeScript("arguments[0].click();", webelement);
		webelement = driver.findElement(By.xpath("//*[@id='t_genradio_M_0']"));		
		js.executeScript("arguments[0].checked = true",webelement);							// Change radio button to Male
		js.executeScript("document.querySelector('select#t_dropsel_1').value='fr-CA'");		// Change pronunciation lang
	}
	
	
	
	// SWITCH TAB
	public void switchtab()		// Assert error
	{
		switchtab = driver.findElement(By.xpath("//*[@id='t_revIcon']"));
		js.executeScript("arguments[0].click();", switchtab);
		//Assert.assertTrue(condition);
	}
	
	public void sound() throws InterruptedException		// ERROR - click not working
	{
		webelement = driver.findElement(By.xpath("//*[@id='t_srcplaycIcon']"));
		System.out.println(webelement);
		js.executeScript("arguments[0].click();", webelement);
		//boolean_condition = driver.findElement(By.xpath("//textarea[@placeholder='Enter text or webpage URL here']")).isDisplayed();
		//System.out.println("Hello "+boolean_condition);
	}
	
	public void copy_output() throws InterruptedException
	{
		webelement = driver.findElement(By.xpath("//*[@id='t_copyIcon']"));
		js.executeScript("arguments[0].click();", webelement);
	}
	
	public void share_outptut() throws InterruptedException
	{
		webelement = driver.findElement(By.xpath("//*[@class='actIconSvg actShareSvgIcon']"));
		js.executeScript("arguments[0].click();", webelement);
	}
	
	public void clear_text() throws InterruptedException		// Assert error
	{
		cleartext = driver.findElement(By.xpath("//*[@id='t_edc']"));
		js.executeScript("arguments[0].click();", cleartext);
		//boolean_condition = driver.findElement(By.xpath("//textarea[@placeholder='Enter text or webpage URL here']")).isDisplayed();
		//System.out.println("Hello "+boolean_condition);
	}
	
	public void wrong_language_input() throws InterruptedException 		// Not giving Suggestion
	{
		select_input_language();
		select_output_language();
		textarea = driver.findElement(By.xpath("(//textarea)[1]"));
		js.executeScript("arguments[0].value = 'Bonjour'", textarea);		// Input Text
		Thread.sleep(100);
		suggestion = driver.findElement(By.xpath("  //*[@id='t_asc']"));
		boolean_condition = suggestion.isDisplayed();
		System.out.println("suugestion "+boolean_condition);
	}
	
	
	
	
	
	
	
	
	
	

}
