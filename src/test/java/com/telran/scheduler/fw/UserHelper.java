package com.telran.scheduler.fw;

import com.telran.scheduler.model.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class UserHelper extends HelperBase {

	public UserHelper(AppiumDriver driver) {
		super(driver);
	}

	public void login(User user) {
		type(By.id("log_email_input"), user.getEmail());
		type(By.id("log_password_input"), user.getPassword());
		hideKeyBoard();
		tapLoginButton();
	}

	private void tapLoginButton() {
		tap(By.id("login_btn"));
	}

	public void defaultLogin() {
		login(new User().setEmail("etwaemail@gmail.com").setPassword("etwageheimzahl2021"));
	}
}
