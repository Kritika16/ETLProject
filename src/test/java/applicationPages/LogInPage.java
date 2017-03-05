package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}
