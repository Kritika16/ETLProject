package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import applicationPages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyHomePage {
	
	  
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception{
		
        driver = BrowserFactory.getBrowser("Firefox");
		
		driver.get(DataProviderFactory.getConfig().getPageURL());
	}
	
	@Test
	public void testHomePage(){
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Avactis Demo Store"));
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		
		BrowserFactory.closeBrowser(driver);
	}
	

}
