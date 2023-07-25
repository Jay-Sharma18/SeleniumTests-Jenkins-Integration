package ProjectBaseClasses;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.DriverFactory;
import Utilities.ReadConfig;

public class BaseSetup {
	
	public WebDriver driver;
	
	public static String webBrowser=System.getProperty("browser");
	public static String testEnvironment=System.getProperty("environment");
	
	public static ReadConfig config= new ReadConfig();
	public static String URL=config.returnURL(testEnvironment);
	public static String userName=config.returnUsername(testEnvironment);
	public static String password=config.returnPassword(testEnvironment);
	
	@BeforeClass
	public void setup()
	{
		driver=DriverFactory.InitDriver(webBrowser);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}