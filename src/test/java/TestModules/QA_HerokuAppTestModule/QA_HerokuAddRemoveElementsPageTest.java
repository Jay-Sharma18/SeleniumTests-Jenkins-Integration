package TestModules.QA_HerokuAppTestModule;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HerokuAppPages.AddRemoveElementsPage;
import Pages.HerokuAppPages.HerokuHomePage;

public class QA_HerokuAddRemoveElementsPageTest 
{
	public WebDriver driver;
	AddRemoveElementsPage addRemoveElementsPage;
	
	public QA_HerokuAddRemoveElementsPageTest(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		addRemoveElementsPage=new AddRemoveElementsPage(driver);
	}
	
	public String getAddRemoveElementsText()
	{
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(addRemoveElementsPage.AddRemoveElementsHeadingText));
		return addRemoveElementsPage.AddRemoveElementsHeadingText.getText();
	}
	
	public void clickAddElementButton()
	{
		addRemoveElementsPage.AddElementsButton.click();
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(addRemoveElementsPage.DeleteButton));
	}
	
	public  boolean deleteButtonVisible()
	{
		if(addRemoveElementsPage.DeleteButton.isDisplayed()) return true;
		else return false;
	}
	
	public void clickDeleteButton()
	{
		addRemoveElementsPage.DeleteButton.click();
		
	}
	
	

}
