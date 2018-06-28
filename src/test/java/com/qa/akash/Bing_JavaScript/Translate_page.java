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
	WebElement webelement;
	JavascriptExecutor js;
	WebElement Xpath;
	String ExpectedUrl;
	Boolean boolean_condition;
	
	public Translate_page(WebDriver driver)
	{
		this.driver = driver;

		js = (JavascriptExecutor)driver;
	}
	
	public void main_page()
	{
		driver.get("https://www.bing.com/translator");
	}
	
	public void select_input_language()
	{
		// Select input language
		js.executeScript("document.querySelector('#t_sl').value= 'en'");
	}
	
	public void select_output_language()
	{
		// Select input language
		js.executeScript("document.querySelector('#t_tl').value= 'fr'");
	}
	
	public void translate() throws InterruptedException
	{
		//Enter input text
		select_input_language();
		select_output_language();
		webelement = driver.findElement(By.xpath("(//textarea)[1]"));
		js.executeScript("arguments[0].value = 'Hello Akash'", webelement);
		Thread.sleep(1000);
	}

	// Footer
	
	public void privacy_cookies() throws InterruptedException
	{
		webelement = driver.findElement(By.xpath("//a[@href='http://go.microsoft.com/fwlink/?LinkId=521839&CLCID=4009']"));
		js.executeScript("arguments[0].click();", webelement);
		ExpectedUrl = "https://privacy.microsoft.com/en-ca/privacystatement";
		Assert.assertEquals(ExpectedUrl, driver.getCurrentUrl());
		Thread.sleep(5000);
		main_page();
	}
	
	public void legal() throws InterruptedException
	{
		webelement = driver.findElement(By.xpath("//a[@href='http://go.microsoft.com/fwlink/?LinkID=246338&CLCID=4009']"));
		js.executeScript("arguments[0].click();", webelement);
		ExpectedUrl = "https://www.microsoft.com/en-in/servicesagreement/";
		Assert.assertEquals(ExpectedUrl, driver.getCurrentUrl());
		Thread.sleep(1000);
		main_page();
	}
	
	public void advertise() throws InterruptedException
	{
		webelement = driver.findElement(By.xpath("//a[@href='https://go.microsoft.com/fwlink/?linkid=868922']"));
		js.executeScript("arguments[0].click();", webelement);
		ExpectedUrl = "https://advertise.bingads.microsoft.com/en-us/h/a/signup-advertise?s_cid=US-Acq-DIG-src_Foot-sub_serp";
		Assert.assertEquals(ExpectedUrl, driver.getCurrentUrl());
		Thread.sleep(5000);
		main_page();
		
	}
	
	
	public void help() throws InterruptedException
	{
		webelement = driver.findElement(By.xpath("//a[@href='http://go.microsoft.com/fwlink/?LinkID=617297']"));
		js.executeScript("arguments[0].click();", webelement);
		ExpectedUrl = "http://help.bing.microsoft.com/#apex/18/en-US/n1999/-1/en-US";
		Assert.assertEquals(ExpectedUrl, driver.getCurrentUrl());
		Thread.sleep(5000);
		main_page();
	}
	
	public void feedback()
	{
		js.executeScript("document.getElementById('sb_feedback').click();");
		System.out.println("dsfs");
	}
	
	public void switchtab()
	{
		webelement = driver.findElement(By.xpath("//*[@id='t_revIcon']"));
		js.executeScript("arguments[0].click();", webelement);
	}
	
	
	
	

}
