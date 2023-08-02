package TestSuites.Staging_Environment;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.SwagLabsPages.HomePage;
import ProjectBaseClasses.BaseSetup;
import TestModules.Staging_SwagLabsTestModule.Staging_SwagLabsHomePageTest;

public class SwagLabsTestClass01 extends BaseSetup
{	
	Staging_SwagLabsHomePageTest staging_SwagLabsHomePageTest;
	
	@BeforeMethod()
	public void initTestModule()
	{
		staging_SwagLabsHomePageTest= new Staging_SwagLabsHomePageTest (driver); 
			
	}
	
	@Test
	public void A1_verifyHomePageText() 
	{	
		log.info("Executing 1st test: Open home page and Verify home page text");
		String text=staging_SwagLabsHomePageTest.getHomepageText();
		if(text.contains("Swag Labs"))
		{	
			log.info("Passed-Home page text validation successful");
			assert true;
		}
		else
		{	
			log.info("Home page text validation failed");
			assert false;
		}
	}
	
	
	@Test
	public void A2_loginWithInvalidCredentials() 
	{	
		log.info("Executing 2nd test: Login with invalid credentials and Verify login fails");
		
		staging_SwagLabsHomePageTest.enterUsername("invalid_username");
		staging_SwagLabsHomePageTest.enterPassword("random_password");
		staging_SwagLabsHomePageTest.clickLoginButton();
		
		if(!staging_SwagLabsHomePageTest.LoginFailed())
		{
			log.info("Passed-Login was not successful");
			assert true;
		}
		else
		{
			log.info("Failed-Login was successful");
			assert false;
		}
		
	}
	
	@Test
	public void A3_loginWithvalidCredentials() 
	{
		log.info("Executing 3rd test: Login with valid credentials and Verify login user logs in successfully");
		
		staging_SwagLabsHomePageTest.enterUsername(userName);
		staging_SwagLabsHomePageTest.enterPassword(password);
		staging_SwagLabsHomePageTest.clickLoginButton();
		
		if(staging_SwagLabsHomePageTest.LoginPassed())
		{
			log.info("Passed-Logged in with valid credentials");
			assert true;
		}
		else
		{
			log.info("Failed-Couldnt Log in with valid credentials");
			assert false;
		}
		
	}
	
	

}
