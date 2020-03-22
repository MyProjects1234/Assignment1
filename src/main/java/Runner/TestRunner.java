package Runner;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/feature", glue = { "StepDef" }, tags = { "@runTest" }, format = { "pretty",
		"html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberTestReports.json",
		"rerun:target/cucumber-reports/rerun.txt" }, plugin = "json:target/cucumber-reports/CucumberTestReports.json")

public class TestRunner extends AbstractTestNGCucumberTests {
	public static Properties properties = null;
	public static WebDriver driver = null;
	public static String baseUrl;

	public void openBrowser(String browserType) throws Exception {
		if (browserType.equals("firefox")) {
			String firefoxDriverPath = System.getProperty("user.dir") + "//resources//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
		} else if (browserType.equals("chrome")) {
			String chromeDriverPath = System.getProperty("user.dir") + "//resources//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			Boolean headless = Boolean.valueOf(properties.getProperty("headless"));
			options.setHeadless(headless);
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		}
	}

	public void maximizeWindow() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}
	
	public void setEnv(String portal) throws Exception {
		if (portal.contains("Amazon")) {
			baseUrl = "https://www.amazon.in";
		} else {
			baseUrl = "https://www.flipkart.com";
		}
		driver.get(baseUrl);
	}


}
