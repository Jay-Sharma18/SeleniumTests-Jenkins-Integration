package ProjectBaseClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.DeleteFilesWithWildcard;
import Utilities.DriverFactory;
import Utilities.ReadConfig;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.regex.Pattern;
import java.io.FileFilter;

public class BaseSetup {
	
	public WebDriver driver;
	
	public static String webBrowser=System.getProperty("browser");
	public static String testEnvironment=System.getProperty("environment");
	
	
	
	public static ReadConfig config= new ReadConfig();
	public static String URL=config.returnURL(testEnvironment);
	public static String userName=config.returnUsername(testEnvironment);
	public static String password=config.returnPassword(testEnvironment);
	
	//log4j log files location
	private String logFilePath1="log/testlog.log";
	private String logFilePath2="log/testlog1.log";
	
	public static Logger log;
	
	@BeforeClass
	public void setup()
	{	
		
		//clear log files before each test run
		clearLogFile();
		
		//clear old test reports
		DeleteFilesWithWildcard.deleteOldFiles();
		
		log= Logger.getLogger("Selenium_Jenkins_Automation");
		PropertyConfigurator.configure("log4j.properties");
		log.info("Launching web browser");
		
		driver=DriverFactory.InitDriver(webBrowser);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
		
		if(webBrowser.contains("Chrome"))
		{
			log.info("Google Chrome is launched");
		}
		else
		{
			log.info("Firefox is Launched");
		}
		
		if(testEnvironment.contains("QA"))
		{
			log.info("QA Environment: HerokuApp");
		}
		else
		{
			log.info("Staging Environment: Swag Labs");
		}
		
	}
	
	@AfterClass
	public void tearDown()
	{	
		log.info("Closing Browser");
		driver.quit();
	}
	
	 
	//method to clear log files before each test run
	private void clearLogFile() {
	        try {
	            File logFile = new File(logFilePath1);
	            FileWriter fileWriter = new FileWriter(logFilePath1);
	            // Truncate the log file by setting its length to 0
	            fileWriter.write("");
	            fileWriter.close();
	            fileWriter = new FileWriter(logFilePath2);
	            fileWriter.write("");
	            fileWriter.close();
	        } 
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	            // Handle any exceptions here, if required.
	        }
	    }
	
	
	

}