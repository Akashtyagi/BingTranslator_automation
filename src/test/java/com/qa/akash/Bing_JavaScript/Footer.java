package com.qa.akash.Bing_JavaScript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Footer 
{

	
	WebDriver driver;
	JavascriptExecutor js;
	WebElement Xpath;
	String ExpectedUrl;
	Boolean boolean_condition;
	WebElement webelement;
	WebElement textarea;
	WebElement switchtab;
	WebElement cleartext;
	WebElement privacy_cookies;
	WebElement legal;
	WebElement advertise;
	WebElement help;
	WebElement feedback;
	WebElement suggestion;
	
	
	public Footer(WebDriver driver)
	{
		this.driver = driver;

		js = (JavascriptExecutor)driver;
	}
	
	public void main_page()
	{
		driver.get("https://www.bing.com/translator");
	}
	
	public void privacy_cookies() throws InterruptedException
	{
	privacy_cookies = driver.findElement(By.xpath("//a[@href='http://go.microsoft.com/fwlink/?LinkId=521839&CLCID=4009']"));
	js.executeScript("arguments[0].click();", privacy_cookies);
	ExpectedUrl = "https://privacy.microsoft.com/en-ca/privacystatement";
	Assert.assertEquals(ExpectedUrl, driver.getCurrentUrl());
	System.out.println("	Privacy and cookie page works");
	Thread.sleep(5000);
	main_page();
	}

	public void legal() throws InterruptedException
	{
	legal = driver.findElement(By.xpath("//a[@href='http://go.microsoft.com/fwlink/?LinkID=246338&CLCID=4009']"));
	js.executeScript("arguments[0].click();", legal);
	ExpectedUrl = "https://www.microsoft.com/en-in/servicesagreement/";
	Assert.assertEquals(ExpectedUrl, driver.getCurrentUrl());
	System.out.println("	Legal page works");
	Thread.sleep(1000);
	main_page();
	}

	public void advertise() throws InterruptedException
	{
	advertise = driver.findElement(By.xpath("//a[@href='https://go.microsoft.com/fwlink/?linkid=868922']"));
	js.executeScript("arguments[0].click();", advertise);
	ExpectedUrl = "https://advertise.bingads.microsoft.com/en-us/h/a/signup-advertise?s_cid=US-Acq-DIG-src_Foot-sub_serp";
	Assert.assertEquals(ExpectedUrl, driver.getCurrentUrl());
	System.out.println("	Advertise page works");
	Thread.sleep(5000);
	main_page();

	}

	public void feedback() throws InterruptedException
	{
		Thread.sleep(500);
		js.executeScript("document.getElementById('sb_feedback').click();");
		Thread.sleep(1000);
		feedback = driver.findElement(By.xpath("//*[@id=\"fbpgdg\"]"));
		System.out.println("sdf "+feedback);
		main_page();
	}
	
	public void help() throws InterruptedException
	{
		help = driver.findElement(By.xpath("//a[@href='http://go.microsoft.com/fwlink/?LinkID=617297']"));
		js.executeScript("arguments[0].click();", help);
		ExpectedUrl = "http://help.bing.microsoft.com/#apex/18/en-US/n1999/-1/en-US";
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		Assert.assertEquals(ExpectedUrl, driver.getCurrentUrl());
		System.out.println("	Help page works");
//		Thread.sleep(5000);
		main_page();
	}
	
}
