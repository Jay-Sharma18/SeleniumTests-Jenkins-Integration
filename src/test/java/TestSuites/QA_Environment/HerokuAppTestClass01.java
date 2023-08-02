package TestSuites.QA_Environment;

import java.awt.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HerokuAppPages.AddRemoveElementsPage;
import Pages.HerokuAppPages.HerokuHomePage;
import TestModules.QA_HerokuAppTestModule.QA_HerokuAddRemoveElementsPageTest;
import TestModules.QA_HerokuAppTestModule.QA_HerokuHomePageTest;
import TestModules.Staging_SwagLabsTestModule.Staging_SwagLabsHomePageTest;

public class HerokuAppTestClass01 extends ProjectBaseClasses.BaseSetup 
{	
	QA_HerokuHomePageTest qA_HerokuHomePageTest;
	QA_HerokuAddRemoveElementsPageTest qA_HerokuAddRemoveElementsPageTest;
	
	@BeforeMethod()
	public void initTestModule()
	{	
		qA_HerokuAddRemoveElementsPageTest=new QA_HerokuAddRemoveElementsPageTest(driver);
		qA_HerokuHomePageTest= new QA_HerokuHomePageTest(driver);	
	}
	
	@Test
	public void A1_verifyWelcomeText()
	{	
		log.info("Executing 1st Test: Login and Verify welcome text");
		String welcomeText=qA_HerokuHomePageTest.getWelcomeText();
		if(welcomeText.contains("Welcome to the-internet"))
		{	
			log.info("Passed-Login Successful! welcome test verified successfully");
			assert true;
		}
		else
		{	
			log.info("Failed-Login Failed! Welcome Text is not verified");
			assert false;
		}
	}
	
	@Test
	public void A2_verifyAddRemoveElementsText()
	{	
		log.info("Executing 2nd Test: Click Add/Remove Elements Link");
		qA_HerokuHomePageTest.clickAddRemoveElements();
		if(qA_HerokuAddRemoveElementsPageTest.getAddRemoveElementsText().contains("Add/Remove"))
		{	
			log.info("Passed-Add/Remove Elements Page loaded successfully!");
			assert true;
		}
		else
		{
			log.info("Failed-Add/Remove Elements Page did not load successfully!");
			assert false;
		}
	}
	
	@Test
	public void A3_verifyDeleteButtonPresent()
	{
		log.info("Executing 3rd Test: Click Add Element Button");
		qA_HerokuAddRemoveElementsPageTest.clickAddElementButton();
		if(qA_HerokuAddRemoveElementsPageTest.deleteButtonVisible())
		{
			log.info("Passed-Delete Button added successfully");
			assert true;
		}
		else
		{
			log.info("Failed-Delete Button was not added");
			assert false;
		}
	}
	
	@Test
	public void A4_verifyDeleteButtonNotPresent()
	{	
		log.info("Executing 4th Test: Click Delete Element Button");
		qA_HerokuAddRemoveElementsPageTest.clickDeleteButton();
		ArrayList<WebElement> deleteButtonsList= new ArrayList<WebElement>();
		deleteButtonsList=(ArrayList<WebElement>) driver.findElements(By.xpath("//button[contains(text(),'Delete')]"));
		if(deleteButtonsList.size()==0) 
		{	
			log.info("Passed-Delete Button removed");
			assert true;
		}
		
		else 
			
		{
			log.info("Failed-Delete Button was not removed");
			assert false;
		}
	}

}
