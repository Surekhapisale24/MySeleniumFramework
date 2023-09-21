package hybridframework.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import hybridframework.TestComponents.BaseTest;
import hybridframework.TestComponents.Retry;


public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws IOException, InterruptedException
	{
	String ProductName = "ZARA COAT 3";
	landingpage.loginApplication("surekhapisale@gmail.com", "shivaji");
	Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	
	}
}
 