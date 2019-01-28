package com.mobile.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookingTest extends BaseTest {

	protected static final String DEPARTURE = "London";
	protected static final String DESTINATION = "Paris";

	@BeforeMethod
	public void clickOnBooking() {
		booking = menu.selectBookingOption();
	}

	@Test
	public void booking_flight() {
		booking.inputDeparture(DEPARTURE).inputDestination(DESTINATION).clickOnSearch().isSuccessOutbound();
	}
}
