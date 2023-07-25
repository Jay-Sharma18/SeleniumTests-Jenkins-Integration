package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver InitDriver(String browser)
	{	
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver(chromeOptions);
			return driver;
		}
		else
		{	
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver(firefoxOptions);
			return driver;
		}
		
	}

}
