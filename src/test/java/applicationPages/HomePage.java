package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver ldriver){
		this.driver =ldriver;
	}
	
	@FindBy(xpath = "//span[text() = 'Home']")
	WebElement homepagelink;
	
	@FindBy(xpath = "//span[text() = 'My Account']")
	WebElement myAccount;
	
	@FindBy(xpath = "//span[text() = 'My Cart']")
	WebElement myCart;
	
	@FindBy(xpath = "//span[text() = 'Wishlist']")
	WebElement wishlist;
	
	@FindBy(xpath = "//span[text() = ' Log In']")
	WebElement logIn;
	
	public void clickonHomepageLink(){
		homepagelink.click();
	}
	
	public void clickOnMyAccount(){
		myAccount.click();
	}
	
	public void clickOnMyCart(){
		myCart.click();
	}
	
	public void clickOnWishlist(){
		wishlist.click();
	}
	
	public void clickOnLogin(){
		logIn.click();
	}

	public String getApplicationTitle() {
		// TODO Auto-generated method stub
		String applicationTitle = driver.getTitle();
		return applicationTitle;
	}
	
	
}
