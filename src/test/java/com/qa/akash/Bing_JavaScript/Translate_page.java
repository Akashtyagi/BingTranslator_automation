package com.qa.akash.Bing_JavaScript;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.w3c.dom.xpath.XPathResult;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

public class Translate_page 
{
	WebDriver driver;
	JavascriptExecutor js;
	WebElement webelement;
	String pronunciation_language;
	String ExpectedUrl;
	String inputtext;
	String OutputText;
	String inputlanguage;
	String outputlanguage;
	String copytext;
	Boolean boolean_condition;
	WebElement sharebutton;
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
		js.executeScript("document.querySelector('#t_sl').value= 'en'");
		inputlanguage = js.executeScript("return document.querySelector('#t_sl').value").toString();
		Assert.assertEquals(inputlanguage, "en");
		System.out.println("	Input language selected - 'English '");
	}
	
	
	public void select_output_language() throws InterruptedException		// Assert error
	{
		js.executeScript("document.querySelector('#t_tl').value= 'fr'");
		outputlanguage = js.executeScript("return document.querySelector('#t_tl').value").toString();
		Assert.assertEquals(outputlanguage, "fr");
		System.out.println("	Output language selected - 'French '");
	}
	
	
	public void translate() throws InterruptedException
	{
		select_input_language();		// Input text language.
		select_output_language();		// Output text language.
		textarea = driver.findElement(By.xpath("(//textarea)[1]"));
//		js.executeScript("arguments[0].value = 'Hello Human'", textarea);
		textarea.sendKeys("Hello Human");
		
		Thread.sleep(5000);
		
		inputtext = js.executeScript("return document.getElementById('t_sv').value").toString();
		Assert.assertEquals(inputtext, "Hello Human");			// Input Text Assert
		OutputText = js.executeScript("return document.getElementById('t_tv').value").toString();
		Assert.assertEquals(OutputText, "Bonjour l'homme");		// Output Text Assert
		
		System.out.println("	Hello Human(English) translated to 'Bonjour l'homme'(French)");
	}
	
	public void voice_change_in() throws InterruptedException
	{
		Thread.sleep(1000);
		webelement = driver.findElement(By.xpath("//*[@id='t_inauoption']"));
		js.executeScript("arguments[0].click();", webelement);
		webelement = driver.findElement(By.xpath("//*[@id='t_genradio_M_0']"));
		js.executeScript("arguments[0].checked = true",webelement);							// Change radio button to Male
		js.executeScript("document.querySelector('select#t_dropsel_0').value='en-CA'");		// Change pronunciation lang
		
		
											//Assert
		
		//Gender is changed
		boolean_condition = driver.findElement(By.xpath("//*[@id='t_genradio_M_0']")).isEnabled();
		Assert.assertTrue(boolean_condition);
		System.out.println("	The gender of the Input voice is changed to 'Male");
		
		//Pronunciation is changed
		pronunciation_language = js.executeScript("return document.querySelector('select#t_dropsel_0').value='en-CA'").toString();
		Assert.assertEquals(pronunciation_language, "en-CA");
		System.out.println("	Input pronunciation_language is changed to English Canada ");
	}
	
	public void voice_change_out() throws InterruptedException
	{
		webelement = driver.findElement(By.xpath("//*[@id='t_outauoption']"));
		js.executeScript("arguments[0].click();", webelement);
		webelement = driver.findElement(By.xpath("//*[@id='t_genradio_M_0']"));		
		js.executeScript("arguments[0].checked = true",webelement);							// Change radio button to Male
		js.executeScript("document.querySelector('select#t_dropsel_1').value='fr-CA'");		// Change pronunciation lang
		
//		//Assert

		//Pronunciation is changed
		pronunciation_language = js.executeScript("return document.querySelector('select#t_dropsel_1').value='fr-CA'").toString();
		Assert.assertEquals(pronunciation_language, "fr-CA");
		System.out.println("	Input pronunciation_language is changed to French Canada ");
	}
	
	
	
	// SWITCH TAB
	public void switchtab() throws InterruptedException		// Assert error
	{
		switchtab = driver.findElement(By.xpath("//*[@id='t_revIcon']"));
		js.executeScript("arguments[0].click();", switchtab);
		Assert.assertTrue(js.executeScript("return document.querySelector('#t_sl').value").equals("fr"));
		System.out.println("	The input and output language and text has been interchanged.");
	}
	
	public void sound() throws InterruptedException		// ERROR - click not working
	{
		Thread.sleep(1000);
		RemoteWebElement sound_element = (RemoteWebElement) js.executeScript("return document.querySelector('#t_tarplaycIcon')");
		sound_element.click();
		Thread.sleep(500);
		RemoteWebElement soundclick_element = (RemoteWebElement) js.executeScript("return document.querySelector('#t_tarplaycIcon.audio.audiofocus')");
		Assert.assertTrue(soundclick_element.isDisplayed());
		System.out.println("	The sound button has been clicked.");
	}
	
	public void copy_output() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.id("t_copyIcon")).click();
		
		// Assert
		copytext = js.executeScript("return document.getElementById('copy_result').innerText").toString();	
		Assert.assertEquals(copytext, "Copied!");
		System.out.println("	The output has been copied");
	}
	
	public void share_outptut() throws InterruptedException
	{
		sharebutton = driver.findElement(By.xpath("//*[@class='actIconSvg actShareSvgIcon']"));
		js.executeScript("arguments[0].click();", sharebutton);
		String share = driver.findElement(By.className("shareactionexp")).getAttribute("aria-expanded");
		Assert.assertEquals(share,"true");
		System.out.println("	Share button is working properly");
	}
	
	public void clear_text() throws InterruptedException		// Assert error
	{
		cleartext = driver.findElement(By.xpath("//*[@id='t_edc']"));
		js.executeScript("arguments[0].click();", cleartext);
		Assert.assertEquals(inputtext = js.executeScript("return document.getElementById('t_sv').value").toString(),"");
		System.out.println("	The text has been cleared");
	}
	
	public void wrong_language_input() throws InterruptedException 		// Not giving Suggestion
	{
		js.executeScript("document.querySelector('#t_sl').value= 'nl'");
		js.executeScript("document.querySelector('#t_tl').value= 'fr'");
		textarea = driver.findElement(By.xpath("(//textarea)[1]"));
		js.executeScript("arguments[0].value = 'hello'", textarea);		// Input Text
		Thread.sleep(100);
		webelement = driver.findElement(By.id("t_as"));
	}
	
	
	
	
	
	
	
	
	
	

}
