package hybridframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hybridframework.AbstarctComponents.AbstractComponent;

public class LandingPage extends AbstractComponent
	{

	WebDriver driver;

	public LandingPage(WebDriver driver) 
	{
		super(driver);
		//initialization
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//pagefactory

	@FindBy(id="userEmail")
	WebElement userEmail;

	@FindBy(id="userPassword")
	WebElement passwordEle;

	@FindBy(xpath="//input[@id = 'login']")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	

	public ProductCatalouge loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalouge ProductCatalouge = new ProductCatalouge(driver);
		return ProductCatalouge    ;
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}



