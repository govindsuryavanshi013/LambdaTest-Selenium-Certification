package lambdaTest;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestScenario2 {

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
	public void dragDropBySlider() {
		// Open the Web URL
		driver.get("https://www.lambdatest.com/selenium-playground/");
		// Click on the Drag & Drop Sliders menu option
		driver.findElement(By.xpath("//a[normalize-space()='Drag & Drop Sliders']")).click();
		// Selecting the slider default value 15
		WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
		// Perform the Drag and drop Action

		Actions buider = new Actions(driver);
		buider.clickAndHold(driver.findElement(By.xpath("//input[@value='15']"))).moveByOffset(213, 0).release().build()
				.perform();
		WebElement showResult = driver.findElement(By.xpath("(//output[@id='rangeSuccess'])[1]"));
		String result = showResult.getText();
		System.out.println("Slider dragged upto value = " + result);

		// Validate the range value
		Assert.assertEquals(result, "95");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
