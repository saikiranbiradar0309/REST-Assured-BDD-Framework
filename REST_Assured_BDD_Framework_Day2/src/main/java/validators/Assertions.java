package validators;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;

import io.restassured.response.Response;

public class Assertions {
	
	
	public static void verifyStatusCode(Response response, int expectedStatusCode)
	{
		//response.then().assertThat().statusCode(Matchers.equalTo(expectedStatusCode));
		
		
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
	}
	
	
	public static void verifyResponseStatusLine(Response response, String expectedStatusLine)
	{
		Assert.assertTrue(response.statusLine().contains(expectedStatusLine));
	}
	
	
	public static void verifyResponseTimeShouldBelow(Response response, long expectedTime)
	{
		Assert.assertTrue(response.getTime() < expectedTime);
		
		response.then().assertThat().time(Matchers.lessThan(expectedTime));
	}
	
	
	public static void verifyNotNull(Response response, String jsonPath)
	{
		String actualValue = response.jsonPath().getString(jsonPath);
		
		Assert.assertNotNull(actualValue);
		
		
		//response.then().assertThat().body(jsonPath, Matchers.notNullValue());
	}
	
	
	
	public static void verifyInstanceOfValue(Response response, String jsonPath, Class<?> classType)
	{
		String actualValue = response.jsonPath().getString(jsonPath);
		Assert.assertEquals(actualValue.getClass(), classType);
		
		response.then().assertThat().body(jsonPath, Matchers.instanceOf(classType));
	}
	
	
	public static void verifyResponseExpectedExactVaalue(Response response, String jsonPath, String expectedValue)
	{
		
		List<String> allCities = response.jsonPath().getList(jsonPath);
		
		
		
		//List<String> allCities = response.jsonPath().get("findAll(it -> it.city =='Bengaluru').city"); 
		
		
		for(String actualCity : allCities)
		{
			Assert.assertEquals(actualCity.toLowerCase(), expectedValue.toLowerCase());
		}	
	}
	
}
