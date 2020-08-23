package com.dev.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.dev.verizon.base.BasePage;
import com.dev.verizon.util.ElementUtil;


public class CartPage extends BasePage{

	
		WebDriver driver;
		ElementUtil elementUtil;
		HomePage homePage;
		SmartphonePage smartphonePage;
		PhonePage phonePage;
		String title = ("Apple iPhone 11 Pro Max: colors, Reviews, and more | Buy Now");
				
		By cartSign = By.xpath("//a[@class='cart-ion ']");
		By cart = By.id("navCartCircle");
		By phoneSelected = By.xpath("//span[contains(text(),'iphone 11')");
				
		public CartPage(WebDriver driver) {
			this.driver=driver;
			elementUtil = new ElementUtil(driver);
			homePage = new HomePage(driver);
			smartphonePage = new SmartphonePage(driver);
			phonePage= new PhonePage(driver);
			
		}
		public void clickOnCartSign(){
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cartSign));
			elementUtil.clickOn(cartSign);
		}
		public String getTitle() {
			return elementUtil.doGetPageTitle();
		}
		public void verifyChosenPhone() {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(phoneSelected));
			elementUtil.doGetText(phoneSelected);
			
			
		}
	
	}


