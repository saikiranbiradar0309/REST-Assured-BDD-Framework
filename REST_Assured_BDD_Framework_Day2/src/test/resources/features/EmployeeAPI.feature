Feature: Employee API

	Rule: Employee Should be Exist in the Backend Server
	
	Scenario: Retrieve Employees As per Id
		When user send get request with employee id
		Then user verify response status code should be 200
		And user verify response status line should be "200"
		And user verify response time should be below 5000 milliseconds
		And user verify response firstname value should not be not null
		And user verify response username value should not be not null
		And user verify response email value should be String type
		And user verify response lastname value should be String type
		
	
	Scenario: Retrieve all Employees as per City
		When user send get request with city name
		Then user verify response status code should be 200
		And user verify response status line should be "200"
		And user verify response time should be below 5000 milliseconds
		And user verify all employee city name