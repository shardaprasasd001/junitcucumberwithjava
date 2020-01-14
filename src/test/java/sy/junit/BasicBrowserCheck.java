package sy.junit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicBrowserCheck {
	@Test
	public void sometest() {
		// http://www.seleniumhq.org/download/maven.jsp
		// https://code.google.com/p/selenium/wiki/GettingStarted

		// Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "C:\\Eclipse-Workspace\\Driver\\chromedriver_win32\\chromedriver79.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		System.out.println("Page title is: " + driver.getTitle());
		driver.quit();
	}
}
