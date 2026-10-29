package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderFactory {
	
	// It will throw exception because we are using this code inside src/main/java packages
	// Open pom.xml file and change the dependency scope to the test to compile for rest-assured
	public static RequestSpecification getRequestSpecification()
	{
		 RequestSpecification spec = new RequestSpecBuilder()
				.setBaseUri("http://localhost:9191")
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
		 
		 
		 return spec;

	}
}
