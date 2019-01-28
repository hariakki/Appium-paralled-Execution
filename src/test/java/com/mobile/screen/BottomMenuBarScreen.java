package com.mobile.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BottomMenuBarScreen extends BaseScreen {

	public BottomMenuBarScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.flixbus.app:id/action_booking\")")
	private MobileElement bookingOption;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.flixbus.app:id/action_stations\")")
	private MobileElement stationOption;

	public BookingScreen selectBookingOption() {
		clickOn(bookingOption);
		return new BookingScreen(driver);
	}

	public StationScreen selectStationOption() {
		clickOn(stationOption);
		return new StationScreen(driver);
	}
}
