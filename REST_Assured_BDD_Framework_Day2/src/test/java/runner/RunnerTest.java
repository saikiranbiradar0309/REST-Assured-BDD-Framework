package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features = "src/test/resources/features",
		glue = "steps",
		dryRun = false
		
		)


public class RunnerTest extends AbstractTestNGCucumberTests {
	
	
	
}
