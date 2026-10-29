package client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClient {
	
	
	private RequestSpecification spec;
	
	
	public BaseClient(RequestSpecification spec)
	{
		this.spec = spec;
	}
	
	
	public Response get(String endpoint, String id)
	{
		return RestAssured
			.given()
				.spec(spec)
				.pathParam("id", id)
			.when()
				.get(endpoint);
	}
}
