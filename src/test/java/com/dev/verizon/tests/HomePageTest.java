package com.dev.verizon.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.dev.verizon.base.BasePage;
import com.dev.verizon.page.HomePage;

public class HomePageTest {
 WebDriver driver;
 BasePage basePage;
 Properties prop;
 HomePage homePage;
 
 @BeforeMethod
 public void setUp(){
	 basePage = new BasePage();
	 prop = basePage.init_properties();
	 String browserName = prop.getProperty("browser");
	 driver = basePage.init_driver(browserName);
	 driver.get(prop.getProperty("url"));
	 homePage = new HomePage(driver);
 }
 
 @Test(priority=1, description="Verify the title")
 public void verifyHomePageTitle(){
	 String title = homePage.getHomePageTitle();
	 System.out.println(title);
	 AssertJUnit.assertEquals(title, "Verizon: Wireless, Internet, TV and Phones Services | Official Sites");
 }
 @Test(priority =3, description = ("hover over smart phones"))
 public void hoverPhones(){
	 homePage.moveToPageElement();
 }
 @Test(priority=2, description = "Click the Phones")
 public void phonesClick(){
	 homePage.hoverPhone();
 }
 @AfterMethod
 public void tearDown(){
	 driver.quit();
 }
 
 
}
