package com.dev.verizon.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.dev.verizon.base.BasePage;
import com.dev.verizon.util.ElementUtil;

public class SmartphonePage  extends BasePage{
	
 WebDriver driver;
 HomePage homePage;
 ElementUtil elementUtil;
 
 By selectedPhone = By.xpath("//div[@class='phone-img col-xs-7']");
 By smartPhones=By.id("thirdLevel100");
 By choosenPhone = By.xpath("//a[aria-label='Apple Iphone 11']");  
 
 public SmartphonePage(WebDriver driver){
	 this.driver = driver;
	 homePage= new HomePage(driver);
	 elementUtil = new ElementUtil(driver);
	 
	
 }
 public void verifyTitle(){
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	String title=driver.getTitle();
	System.out.println("Title is "+ title);
	
 }
 public PhonePage choosePhone(){
	 JavascriptExecutor js = ((JavascriptExecutor)driver);
	 js.executeScript("scroll(0, 300);");
	 WebDriverWait wait = new WebDriverWait(driver, 20);
//	 wait.until(ExpectedConditions.presenceOfElementLocated(chosenPhone));
	 elementUtil.doClick(selectedPhone);
	 return new PhonePage(driver);
 }
public SmartphonePage Click() {
	return null;
}
 
}
