package hybridframework.tests;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hybridframework.TestComponents.BaseTest;
import hybridframework.pageobjects.CartPage;
import hybridframework.pageobjects.ChekoutPage;
import hybridframework.pageobjects.ConfirmationPage;
import hybridframework.pageobjects.OrderPage;
import hybridframework.pageobjects.ProductCatalouge;

public class SubmitOrderTest extends BaseTest {

		String ProductName = "ZARA COAT 3";
		@Test(dataProvider="getData",groups= {"Purchase"})
		public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
		{
		ProductCatalouge ProductCatalouge = landingpage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = ProductCatalouge.getProductList();
		ProductCatalouge.addProductToCart(input.get("products"));
		CartPage cartpage = ProductCatalouge.goToCartPage();
		Boolean match = cartpage.verifyProductDisplay(input.get("products"));
		Assert.assertTrue(match);
		ChekoutPage ChekoutPage = cartpage.goToCheckOut();
		ChekoutPage.selectCountry("india");
		ConfirmationPage confirmationpage = ChekoutPage.submitOrder();
		String confirmMessage = confirmationpage.getConfirmationMassege();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
		@Test(dependsOnMethods= {"submitOrder"})
		public void ordeHistoryTest()
		{
			ProductCatalouge ProductCatalouge = landingpage.loginApplication("surekhapisale@gmail.com", "Surekha@24");
			OrderPage orderspage = ProductCatalouge.goToOrdersPage();
			Assert.assertTrue(orderspage.verifyOrderDisplay(ProductName));
		}
		
		
		//DataProvider also accept HashMap
		@DataProvider
		public Object[][] getData() throws IOException
		
		{
			List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//hybridframework//data//PurchaseOrder.json");
			return new Object[] [] {{data.get(0)},{data.get(1)}};
		}
		
		
//DataProvider with 2D Array
		
//		@DataProvider
//		public Object[][] getData()
//		{
//			return new Object[] [] {{"surekhapisale@gmail.com", "Surekha@24","ZARA COAT 3"}, {"surekhapisale25@gmail.com","Surekha@25","ZARA COAT 3"}};
//		}
		
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "surekhapisale@gmail.com");
//		map.put("password", "Surekha@24");
//		map.put("products", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "surekhapisale25@gmail.com");
//		map1.put("password", "Surekha@25");
//		map1.put("products", "ZARA COAT 3");
}
