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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestScenario3 {

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
	public void inputFormSubmit() {

		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.findElement(By.xpath("//a[normalize-space()='Input Form Submit']")).click();

//fill the form field
		driver.findElement(By.cssSelector("#name")).sendKeys("chimaji");
		driver.findElement(By.xpath("(//input[@id='inputEmail4'])[1]")).sendKeys("chimajikolekar@gmail.com");
		driver.findElement(By.cssSelector("#inputPassword4")).sendKeys("Test@123");
		driver.findElement(By.cssSelector("#company")).sendKeys("Presistent System");

		driver.findElement(By.cssSelector("#websitename")).sendKeys("Presistent.com");

		WebElement staticdropDown = driver.findElement(By.cssSelector("select[name='country']"));
		Select select = new Select(staticdropDown);
		select.selectByVisibleText("United States");
		driver.findElement(By.cssSelector("#inputCity")).sendKeys("pune");
		driver.findElement(By.cssSelector("#inputAddress1")).sendKeys("Bharti vidyapeth");
		driver.findElement(By.cssSelector("#inputAddress2")).sendKeys("Katraj pune road");
		driver.findElement(By.cssSelector("#inputState")).sendKeys("Maharashtra");
		driver.findElement(By.cssSelector("#inputZip")).sendKeys("411041");
		driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[1]")).click();
		String SuccessMessage = driver.findElement(By.cssSelector(".success-msg.hidden")).getText();
		Assert.assertEquals(SuccessMessage, "Thanks for contacting us, we will get back to you shortly.");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
