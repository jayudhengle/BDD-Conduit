package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//src//test//resources//features//Conduit.feature",
		glue = {"stepDef"},
		monochrome = true,
		dryRun = false,
		plugin = {"pretty",
				"html:target/Reports/HtmlReport.html"}			
		)



public class MyRunner extends AbstractTestNGCucumberTests
{
	

}
