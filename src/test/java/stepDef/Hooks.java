package stepDef;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks 
{
	WebDriver driver;
	
	@BeforeAll
	public static void setUpDriver()
	{
		TestBase.initDriver();
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot scr = (TakesScreenshot)driver;
			byte[] img = scr.getScreenshotAs(OutputType.BYTES);
			scenario.attach(img, "image/png", "FailedScenarioImage");
		}
	}

	@AfterAll
	public static void tearDown()
	{
		TestBase.tearDown();
	}
}
