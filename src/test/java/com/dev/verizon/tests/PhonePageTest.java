package com.dev.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dev.verizon.base.BasePage;
import com.dev.verizon.page.HomePage;
import com.dev.verizon.page.PhonePage;


@Test
public class PhonePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	PhonePage phonePage;
 	
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName=prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		phonePage = new PhonePage(driver);
	//	phonePage = homePage.hoverPhones();
	//	phonePage = homePage.phonesClick();
	}
	@Test (priority = 2)
	public void hoverPhones(){
		phonePage.selectPhone();
	}
	public void verifyTitle(){
		String title = phonePage.getPhonePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "smartPhone");
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
