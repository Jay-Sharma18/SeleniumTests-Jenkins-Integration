package Pages.SwagLabsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath="//input[contains(@id,'user-name')]")
	public WebElement userNameTextBox;
	
	@FindBy(xpath="//input[contains(@id,'password')]")
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//input[contains(@id,'login-button')]")
	public WebElement LoginButton;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[1]")
	public WebElement SwagLabsHeadingText;
	
	@FindBy(xpath="//button[contains(@class,'error-button')]")
	public WebElement LoginErrorButton;
	
	@FindBy(xpath="//span[contains(text(),'Products')]")
	public WebElement ProductsText;
	
}
