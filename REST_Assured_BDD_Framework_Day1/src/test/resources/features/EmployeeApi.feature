Feature: Employee APIs

	Scenario: Retrieve Employee as Per Id
		Given user get request specification object
		When user retrieve employee as per id
		Then user validate status code 200
		And user validate status line "200"
		And user validate response time below  5000 milliseconds
		And user validates response first name should not be null
		And user validates response email should be string type
	