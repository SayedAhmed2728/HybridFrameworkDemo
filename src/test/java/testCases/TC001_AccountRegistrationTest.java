package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {
	//public WebDriver driver;
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("starting TC001_AccountRegistrationTest");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on MyAccount link");
		hp.clickRegister();
		logger.info("clicked on Register link");
		
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		logger.info("providing customer details");
		regPage.setFirstName(randomeString().toUpperCase());
		regPage.setLastName(randomeString().toUpperCase());
		regPage.setEmail(randomeString()+"@gmail.com");
		regPage.setTelephone(randomeNumber());
		
		String password= randomeAlphaNumberic();//if confirm password is present then need to store value in a variable
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		regPage.setPrivacyPolicy();
		regPage.setClickContinue();
		
		logger.info("validating expected message");
		String confmsg=regPage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);

		}
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("finished TC001_AccountRegistrationTest");
		
	}
	
}
