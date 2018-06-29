package com.qa.akash.Bing_JavaScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AppTest 
{
    WebDriver driver;
    Translate_page translate_page_object;
    Footer footer_page_object;
    
    public AppTest()
    {
    	driver = new ChromeDriver();
    	driver.get("https://www.bing.com/translator");
    	translate_page_object = new Translate_page(driver);
    	footer_page_object = new Footer(driver);
    }
    
    
    @Test
    public void Test1_translate_test() throws InterruptedException
    {
//    	Thread.sleep(3000);
    	translate_page_object.translate();
    	System.out.println("Test1 Executed");
    	//Assert.assertTrue(translate_page_object.boolean_condition);
    }
    
    
//    @Test
//    public void Test2_sound() throws InterruptedException
//    {
////    	Thread.sleep(3000);
//    	translate_page_object.sound();
//    	System.out.println("Test2 Executed");
//    }
    
    
    @Test
    public void Test3_voice_change_in() throws InterruptedException
    {
//    	Thread.sleep(3000);
    	translate_page_object.voice_change_in();
    	System.out.println("Test3 Executed");
    }
    
    @Test
    public void Test4_voice_change_out() throws InterruptedException
    {
//    	Thread.sleep(3000);
    	translate_page_object.voice_change_out();
    	System.out.println("Test4 Executed");
    }
    
    @Test
    public void Test5_copy_output() throws InterruptedException
    {
    	Thread.sleep(3000);
    	translate_page_object.copy_output();
    	System.out.println("Test5 Executed");
    }
    
    @Test
    public void Test6_share_output() throws InterruptedException
    {
    	Thread.sleep(3000);
    	translate_page_object.share_outptut();
    	System.out.println("Test6 Executed");
    }
    
    
    	
    @Test
    public void Test7_switchtab_test() throws InterruptedException
    {
    	Thread.sleep(3000);
    	translate_page_object.switchtab();
    	System.out.println("Test7 Executed");
    }
    
    @Test
    public void Test8_clearText() throws InterruptedException
    {
    	Thread.sleep(3000);
    	translate_page_object.clear_text();
    	System.out.println("Test8 Executed");
    }
    
    @Test
    public void Test9_wrong_language_input() throws InterruptedException
    {
    	Thread.sleep(3000);
    	translate_page_object.wrong_language_input();
    	System.out.println("Test9 Executed");
    }
    
    //Footer
//    @Test
//    public void Test11_Zcookie_test() throws InterruptedException
//    {
//    	footer_page_object.privacy_cookies();
//    	footer_page_object.legal();
//    	footer_page_object.advertise();
//    	footer_page_object.feedback();
//    	footer_page_object.help();
//    }
    
    

}
