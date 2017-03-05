package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationPages.HomePage;
import applicationPages.LogInPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPageWithReports {
	
	  
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp() throws Exception{
		
		report = new ExtentReports("C:\\Users\\Jay\\git\\ETLProject\\Reports\\LoginPageReport.html",true);
		
		logger = report.startTest("Verify Login Page");
		
		driver = BrowserFactory.getBrowser("Chrome");
		
		driver.get(DataProviderFactory.getConfig().getPageURL());
		
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void testLoginPage() throws Exception{
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Avactis Demo Store"));
		
		logger.log(LogStatus.PASS, "Home Page loaded and verified");
		
		home.clickOnLogin();
		
		logger.log(LogStatus.INFO, "Click on Login link");
		
		LogInPage login = PageFactory.initElements(driver, LogInPage.class);
		
//		login.loginApplication(DataProviderFactory.getExcel().getData(0, 1, 0),DataProviderFactory.getExcel().getData(0, 1, 1));

		login.sendKeysEmailid(DataProviderFactory.getExcel().getData(0, 1, 0));
		login.sendKeysPassword(DataProviderFactory.getExcel().getData(0, 1, 1));

		login.clickLogin();
		logger.log(LogStatus.INFO, "Login to application");
		
		login.verifyDashboardTitle();
		
		logger.log(LogStatus.PASS, "Dashboard Title verified.");
	}
	
	
	@AfterMethod
	public void tearDown(){
		
		BrowserFactory.closeBrowser(driver);
		
		report.endTest(logger);
		report.flush();
	}
	

}
