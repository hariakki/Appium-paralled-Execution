package com.mobile.screen;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OutboundScreen extends BaseScreen {

	public OutboundScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.flixbus.app:id/cpdv_button\")")
	private MobileElement buttonBuy;

	public boolean isSuccessOutbound() {
		return isVisible(buttonBuy);
	}
	
}
