package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups={"Datadriven"})//getting dataprovider from different class
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("starting TC003_LoginDDT");

		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		/*Data is valid  - login success - test pass - logout
		Data is valid  - login failed - test fail
		
		Data is invalid  - login success - test fail - logout
		Data is invalid  - login failed - test pass
		*/
		
		if(exp.equalsIgnoreCase("Valid")) 
		{
			if(targetPage==true) 
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);}
		    }
		
		
		if(exp.equalsIgnoreCase("Invalid")) 
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);}
	        }
	     

        }catch(Exception e)
		{
			Assert.fail();
		}
       
		logger.info("finished TC003_LoginDDT");
}
}

	


