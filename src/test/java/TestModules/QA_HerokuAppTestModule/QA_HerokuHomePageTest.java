package TestModules.QA_HerokuAppTestModule;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pages.HerokuAppPages.HerokuHomePage;
import Pages.HerokuAppPages.HerokuHomePage.*;


public class QA_HerokuHomePageTest
{	
	public WebDriver driver;
	HerokuHomePage herokuHomePage;
	
	public QA_HerokuHomePageTest(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		herokuHomePage=new HerokuHomePage(driver);
	}
	
	public String getWelcomeText()
	{
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(herokuHomePage.WelcomeToTheInternetHeadingTextBox));
		return herokuHomePage.WelcomeToTheInternetHeadingTextBox.getText();
	}
	
	public void clickAddRemoveElements()
	{
		herokuHomePage.AddRemoveElementsLink.click();
	}

}
