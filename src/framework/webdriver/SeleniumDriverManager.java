package framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

import static framework.common.ConfigConstants.BROWSER;
import static framework.common.ConfigConstants.CHROMEDRIVER_PATH;
import static framework.common.ConfigConstants.IEDRIVER_PATH;

/**
 * Manages the web browser
 */
public class SeleniumDriverManager {
	private static SeleniumDriverManager manager = null;
	private WebDriver driver;
	private WebDriverWait wait;

	protected SeleniumDriverManager() {
		initializeDriver();
	}

	private void initializeDriver() {

		String browser = BROWSER;

		if (browser.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
			System.out.println(browser);		 
		}
		else if (browser.equalsIgnoreCase("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
			
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", IEDRIVER_PATH);
			System.out.println(browser);
			driver = new InternetExplorerDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10, 100);
	}

	public static SeleniumDriverManager getManager() {
		if (manager == null) {
			manager = new SeleniumDriverManager();
		}
		return manager;
	}

	/**
	 * Get the Web driver
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	/**
	 * Set to null the webdriver
	 */
	public void quitDriver() {
		try {
			driver.quit();
		} catch (Exception e) {
			Logger.getLogger(getClass()).error("Unable to quit the webdriver", e);
		}
		driver = null;
	}
}