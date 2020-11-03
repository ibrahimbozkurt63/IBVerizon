package com.qa.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.CartPage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.SecondPage;
import com.qa.verizon.util.ElementUtil;

public class CartPagetest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	SecondPage secondPage;
	CartPage cartPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		String browserName=prop.getProperty("browser");
		driver=basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		homePage=new HomePage(driver);
		secondPage=homePage.clickSmartPhones();
		cartPage=secondPage.selectYourPhone();
		Thread.sleep(3000);
	}
	@Test(priority=1, description="Verifiying the cart page title ", enabled=true)
	
	public void verifyCartPageTitleTest() {
		String title =cartPage.getCartPageTitle();
		System.out.println("Your cart page title is " +title);
		Assert.assertEquals(title, "Verizon | Shopping Cart");
	}
	@Test (priority=2, description="Get Second Page Url ", enabled=true)
	public void verifCartPageUrl () throws InterruptedException {
		String url=cartPage.getCartPageUrl();
		System.out.println("CartPage url is " +url);
		Assert.assertEquals(url,("https://www.verizon.com/onedp/cart#/"));
	}
	
	@Test (priority=3, description="Customizing your phone ", enabled=true)
	public CartPage customizingMoto () throws InterruptedException {
	 secondPage.selectYourPhone();
		return new CartPage(driver);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
	
	
			
