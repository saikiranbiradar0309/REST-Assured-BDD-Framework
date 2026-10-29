package services;

import java.util.HashMap;

import client.BaseClient;
import endpoints.EmployeeEndpoint;
import io.restassured.response.Response;

public class EmployeeServices extends BaseClient {
	
	
	public Response getAllEmployees()
	{
		return this.get(EmployeeEndpoint.GET_ALL_EMPLOYEES);
	}
	
	
	public Response getAllEmployeeAsPerId(String id)
	{
		// So here we need to pass the ID as path parameter, 
		//so we need to create a HashMap and pass the ID as key value pair in the HashMap and then pass that HashMap to the get method of BaseClient class.
	
		HashMap<String, String> pathParams = new HashMap<String, String>();
		pathParams.put("id", id);
		
		
		return this.get(EmployeeEndpoint.GET_EMPLOYEE_AS_PER_ID, pathParams);
	
	}
	
	
	public Response getALlEmployeesAsPerCity(String city)
	{
		HashMap<String, String> pathParams = new HashMap<String, String>();
		pathParams.put("city", city);
		
		return this.get(EmployeeEndpoint.GET_EMPLOYEES_AS_PER_CITY, pathParams);
	}
}	
