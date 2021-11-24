package com.telran.scheduler.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class CurrencyHelper extends HelperBase {

	public CurrencyHelper(AppiumDriver driver) {
		super(driver);
	}

	public void chooseCurrency(String currency) {
		tap(By.id("wizard_settings_currency_arrow"));
		selectCurrency(currency);
		// tapCurrencyArrow = wizard_settings_currency_arrow
	}

	private void selectCurrency(String currency) {
		if (!getSelectedCurrency().equals(currency)) {
			swipeUp();
			tap(By.xpath("//android.widget.TextView[@text=' " + currency + " ']"));
			// currency = android.widget.TextView - Bahamian dollar
		}
	}

	private void swipeUp() {
		TouchAction action = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();

		int x = size.width / 2;

		int startY = (int) (size.height * 0.8);
		int stopY = (int) (size.height * 0.2);

		action.longPress(PointOption.point(x, startY))
				.moveTo(PointOption.point(x, stopY))
				.release()
				.perform();
	}

	private String getSelectedCurrency() {
		WebElement selectedCurrency = driver.findElement(By.xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/currency_row_root']"));
		return selectedCurrency.findElement(By.xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/currency_row_title']"))
				.getText();
	}

	// .//*[@resource-id='com.example.svetlana.scheduler:id/currency_row_root']
	// .//*[@resource-id='com.example.svetlana.scheduler:id/currency_row_title']
}
