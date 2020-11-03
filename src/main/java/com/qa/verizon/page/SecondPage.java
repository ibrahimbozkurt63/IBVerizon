package com.qa.verizon.page;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class SecondPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	
	// Locators 
	
	
	By price=By.xpath("//div[contains(text(),'Retail price')]");
	By continueBtn=By.id("ATC-Btn");
	By confirmLocation=By.xpath("/html/body/div[7]/div/div/div[2]/div/form/button");
	By newCostumer=By.xpath("/html/body/div[14]/div/div/div[2]/div/div/div/div/div/button");
	By next=By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div[3]/div[2]/div[7]/div/button");
	By noTrade=By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div[3]/div[2]/div[9]/div/div/div/div/div[2]/div/button/p");
	By noDevicePro=By.id("declineDeviceSelectProtecionBtn");
	
	// 2- Constructor
	
	
		public SecondPage(WebDriver driver) {
			this.driver=driver;
		elementUtil=new ElementUtil(driver);
		
		}


		// My Methods 
		public String getSecondPageTitle() {
			String title = driver.getTitle();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.titleContains("Smartphones - Buy The Top Cell Phones | Verizon"));
			return title;
		}
		
		public String getSecondPageUrl() throws InterruptedException {
			Thread.sleep(3000);
			return elementUtil.doGetPageUrl();
		}

		public   CartPage selectYourPhone() throws InterruptedException {
			driver.findElement(price).click();
			Thread.sleep(2000);
			driver.findElement(continueBtn).click();
			Thread.sleep(2000);
			driver.findElement(confirmLocation).click();
			Thread.sleep(2000);
			driver.findElement(newCostumer).click();
			Thread.sleep(3000);
			driver.findElement(next).click();
			Thread.sleep(3000);
			driver.findElement(noTrade).click();
			Thread.sleep(3000);
			driver.findElement(noDevicePro).click();
			return new CartPage(driver);
		}
}