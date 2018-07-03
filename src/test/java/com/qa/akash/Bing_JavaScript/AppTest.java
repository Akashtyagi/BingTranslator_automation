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
    	driver.manage().window().maximize();
    }
    
    
    @Test
    public void Test01_translate_test() throws InterruptedException
    {
    	translate_page_object.translate();
    	System.out.println("TEST1 Executed - Translation test");
    }
    
    
    @Test
    public void Test02_sound() throws InterruptedException
    {
    	translate_page_object.sound();
    	System.out.println("TEST2 Executed - Test Sound");
    }
    
    
    @Test
    public void Test03_voice_change_in() throws InterruptedException
    {
    	translate_page_object.voice_change_in();
    	System.out.println("TEST3 Executed - Input voice change");
    }
    
    @Test
    public void Test04_voice_change_out() throws InterruptedException
    {
    	translate_page_object.voice_change_out();
    	System.out.println("TEST4 Executed - Output voice change");
    }
    
    @Test
    public void Test05_copy_output() throws InterruptedException
    {
    	
    	translate_page_object.copy_output();
    	System.out.println("Test5 Executed");
    }
    
    @Test
    public void Test06_share_output() throws InterruptedException
    {
    	Thread.sleep(3000);
    	translate_page_object.share_outptut();
    	System.out.println("Test6 Executed - Share Output");
    }
    
    	
    @Test
    public void Test07_switchtab_test() throws InterruptedException
    {
    	Thread.sleep(3000);
    	translate_page_object.switchtab();
    	System.out.println("Test7 Executed - Switch Tab");
    }
    
    @Test
    public void Test08_clearText() throws InterruptedException
    {
    	Thread.sleep(3000);
    	translate_page_object.clear_text();
    	System.out.println("Test8 Executed - Clear Text");
    }
    
    @Test
    public void Test09_wrong_language_input() throws InterruptedException
    {
    	translate_page_object.wrong_language_input();
    	System.out.println("Test9 Executed - Suggestion");
    }
    
    //Footer
    @Test
    public void Test_footer_test() throws InterruptedException
    {
    	footer_page_object.privacy_cookies();
    	footer_page_object.legal();
    	footer_page_object.advertise();
    	footer_page_object.feedback();
    	footer_page_object.help();
    	System.out.println("Test10 Executed - Footers");
    }
    
    

}
