package com.qa.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;

public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		String browserName=prop.getProperty("browser");
		driver=basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		homePage=new HomePage(driver);
	}
	
	@Test(priority=1, description="Verifiying the homepage title ", enabled=true)
	
	public void verifyHomePageTitleTest() {
		String title =homePage.getPageTitle();
		System.out.println("Your page title is " +title);
		Assert.assertEquals(title, "Verizon: Wireless, Internet, TV and Phone Services | Official Site");
	}
	@Test (priority=2, description="Get Home Page Url ", enabled=true)
	public void verifyUrl () {
		String url=homePage.getPageUrl();
		System.out.println("Homepage url is " +url);
		Assert.assertEquals(url, "https://www.verizon.com/");
	}
	
	@Test (priority=3, description="Click Shopping and smartphone links ", enabled=true)
	public void clickingSmartphone () throws InterruptedException {
		homePage.clickSmartPhones();
	}
	
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
}
