package com.qa.verizon.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;

	// Constructor
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 
	 * @return
	 */
	public String doGetPageTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting the title...");
		}
		return null;
	}

	public String doGetPageUrl() {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting URL...");
		}
		return null;
	}

	/**
	 * @author bobit this method is used to create the weblement on the basis of By
	 *         locator
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator)); // we cant locate title with presenceOfElement
		return driver.findElement(locator);
	}

	/**
	 * this method is used to click the weblement on the basis of By locator
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occured while clicking the web element...");
		}
	}

	/**
	 * this method is used to send value in a field
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		try {
			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception got occured while entering values in a field...");
		}
	}

	/**
	 * isDisplayed
	 * 
	 * @param locator
	 * @return
	 */
	public boolean doIsDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception got occured...");
		}
		return false;
	}

	/**
	 * isEnabled
	 * 
	 * @param locator
	 * @return
	 */
	public boolean doIsEnabled(By locator) {
		try {
			return getElement(locator).isEnabled();
		} catch (Exception e) {
			System.out.println("some exception got occured...");
		}
		return false;
	}

	/**
	 * isSeelcted
	 * 
	 * @param locator
	 * @return
	 */
	public boolean doIsSelected(By locator) {
		try {
			return getElement(locator).isSelected();
		} catch (Exception e) {
			System.out.println("some exception got occured...");
		}
		return false;
	}

	/**
	 * Gettext
	 * 
	 * @param locator
	 * @return
	 */
	public String doGetText(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting text...");
		}
		return null;

	}
}
