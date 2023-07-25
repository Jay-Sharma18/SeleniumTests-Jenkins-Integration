package Pages.HerokuAppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuHomePage {
	
	public WebDriver driver;
	
	public HerokuHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	public WebElement WelcomeToTheInternetHeadingTextBox;
	
	@FindBy(linkText = "Add/Remove Elements")
	public WebElement AddRemoveElementsLink;
	
	

}
