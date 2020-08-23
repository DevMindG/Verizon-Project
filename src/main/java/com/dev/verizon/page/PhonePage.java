package com.dev.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dev.verizon.base.BasePage;
import com.dev.verizon.util.ElementUtil;


public class PhonePage extends BasePage {
	
 WebDriver driver;
 ElementUtil elementUtil;
 HomePage homePage;
 SmartphonePage smartphonePage;
 
 By color = By.id("#d7d7d7");
 By size = By.id("256GB");
 By price = By.id("pricingOption1");
 By continueBtn = By.id("ATC-Btn");
 By zipCode = By.id("zipcode");
 By confirmBtn = By.className("defaultPrimaryCTA");
 By newCustomer = By.className("marging8");
 By cartSign = By.xpath("//a[@class='cart-icon ']");
 By verifyMyPhone = By.xpath("//span[contains(text(),'iPhone 11 Pro Max')]");
 
 
public PhonePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		homePage = new HomePage(driver);
		smartphonePage = new SmartphonePage(driver);
	
}
public String getPhonePageTitle(){
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.titleIs("Apple iPhone 11 Pro Max: colors, Reviews, and dual camera | Buy Now"));
	return elementUtil.doGetPageTitle();
	
}
public CartPage selectPhone(){
	WebDriverWait wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.presenceOfElementLocated(color));
	
	elementUtil.clickOn(color);
	elementUtil.clickOn(size );
	elementUtil.clickOn(price);
	elementUtil.clickOn(continueBtn);
	
	wait.until(ExpectedConditions.presenceOfElementLocated(zipCode));
	elementUtil.clickOn(zipCode);
	
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(newCustomer));
	elementUtil.clickOn(newCustomer);
	
	return new CartPage(driver);
	
	
}

	
}
