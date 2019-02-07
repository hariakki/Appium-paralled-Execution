package com.mobile.screen;

import java.util.logging.Logger;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseScreen {
	
	private static final int MAX_TIMEOUT = 60;
	protected AppiumDriver<MobileElement> driver;
	protected String platform;
	protected boolean isAndroid;
	private WebDriverWait wait;
	
	public BaseScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, MAX_TIMEOUT);
		this.isAndroid = "android".equalsIgnoreCase(platform);
	}
	
	/**
	 * Search for an element in Android app
	 * @param value
	 */
	public void findElement(String value) {
		driver.findElement(MobileBy.AndroidUIAutomator(
                String.format("new UiSelector().instance(1).textContains(\"%s\")", value)));
	}
	
	/**
	 * Wait the element to be visible and send the value parameter for this element
	 * Timeout default is 15s
	 * @param element
	 * @param value
	 */
	protected void sendValue(MobileElement element, CharSequence value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}
	
	/**
	 * This method click on element in screen
	 * @param element
	 */
	protected void clickOn(MobileElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	/**
	 * Wait the element to be Clickable
	 * Timeout default is 15s
	 * @param element
	 * @return
	 */
	public boolean waitForElementClickable(MobileElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
	
	/**
	 * Check if all elements are visible on screen, in case one of them is not visible the method will return false
	 * @param elements
	 * @return boolean
	 */
	protected boolean isVisible(MobileElement ...elements ) {
		for (MobileElement element : elements) {
			wait.until(ExpectedConditions.visibilityOf(element));
			if (!element.isDisplayed()) {
				Logger.getGlobal().info("Element not visible: ".concat(element.getId()));
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Scroll the screen to element with the exact value
	 * @param value
	 */
	public void scrollToExactElementForAndroid(String value) {
		((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ value + "\").instance(0))");
	}
}
