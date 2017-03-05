package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import applicationPages.HomePage;
import applicationPages.LogInPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPage {
	
	  
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception{
		
        driver = BrowserFactory.getBrowser("chrome");
		
		driver.get(DataProviderFactory.getConfig().getPageURL());
	}
	
	@Test
	public void testLoginPage() throws Exception{
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Avactis Demo Store"));
		
		home.clickOnLogin();
		
		LogInPage login = PageFactory.initElements(driver, LogInPage.class);
		
//		login.loginApplication(DataProviderFactory.getExcel().getData(0, 1, 0),DataProviderFactory.getExcel().getData(0, 1, 1));
		
		login.sendKeysEmailid(DataProviderFactory.getExcel().getData(0, 1, 0));
		login.sendKeysPassword(DataProviderFactory.getExcel().getData(0, 1, 1));
		
		login.clickLogin();
		
//		login.verifyDashboardTitle();
	}
	
	
	@AfterMethod
	public void tearDown(){
		
		BrowserFactory.closeBrowser(driver);
	}
	

}
