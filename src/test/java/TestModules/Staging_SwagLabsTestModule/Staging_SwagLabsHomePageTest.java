package TestModules.Staging_SwagLabsTestModule;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HerokuAppPages.HerokuHomePage;
import Pages.SwagLabsPages.HomePage;

public class Staging_SwagLabsHomePageTest 
{
	public WebDriver driver;
	
	HomePage homePage;
	
	public Staging_SwagLabsHomePageTest(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		homePage=new HomePage(driver);
		
	}
	
	public String getHomepageText()
	{
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(homePage.SwagLabsHeadingText));
		return homePage.SwagLabsHeadingText.getText();
	}
	
	public void enterUsername(String userName)
	{	
		homePage.userNameTextBox.clear();
		homePage.userNameTextBox.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{	
		homePage.passwordTextBox.clear();
		homePage.passwordTextBox.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		homePage.LoginButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean LoginFailed()
	{
		if(homePage.LoginErrorButton.isDisplayed()) return false;
		else return true;
	}
	
	public boolean LoginPassed()
	{
		if(homePage.ProductsText.getText().contains("Products")) return true;
		else return false;
	}
	
	
}
