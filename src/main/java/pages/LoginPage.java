package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {


	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
//  Element library
	@FindBy(how = How.XPATH, using="//*[@id=\"username\"]")WebElement USER_NAME;
	@FindBy(how = How.XPATH, using="//*[@id=\"password\"]")WebElement PASSWORD;
	@FindBy(how = How.XPATH, using="/html/body/div/div/div/form/div[3]/button")WebElement SIGNIN_BUTTON;
	
// Methods to interact with the elements
	public void enterUserName(String userName) {
		USER_NAME.sendKeys(userName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void enterPassword(String password) {
		PASSWORD.sendKeys(password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void clickSignInButton() {
		SIGNIN_BUTTON.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
}
