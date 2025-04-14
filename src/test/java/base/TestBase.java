package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {
	private static TestBase testBase;
	private static WebDriver driver;
	WebDriverWait wait;



	private TestBase() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
		driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
	}

	public static void initDriver() {
		if (testBase == null) {
			testBase = new TestBase();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void openURL(String url) {
		driver.get(url);
	}

	public static void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
		testBase = null;
	}
}
