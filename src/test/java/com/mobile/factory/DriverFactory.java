package com.mobile.factory;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.mobile.properties.LoadProperties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class DriverFactory {

	private static AppiumDriver<MobileElement> driver;

	public static AppiumDriver<MobileElement> getInstance(String deviceName, String platformMobile, String udid,
			 String systemPort) throws Exception {

		String[] platformInfo = platformMobile.split(" ");

		URL url = new URL("http://127.0.0.1:4444/wd/hub");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		File app  = new File(LoadProperties.getPathApp("android"));
		
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
		capabilities.setCapability(MobileCapabilityType.UDID, udid);
		capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, Integer.parseInt(systemPort));
		capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);

		driver = new AndroidDriver<MobileElement>(url, capabilities);

		return driver;
	}
}
