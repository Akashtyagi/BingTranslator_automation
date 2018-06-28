package com.qa.akash.Bing_JavaScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AppTest 
{
    WebDriver driver;
    Translate_page translate_page_object;
    
    public AppTest()
    {
    	driver = new ChromeDriver();
    	driver.get("https://www.bing.com/translator");
    	translate_page_object = new Translate_page(driver);
    }
    
    
    @Test
    public void Test1_translate_test() throws InterruptedException
    {
    	translate_page_object.translate();
    	//Assert.assertTrue(translate_page_object.boolean_condition);
    }
    
    @Test
    public void Test2_switchtab_test()
    {
    	translate_page_object.switchtab();
    	
    	
    }
    
    //Footer
    @Test
    public void Test2_cookie_test() throws InterruptedException
    {
    	translate_page_object.privacy_cookies();
    	translate_page_object.legal();
    	translate_page_object.advertise();
    	translate_page_object.help();
    	translate_page_object.feedback();
    }
    
    

}
