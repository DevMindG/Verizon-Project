package com.dev.verizon.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dev.verizon.base.BasePage;
import com.dev.verizon.util.ElementUtil;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//locator
	By shop = By.id("gnav20-Shop-L1");
	By smartphones = By.id("secondLeve10");
	By smartPhonesList = By.id("thirdLevel100");
	
	//Actions which is same as methods
	public HomePage(WebDriver driver){
	    this.driver = driver;
	    elementUtil = new ElementUtil(driver);
	}
	
	public String getHomePageTitle(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return elementUtil.doGetPageTitle();
	}
	  
	public void hoverPhone(){
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.textToBe(smartphones, "Shop"));
	//WebElement smartPhoneList = driver.findElement(smartphones);
	elementUtil.doClick(smartphones);
	
	
}

	public SmartphonePage moveToPageElement() {
	WebElement smartElement=driver.findElement(By.id("third100"));
		return null;
	}
}