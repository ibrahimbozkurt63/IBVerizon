package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.JavaScriptUtil;

public class HomePage extends BasePage {

	// We will create methods ,constructors to verify our homepage information.
	WebDriver driver;
	
	//1- Locators 
	By shopButton=By.id("gnav20-Shop-L1");
	By smartPhoneButton= By.id("gnav20-Shop-L3-1");
	By SelectYourPhone=By.xpath("//body/div[@id='content']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]");
	// 2- Constructor
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	
	}
	
	//3-Methods 
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public SecondPage clickSmartPhones() throws InterruptedException {
		WebElement shopping =driver.findElement(shopButton);
		Actions actions=new Actions(driver);
		actions.moveToElement(shopping);
		WebElement smartPhones=driver.findElement(smartPhoneButton);
		actions.moveToElement(smartPhones);
		actions.click().build().perform();
		Thread.sleep(6000);
		driver.findElement(SelectYourPhone).click();
		
		return new SecondPage(driver);
	}

}
