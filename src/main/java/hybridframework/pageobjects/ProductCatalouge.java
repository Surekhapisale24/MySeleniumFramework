package hybridframework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hybridframework.AbstarctComponents.AbstractComponent;

public class ProductCatalouge extends AbstractComponent
	{

	WebDriver driver;

	public ProductCatalouge(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}

	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;

	@FindBy(css=".ng-animating")
	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.xpath("(//div/button[contains(@class, 'btn w-10 rounded')])[1]");
	By tostMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductByName(String ProductName)
	{
	WebElement prod = getProductList().stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
	return prod;
	}

	public void addProductToCart(String ProductName) throws InterruptedException
	{
		WebElement prod = getProductByName(ProductName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(tostMessage);
		waitForElementToDisAppear(spinner);
	}
}



