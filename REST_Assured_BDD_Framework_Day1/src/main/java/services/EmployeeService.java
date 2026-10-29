package services;

import client.BaseClient;
import endpoints.EmployeeEndpoint;
import io.restassured.response.Response;


public class EmployeeService {
	
	
	private BaseClient baseClient;
	
	
	public EmployeeService(BaseClient baseClient)
	{
		this.baseClient = baseClient;
	}
	
	public Response getEmployeeAsPerId(String id)
	{
		return baseClient.get(EmployeeEndpoint.GET_EMPLOYEE_AS_PER_ID , id);
	}
}
