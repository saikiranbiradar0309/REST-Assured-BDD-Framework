package steps;

import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import services.EmployeeServices;
import validators.Assertions;

public class EmployeeSteps {

	Response response;
	EmployeeServices employeeService;
	
	public EmployeeSteps(EmployeeServices employeeService)
	{
		this.employeeService = employeeService;
	}
	
	
	@When("user send get request with employee id")
	public void user_send_get_request_with_employee_id() {
	    
		response = employeeService.getAllEmployeeAsPerId("53");
	}

	
	
	@Then("user verify response status code should be {int}")
	public void user_verify_response_status_code_should_be(Integer statusCode) {
	    
		Assertions.verifyStatusCode(response, statusCode);
	}

	
	
	@Then("user verify response status line should be {string}")
	public void user_verify_response_status_line_should_be(String statusLine) {
	    
		Assertions.verifyResponseStatusLine(response, statusLine);
	}

	
	
	@Then("user verify response time should be below {int} milliseconds")
	public void user_verify_response_time_should_be_below_milliseconds(Integer time) {
		
		Assertions.verifyResponseTimeShouldBelow(response, (long) time);
	}

	
	@Then("user verify response firstname value should not be not null")
	public void user_verify_response_firstname_value_should_not_be_not_null() {
	    
		Assertions.verifyNotNull(response, "firstName");
	}
	

	@Then("user verify response username value should not be not null")
	public void user_verify_response_username_value_should_not_be_not_null() {
		Assertions.verifyNotNull(response, "username");
	}

	
	@Then("user verify response email value should be String type")
	public void user_verify_response_email_value_should_be_string_type() {
	   Assertions.verifyInstanceOfValue(response, "email", String.class);
	}

	@Then("user verify response lastname value should be String type")
	public void user_verify_response_lastname_value_should_be_string_type() {
		Assertions.verifyInstanceOfValue(response, "lastName", String.class);
	}
	
	@When("user send get request with city name")
	public void user_send_get_request_with_city_name() {
	   response = employeeService.getALlEmployeesAsPerCity("Bengaluru");
	}
	
	
	@Then("user verify all employee city name")
	public void user_verify_all_employee_city_name() {
	    
		Assertions.verifyResponseExpectedExactVaalue(response, "city", "bengaluru");
	}


	
}
