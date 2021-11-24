package com.telran.scheduler.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChooseCurrencyAndWageTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions () {
		app.getUser().register();
	}

	@Test
	public void chooseCurrencyAndWageTest() {
		app.getCurrency().chooseCurrency("Bahamian dollar");
		app.getWage().chooseWage("150");
		// assert
	}
}
