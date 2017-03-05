package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dataProvider.ExcelDataProvider;

public class LogInPage {
	WebDriver driver;
	public LogInPage(WebDriver ldriver){
		this.driver =ldriver;
	}
	
	
	@FindBy(xpath = "//*[@id='account_sign_in_form_email_id']")
	WebElement inputEmailId;
	
	@FindBy(xpath = "//input[@class = 'input_checkbox']")
	WebElement inputCheckbox;

	@FindBy(xpath = ".//*[@id='account_sign_in_form_passwd_id']")
	WebElement inputPassword;
	
	@FindBy(xpath = "//input[@class = 'en btn color2 large pull-right input_submit']")
	WebElement loginButton;

	@FindBy(xpath="//a[text()=' Dashboard ']//following::div[2]")
	WebElement dashboardtitle;
	
	//input[@class = 'en btn color2 large pull-right input_submit']
	
	public void sendKeysEmailid(String username){
		inputEmailId.sendKeys(username);
	}
	
	public void sendKeysPassword(String password){
		inputPassword.sendKeys(password);
	}
	
	public void clickCheckBox(){
		inputCheckbox.click();
	}
	
	public void clickLogin(){
		loginButton.click();
	}

	public void verifyDashboardTitle(){
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(dashboardtitle));
		
		String text = ele.getText();
		
		Assert.assertEquals(text, "Account Dashboard View","Dashboard title not verified properly.");
	}
}
