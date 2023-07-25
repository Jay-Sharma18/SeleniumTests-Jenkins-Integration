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
		String welcomeText=qA_HerokuHomePageTest.getWelcomeText();
		if(welcomeText.contains("Welcome to the-internet"))
		{
			assert true;
		}
		else
		{
			assert false;
		}
	}
	
	@Test
	public void A2_verifyAddRemoveElementsText()
	{
		qA_HerokuHomePageTest.clickAddRemoveElements();
		qA_HerokuAddRemoveElementsPageTest.getAddRemoveElementsText();
	}
	
	@Test
	public void A3_verifyDeleteButtonPresent()
	{
		qA_HerokuAddRemoveElementsPageTest.clickAddElementButton();
		if(qA_HerokuAddRemoveElementsPageTest.deleteButtonVisible())
		{
			assert true;
		}
		else
		{
			assert false;
		}
	}
	
	@Test
	public void A4_verifyDeleteButtonNotPresent()
	{
		qA_HerokuAddRemoveElementsPageTest.clickDeleteButton();
		ArrayList<WebElement> deleteButtonsList= new ArrayList<WebElement>();
		deleteButtonsList=(ArrayList<WebElement>) driver.findElements(By.xpath("//button[contains(text(),'Delete')]"));
		if(deleteButtonsList.size()==0) assert true;
		else assert false;
	}

}
