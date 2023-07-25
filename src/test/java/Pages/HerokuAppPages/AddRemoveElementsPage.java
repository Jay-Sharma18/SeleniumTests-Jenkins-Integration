package Pages.HerokuAppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemoveElementsPage {
	
	public WebDriver driver;
	
	public AddRemoveElementsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id=\"content\"]/h3")
	public WebElement AddRemoveElementsHeadingText;
	
	@FindBy(xpath = "//button[contains(text(),'Add Element')]")
	public WebElement AddElementsButton;
	
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	public WebElement DeleteButton;
	
	
	


}
