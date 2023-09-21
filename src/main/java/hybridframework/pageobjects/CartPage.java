package hybridframework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hybridframework.AbstarctComponents.AbstractComponent;


public class CartPage extends AbstractComponent {
	WebDriver driver;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkoutEle;

	@FindBy(xpath = "//div[@class='cartSection']/h3")
	private List<WebElement> cartProducts;

	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyProductDisplay(String ProductName)
	{
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}

	public ChekoutPage goToCheckOut()
	{
		checkoutEle.click();
		return new ChekoutPage(driver);
	}

}
