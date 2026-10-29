package steps;


import org.hamcrest.Matchers;
import org.testng.Assert;

import base.RequestSpecBuilderFactory;
import client.BaseClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import services.EmployeeService;

public class EmployeeSteps {
	
	RequestSpecification spec;
	Response response;
	EmployeeService employeeService;

	
	@Given("user get request specification object")
	public void user_get_request_specification_object() {
	    
		
		// Here we call Base Class Method
		spec = RequestSpecBuilderFactory.getRequestSpecification();
		
		
		BaseClient baseClient = new BaseClient(spec);
		employeeService = new EmployeeService(baseClient);
	}

	@When("user retrieve employee as per id")
	public void user_retrieve_employee_as_per_id() {
		
		response = employeeService.getEmployeeAsPerId("52");
	}

	@Then("user validate status code {int}")
	public void user_validate_status_code(Integer expectedStatusCode) {
	   
	   //response.then().assertThat().statusCode(Matchers.equalTo(expectedStatusCode));
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, expectedStatusCode);
	}

	@Then("user validate status line {string}")
	public void user_validate_status_line(String expectedStatusLine) {
	    
		//response.then().assertThat().statusLine(Matchers.containsString(expectedStatusLine));
		
		String statusLine = response.statusLine();
		Assert.assertTrue(statusLine.contains(expectedStatusLine));
	}

	@Then("user validate response time below  {int} milliseconds")
	public void user_validate_response_time_below_milliseconds(Integer expectedResponseTime) {
	    
		response.then().assertThat().time(Matchers.lessThan((long)expectedResponseTime));
	
		long actualTime = response.time();
		Assert.assertTrue(actualTime < expectedResponseTime);
		
	}

	@Then("user validates response first name should not be null")
	public void user_validates_response_first_name_should_not_be_null() {
	   
		response.then().assertThat().body("firstName", Matchers.notNullValue());
		
		String firstName = response.jsonPath().getString("firstName");
		Assert.assertNotNull(firstName);
	
	}

	@Then("user validates response email should be string type")
	public void user_validates_response_email_should_be_string_type() {
	   
		response.then().assertThat().body("email", Matchers.instanceOf(String.class));
	
		String email = response.jsonPath().getString("email");
		Assert.assertTrue(email instanceof String);
	}


}
