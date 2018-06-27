package com.qa.akash.Bing_JavaScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class AppTest 
{
    WebDriver driver;
    Translate_page translate_page_object;
    
    public AppTest()
    {
    	driver = new ChromeDriver();
    	driver.get("https://www.bing.com/translator");
    }
    
    @Test
    public void click_test()
    {
    	translate_page_object = new Translate_page(driver);
    	translate_page_object.test();
    }
    
    

}
