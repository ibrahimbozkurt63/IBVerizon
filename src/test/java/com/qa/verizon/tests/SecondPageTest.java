package com.qa.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.CartPage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.SecondPage;


public class SecondPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	SecondPage secondPage;
	
	
	

	@BeforeMethod
	public void setUp() throws InterruptedException {
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		String browserName=prop.getProperty("browser");
		driver=basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		homePage=new HomePage(driver);
		secondPage=homePage.clickSmartPhones();
		Thread.sleep(3000);
	}
	@Test(priority=1, description="Verifiying the second page title ", enabled=true)
	
	public void verifySecondPageTitleTest() {
		String title =secondPage.getSecondPageTitle();
		System.out.println("Your second page title is " +title);
		Assert.assertEquals(title, "Smartphones - Buy The Top Cell Phones | Verizon");
	}
//	@Test (priority=2, description="Get Second Page Url ", enabled=true)
//	public void verifSecondPageUrl () throws InterruptedException {
//		String url=secondPage.getSecondPageUrl();
//		System.out.println("Secondpage url is " +url);
//		Assert.assertEquals(url,("https://www.verizon.com/smartphones/?adobe_mc=MCMID%3D03023023560605351722428291172596571971%7CMCORGID%3D843F02BE53271A1A0A490D4C%2540AdobeOrg%7CTS%3D1603204043&mboxSession=857e436997a740d48d4848250d6f5232"));
//	}
	
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

