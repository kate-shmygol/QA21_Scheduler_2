package com.telran.scheduler.tests;

import com.telran.scheduler.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

	@Test
	public void loginPositiveTest() {
		app.getUser().login(new User().setEmail("world@gmail.com").setPassword("World2021"));
		Assert.assertTrue(app.getEvent().isContainerReportPresent());
	}

	// id = log_email_input
	// password id = log_password_input
	// nav_list_fr_container
}
