package com.mobile.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StationTest extends BaseTest {

	protected static final String STATION = "Alexandria";

	@BeforeMethod
	public void clickOnStation() {
		station = menu.selectStationOption();
	}

	@Test
	public void search_station() {
		station.searchStation(STATION);
	}
}
