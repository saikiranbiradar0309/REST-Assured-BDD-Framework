package client;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import spec.SpecFactory;

public class BaseClient {
	
	
	public Response get(String endpoint)
	{
		
		Response response =  RestAssured
			.given()
				.spec(SpecFactory.requestSpec())
			.when()
				.get(endpoint)
			.then()
				.assertThat()
				.spec(SpecFactory.responseSpec())
				.extract()
				.response();
		
		
		
		return response;
	}
	
	
	public Response get(String endpoint, HashMap<String, String> pathParams)
	{
		
		Response response = RestAssured
			.given()
				.spec(SpecFactory.requestSpec())
				.pathParams(pathParams)
			.when()
				.get(endpoint)
			.then()
				.assertThat()
				.spec(SpecFactory.responseSpec())
				.extract()
				.response();
		
		return response;
	}
	
	
	
	
	public Response get(String endpoint, HashMap<String, String> pathParams, HashMap<String, String> queryParams)
	{
		
		Response response = null;
		if(pathParams != null)
		{
		
			 response = RestAssured
					.given()
						.spec(SpecFactory.requestSpec())
						.pathParams(pathParams)
					.when()
						.get(endpoint)
					.then()
						.assertThat()
						.spec(SpecFactory.responseSpec())
						.extract()
						.response();
		}
		
		if(queryParams != null)
		{
			response = RestAssured
					.given()
						.spec(SpecFactory.requestSpec())
						.queryParams(queryParams)
					.when()
						.get(endpoint)
					.then()
						.assertThat()
						.spec(SpecFactory.responseSpec())
						.extract()
						.response();
		}
		
		
		if(pathParams != null && queryParams != null)
		{
			response = RestAssured
					.given()
						.spec(SpecFactory.requestSpec())
						.pathParams(pathParams)
						.queryParams(queryParams)
					.when()
						.get(endpoint)
					.then()
						.assertThat()
						.spec(SpecFactory.responseSpec())
						.extract()
						.response();
		}
		
		return response;
	}
	
}
