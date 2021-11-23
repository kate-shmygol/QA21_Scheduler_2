package com.telran.scheduler.tests;

import com.telran.scheduler.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

	@Test
	public void loginPositiveTest() {
		app.getUser().login(new User().setEmail("etwaemail@gmail.com").setPassword("etwageheimzahl2021"));
		Assert.assertTrue(app.getEvent().isContainerReportPresent());
	}

	@Test
	public void registerPositiveTest() {
		// same, but with other new data - login
		// from Contact - project - every time - new data
		// assert
	}

	// id = log_email_input
	// password id = log_password_input
	// nav_list_fr_container
}
