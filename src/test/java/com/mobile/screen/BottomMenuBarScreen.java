package com.mobile.screen;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BottomMenuBarScreen extends BaseScreen{


	public BottomMenuBarScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
