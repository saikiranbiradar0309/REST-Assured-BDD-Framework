package endpoints;

public interface EmployeeEndpoint {
	
	public static final String CREATE_EMPLOYEE = "/api/employees";
	
	public static final String GET_ALL_EMPLOYEES = "/api/employees";
	
	public static final String GET_EMPLOYEE_AS_PER_ID = "/api/employee/{id}";
	
	public static final String GET_EMPLOYEES_AS_PER_CITY = "/api/employees/city/{city}";
	
	public static final String UPDATE_EMPLOYEES_AS_PER_ID = "/api/employees/{id}";
	
	public static final String DELETE_EMPLOYEES_AS_PER_ID = "/api/employees/{id}";
}
