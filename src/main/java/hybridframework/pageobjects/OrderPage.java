package hybridframework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hybridframework.AbstarctComponents.AbstractComponent;


public class OrderPage extends AbstractComponent {
	WebDriver driver;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkoutEle;

	@FindBy(xpath = "//tr/td[text()='zara coat 3']")
	private List<WebElement> ProductNames;

	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyOrderDisplay(String ProductName)
	{
		Boolean match = ProductNames.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}
}
