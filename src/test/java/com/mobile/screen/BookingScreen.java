package com.mobile.screen;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BookingScreen extends BaseScreen {

	public BookingScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.flixbus.app:id/vsp_from\")")
	private MobileElement inputDeparture;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.flixbus.app:id/vsp_to\")")
	private MobileElement inputDestination;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.flixbus.app:id/search_src_text\")")
	private MobileElement searchDeparture;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.flixbus.app:id/ia_container\")")
	private List<MobileElement> listSearch;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.flixbus.app:id/ia_country_name\")")
	private MobileElement searchResultCountryName;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.flixbus.app:id/fb_search_for_ride\")")
	private MobileElement btnSearch;

	public OutboundScreen clickOnSearch() {

		clickOn(btnSearch);
		return new OutboundScreen(driver);
	}

	public BookingScreen inputDeparture(String departureValue) {
		clickOn(inputDeparture);
		searchOnList(departureValue);
		return this;
	}

	public BookingScreen inputDestination(String destinationValue) {
		clickOn(inputDestination);
		searchOnList(destinationValue);
		return this;
	}

	public void searchOnList(String value) {
		sendValue(searchDeparture, value);
		waitForElementClickable(searchResultCountryName);
		findElement(value);
		clickOn(listSearch.get(0));
	}
}
