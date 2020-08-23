package com.dev.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dev.verizon.base.BasePage;
import com.dev.verizon.page.HomePage;
import com.dev.verizon.page.SmartphonePage;


public class SmartphonePageTest extends SmartphonePage {
	public SmartphonePageTest(WebDriver driver) {
		super(driver);
		
	}
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	SmartphonePage smartphonePage;

@BeforeTest
public void setUp(){
	
	basePage = new BasePage();
	prop = basePage.init_properties();
	String browserName = prop.getProperty("browser");
	driver = basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
    homePage = new HomePage(driver);
	smartphonePage = new SmartphonePage(driver);
//	smartphonePage = homePage.hoverPhone();
	smartphonePage = new SmartphonePage(driver).Click();
}
@Test (priority = 1, description = "Smartphone Page Title = Smartphones - Buy The Newest Cell Phones | Verizon Wireless")
public void verifyHomePageTitle() {
String title = homePage.getHomePageTitle();
System.out.println("Homepage title is "+ title);
Assert.assertEquals(title, "Smartphones - Buy the newest cell phones | Verison Wireless");
//Thread.sleep(3000);
}

@Test (priority = 2, description = "Chooses the phone you like")
public void choosePhoneTest(){
	smartphonePage.choosePhone();
	
}
@AfterTest
public void tearDown(){
	driver.quit();

}
}
