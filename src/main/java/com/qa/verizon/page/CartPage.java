package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class CartPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	
	//Locators 
	
	
	By secondaryPro=By.xpath("//*[@id=\"declineProtectionOverlay\"]/div/div[1]/div[2]/button[2]");
	By selectPlan= By.id("select-plan-list-view-39385");
	By checkOut=By.xpath("/html/body/div[4]/div/div[1]/div[2]/div[2]/div/div[24]/div/div[1]/div[1]/button");
	
	
	// Constructor
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
	elementUtil=new ElementUtil(driver);
	
	}
	public String getCartPageTitle() {
		String title = driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("motorola one 5G UW: Features, Price & Reviews | Verizon"));
		return title;
	}
	
	public String getCartPageUrl() throws InterruptedException {
		Thread.sleep(3000);
		return elementUtil.doGetPageUrl();
	}
	// https://www.verizon.com/smartphones/motorola-one-5g-uw/

	public void addToCart () throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(secondaryPro).click();
		Thread.sleep(5000);
		driver.findElement(selectPlan).click();
		Thread.sleep(5000);
		driver.findElement(checkOut).click();
		
		
	}
}

