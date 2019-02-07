package com.mobile.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.mobile.factory.DriverFactory;
import com.mobile.screen.BookingScreen;
import com.mobile.screen.BottomMenuBarScreen;
import com.mobile.screen.StationScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTest {

	protected static AppiumDriver<MobileElement> driver;
	protected BottomMenuBarScreen menu;
	protected BookingScreen booking;
	protected StationScreen station;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "deviceName", "platform", "udid", "systemPort" })
	public void setup(String deviceName, String platform, String udid, String systemPort)
			throws Exception {
		System.out.println("Configuration # deviceName: " + deviceName + " - platform: " + platform + " - udid: "
				+ udid + " - " + " - systemPort: " + systemPort);
		driver = DriverFactory.getInstance(deviceName, platform, udid, systemPort);
		menu = new BottomMenuBarScreen(driver);
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
