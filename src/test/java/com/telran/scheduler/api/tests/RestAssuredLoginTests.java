package com.telran.scheduler.api.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.telran.scheduler.api.dto.AuthRequestDto;
import com.telran.scheduler.api.dto.AuthResponseDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredLoginTests {

	@BeforeMethod
	public void ensurePreconditions() {
		RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/";
		RestAssured.basePath = "api";
	}

	@Test
	public void loginSuccessTest() {
		AuthRequestDto requestDto = AuthRequestDto.builder()
				.email("world@gmail.com")
				.password("World2021")
				.build();

		AuthResponseDto responseDto = given()
				.contentType("application/json")
				.body(requestDto)
				.when()
				.post("login")
				.then()
				.assertThat().statusCode(200)
				.extract().response().as(AuthResponseDto.class);

		System.out.println(responseDto.getToken());
		System.out.println(responseDto.getStatus());
		System.out.println(responseDto.isRegistration());
	}

	@Test
	public void loginWrongPasswordTest() {
		AuthRequestDto requestDto = AuthRequestDto.builder()
				.email("world@gmail.com")
				.password("World20")
				.build();

		String message = given()
				.contentType(ContentType.JSON)
				.body(requestDto)
				.when()
				.post("login")
				.then()
				.assertThat().statusCode(401)
				.extract().path("message");

		System.out.println(message);
	}

	@Test
	public void registrationSuccessTest() {
		int index = (int) (System.currentTimeMillis() / 1000) % 3600;
		AuthRequestDto requestDto = AuthRequestDto.builder()
				.email("world" + index + "@gmail.com")
				.password("World2021")
				.build();

//		String message = given()
//				.contentType(ContentType.JSON)
//				.body(requestDto)
//				.when()
//				.post("login")
//				.then()
//				.assertThat().statusCode(200)
//				.extract().path("message");
//		System.out.println(message);

		given()
				.contentType(ContentType.JSON)
				.body(requestDto)
				.when()
				.post("login")
				.then()
				.statusCode(200)
				.assertThat().body("status", containsString("Registration success"))
				.body("registration", equalTo(true));
	}
}
