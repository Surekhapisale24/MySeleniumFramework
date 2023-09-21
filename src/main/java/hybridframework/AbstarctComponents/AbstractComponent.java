package hybridframework.AbstarctComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hybridframework.pageobjects.CartPage;
import hybridframework.pageobjects.OrderPage;


public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}

	@FindBy(xpath = "(//button[@class='btn btn-custom'])[3]")
	WebElement cartHeader;
	
	@FindBy(xpath = "(//button[@class='btn btn-custom'])[2]")
	WebElement orderHeader;

	public void waitForElementToAppear(By findBy) {
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy) {
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	 
	public OrderPage goToOrdersPage()
	{
		orderHeader.click();
		OrderPage orderspage = new OrderPage(driver);
		return orderspage;
	}
	public void waitForElementToDisAppear(WebElement ele) throws InterruptedException
	{
		//This step is just only for this application to handle the traffic on webpage.
		//we are not going through the wait we are using here thread.sleep
		//bcoz its not real time ecomarce application so we go on like this
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
