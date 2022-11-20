package com.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGetAPI {

	@Test
	public void testGetApi() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.header("Content-Type", "application/json");
		Response response = reqSpec.get("https://reqres.in/api/users?page=2");
		System.out.println(response.asPrettyString());
		
		JsonPath jsonPath =  response.jsonPath();
		
		String firstName = jsonPath.getString("data[0].first_name");
		System.out.println("First name: "+firstName);
	}
}
