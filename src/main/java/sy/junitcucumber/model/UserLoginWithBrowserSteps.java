package sy.junitcucumber.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserLoginWithBrowserSteps {
	WebDriver driver;

	@Given("^I am on Facebook login page$")
    public void goToFacebook() { 
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Eclipse-Workspace\\Driver\\chromedriver_win32\\chromedriver79.exe");
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("start-maximized");
		 * options.addArguments("--disable-extensions");
		 * options.addArguments("--disable-infobars"); Map<String, Object> prefs = new
		 * HashMap<String, Object>(); prefs.put("credentials_enable_service", false);
		 * prefs.put("profile.password_manager_enabled", false);
		 * prefs.put("excludeSwitches", "enable-automation");
		 * options.setExperimentalOption("prefs", prefs); DesiredCapabilities
		 * capabilities = DesiredCapabilities.chrome();
		 * capabilities.setCapability("version", "latest");
		 * capabilities.setCapability("browserName", "chrome");
		 * capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		 * 
		 * try { driver = new ChromeDriver(options);
		 * //driver.manage().deleteAllCookies();
		 * driver.navigate().to("https://www.facebook.com/"); } catch(Exception e) {
		 * System.out.println("**>uh-oh " + e.getMessage()); }
		 */
       
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse-Workspace\\Driver\\chromedriver_win32\\chromedriver79.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
     }

	@When("^I enter username as \"(.*)\"$")
	public void enterUsername(String arg1) {
		System.out.println(arg1);
		driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@When("^I enter password as \"(.*)\"$")
	public void enterPassword(String arg1) {
		driver.findElement(By.id("pass")).sendKeys(arg1);
		driver.findElement(By.id("u_0_b")).click();
	}

	@Then("^Login should fail$")
	public void checkFail() {
		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=110")) {
			System.out.println("Test1 Pass");
		} else {
			System.out.println("Test1 Failed");
		}
		driver.close();
	}

	@Then("^Relogin option should be available$")
	public void checkRelogin() {
		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=110")) {
			System.out.println("Test2 Pass");
		} else {
			System.out.println("Test2 Failed");
		}
		driver.close();
	}
}
