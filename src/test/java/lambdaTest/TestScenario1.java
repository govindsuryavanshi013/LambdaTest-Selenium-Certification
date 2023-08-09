package lambdaTest;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestScenario1 {

	private WebDriver driver;

	@BeforeMethod
	@Parameters({ "browserName", "browserVersion", "platform" })
	public void setUp(String browserName, String browserVersion, String platform) throws Exception {
		String username = "govind_suryavanshi";
		String accessKey = "ohWYvAdc4EITL4fwUYMD1LDVqHwkiPbkO3XMck563F625RcMfW";
		String hubUrl = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setCapability("browserVersion", browserVersion);
			options.setCapability("platform", platform);
			driver = new RemoteWebDriver(new URL(hubUrl), options);

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("browserVersion", browserVersion);
			options.setCapability("platform", platform);
			driver = new RemoteWebDriver(new URL(hubUrl), options);
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.setCapability("browserVersion", browserVersion);
			options.setCapability("platform", platform);
			driver = new RemoteWebDriver(new URL(hubUrl), options);
		}

		else if (browserName.equalsIgnoreCase("internet")) {
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setCapability("browserVersion", browserVersion);
			options.setCapability("platform", platform);
			driver = new RemoteWebDriver(new URL(hubUrl), options);
		}

	}

	@Test
	public void formDemo() {

		// Enter the Web Url

		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.findElement(By.xpath("//a[normalize-space()='Simple Form Demo']")).click();

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		String searchString = "simple-form-demo";
		// Validate that the URL contains “simple-form-demo”.

		if (currentUrl.contains(searchString)) {
			System.out.println("URL contains the string: " + searchString);

		} else {
			System.out.println("URL does not contain the String: " + searchString);
		}

		String Inputtext = "Welcome to LambdaTest";

		WebElement textField = driver.findElement(By.xpath("(//input[@id='user-message'])[1]"));
		textField.click();
		textField.sendKeys(Inputtext);

		// Click on getCheck value

		driver.findElement(By.cssSelector("#showInput")).click();
		// Grabbing the Display text
		WebElement displayTextElement = driver.findElement(By.id("message"));
		// Getting the displayed text from the element on the screen
		String displayedText = displayTextElement.getText();
		// Assert that text entered matches displayed text
		Assert.assertEquals(Inputtext, displayedText, "Input text does not match displayed text");

	}

	@AfterMethod
	public void tearDown1() {
		driver.quit();
	}

}
