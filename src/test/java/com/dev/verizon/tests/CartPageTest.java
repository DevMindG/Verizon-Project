package com.dev.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.dev.verizon.base.BasePage;
import com.dev.verizon.page.CartPage;
import com.dev.verizon.page.HomePage;
import com.dev.verizon.page.PhonePage;
import com.dev.verizon.page.SmartphonePage;


public class CartPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	SmartphonePage smartphonePage;
	PhonePage phonePage;
	CartPage cartPage;
	
	@BeforeTest
	public void setup(){
		
	basePage = new BasePage();
	prop=basePage.init_properties();
	String browserName=prop.getProperty("browser");
	driver= basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	homePage= new HomePage(driver);
	smartphonePage=homePage.moveToPageElement();
	smartphonePage= new SmartphonePage(driver);
	phonePage = smartphonePage.choosePhone();
	phonePage = new PhonePage(driver);
	cartPage = phonePage.selectPhone();
	cartPage= new CartPage(driver);
	}
	
		

	}


