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
		
		String text=staging_SwagLabsHomePageTest.getHomepageText();
		if(text.contains("Swag Labs"))
		{	
			
			assert true;
		}
		else
		{
			assert false;
		}
	}
	
	
	@Test
	public void A2_loginWithInvalidCredentials() 
	{	
		staging_SwagLabsHomePageTest.enterUsername("invalid_username");
		staging_SwagLabsHomePageTest.enterPassword("random_password");
		staging_SwagLabsHomePageTest.clickLoginButton();
		
		if(!staging_SwagLabsHomePageTest.LoginFailed())
		{
			assert true;
		}
		else
		{
			assert false;
		}
		
	}
	
	@Test
	public void A3_loginWithvalidCredentials() 
	{
		staging_SwagLabsHomePageTest.enterUsername(userName);
		staging_SwagLabsHomePageTest.enterPassword(password);
		staging_SwagLabsHomePageTest.clickLoginButton();
		
		if(staging_SwagLabsHomePageTest.LoginPassed())
		{
			assert true;
		}
		else
		{
			assert false;
		}
		
	}
	
	

}
