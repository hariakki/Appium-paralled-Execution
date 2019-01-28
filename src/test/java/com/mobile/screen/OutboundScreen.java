package com.mobile.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OutboundScreen extends BaseScreen {

	public OutboundScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.flixbus.app:id/cpdv_button\")")
	private MobileElement buttonBuy;

	public boolean isSuccessOutbound() {
		return isVisible(buttonBuy);
	}
}
