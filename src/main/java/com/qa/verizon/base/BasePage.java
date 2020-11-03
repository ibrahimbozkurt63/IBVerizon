package com.qa.verizon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	// this page defines our driver , properties

	 WebDriver driver;
	 Properties prop;

	public WebDriver initialize_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		System.out.println("Your browser is " +browserName);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.verizonwireless.com/");
		return driver;
	}

	/**
	 * 
	 * @return
	 */
	public Properties initialize_properties() {
		prop = new Properties();
		String path= "/Users/ibrahimbozkurt/eclipse-workspace/VerizonIB/src/main/java/com/qa/verizon/config/config.properties";
		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("Some issues with your config properties , please check your config file");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
