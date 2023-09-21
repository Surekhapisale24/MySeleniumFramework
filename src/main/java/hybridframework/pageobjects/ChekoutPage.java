package hybridframework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hybridframework.AbstarctComponents.AbstractComponent;

public class ChekoutPage extends AbstractComponent {
	WebDriver driver;
	public ChekoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}

	@FindBy(xpath = "//a[contains(@class, 'action__submit')]")
	WebElement submit;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")
	WebElement selectCountry;

	By results = By.xpath("//section[@class='ta-results list-group ng-star-inserted']");

	public void selectCountry(String countryName)
	{
		Actions act = new Actions(driver);
		act.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(results);
		selectCountry.click();
	}

	public  ConfirmationPage submitOrder()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", submit);
		return new ConfirmationPage(driver);
	}

}
