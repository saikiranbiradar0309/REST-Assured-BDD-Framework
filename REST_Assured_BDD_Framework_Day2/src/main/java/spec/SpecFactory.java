package spec;



import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecFactory {
	
	public static RequestSpecification requestSpec()
	{
		
		// RequestSpecBuilder is a class which is used to build the request specification
		RequestSpecBuilder spec = new RequestSpecBuilder();
		
		
		//Generally we store BaseUri in a property file and read it from there. 
		//But for now we will hardcode it.
		spec.setBaseUri("http://localhost:9191");
		
		//We can set the content type of the request here.
		spec.setContentType(ContentType.JSON);
		
		//We can set the accept type of the request here.
		spec.setAccept(ContentType.JSON);
		
		//We can set the relaxed HTTPS validation here.
		spec.setRelaxedHTTPSValidation();
		
		//We can log the request and response details here.
		spec.log(LogDetail.ALL);
		
		
		// I want to combine all the above details and create a request specification object which can be used in all the test cases.
		// So we will use build() method to create a request specification object.
		// We can use this request specification object in all the test cases.
		RequestSpecification requestSpec = spec.build();
		
		
		
		return requestSpec;
	}
	
	
	public static ResponseSpecification responseSpec()
	{
		
		// ResponseSpecBuilder is a class which is used to build the response specification
		ResponseSpecBuilder spec = new ResponseSpecBuilder();
		
		//We can set the expected Response Time of the response here.
		//spec.expectResponseTime(Matchers.lessThan(5000L));
		
		
		//spec.expectHeader("Content-Type", Matchers.containsString("application/json"));
		
		// log the request and response details here.
		spec.log(LogDetail.ALL);
		
		ResponseSpecification responseSpec =  spec.build();
		
		return responseSpec;
	}
	
}
