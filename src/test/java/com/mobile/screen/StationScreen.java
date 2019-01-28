package com.mobile.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class StationScreen extends BaseScreen {

	public StationScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public void searchStation(String station) {
		scrollToExactElementForAndroid(station);
	}

}
