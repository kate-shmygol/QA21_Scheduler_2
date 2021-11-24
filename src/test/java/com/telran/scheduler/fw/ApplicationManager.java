package com.telran.scheduler.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
	AppiumDriver driver;
	DesiredCapabilities capabilities;

	UserHelper user;
	EventHelper event;
	CurrencyHelper currency;
	WageHelper wage;

	public CurrencyHelper getCurrency() {
		return currency;
	}

	public WageHelper getWage() {
		return wage;
	}

	public UserHelper getUser() {
		return user;
	}

	public EventHelper getEvent() {
		return event;
	}

	public void init() throws MalformedURLException {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "8.0.0");
		capabilities.setCapability("deviceName", "qa21m_mob");
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
		capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
		capabilities.setCapability("app", "/home/katja/Tools/apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		user = new UserHelper(driver);
		event = new EventHelper(driver);
		currency = new CurrencyHelper(driver);
		wage = new WageHelper(driver);
	}


	public void stop() {
		driver.quit();
	}
}
