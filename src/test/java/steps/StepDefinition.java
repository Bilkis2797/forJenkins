package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.DataBasePage;
import pages.LoginPage;
import pages.TestBase;

public class StepDefinition extends TestBase {

	LoginPage loginPage;
	DataBasePage dataBasePage;

	@Before
	public void beforeRun() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		dataBasePage = new DataBasePage();
	}

	@Given("User is on the techfios login page")
	public void user_is_on_the_techfios_login_page() {
		driver.get("http://www.techfios.com/billing/?ng=admin/");

	}

	@When("User enters username as {string}")
	public void user_enters_username_as(String userName) {
		loginPage.enterUserName(userName);
	}

	@When ("User enters {string} from mysql database")
	public void user_enters_from_mysql_database(String logindata) {
		if(logindata.equalsIgnoreCase("userName")) {
			System.out.println("Username from Db: "+ dataBasePage.getDataFromDb("userName"));
			loginPage.enterUserName(dataBasePage.getDataFromDb("userName"));
		}else if(logindata.equalsIgnoreCase("password")) {
			System.out.println("Password from Db: "+ dataBasePage.getDataFromDb("password"));
			loginPage.enterPassword(dataBasePage.getDataFromDb("password"));
		}else {
			System.out.println("User data:"+ logindata+ " is not valid!");
		}
	

//	switch(logindata) {
//	case "userName":
//		loginPage.enterUserName(dataBasePage.getDataFromDb("userName"));
//		break;
//	case "password":
//		loginPage.enterPassword(dataBasePage.getDataFromDb("password"));
//		break;
//	default:
//		System.out.println("User data:"+ logindata+ " is not valid!");
//	}
		
	}
	@When("User enters password as {string}")
	public void user_enters_password_as(String password) {
		loginPage.enterPassword(password);
	}

	@When("User clicks on signin button")
	public void user_clicks_on_signin_button() {
		loginPage.clickSignInButton();
	}

	@Then("User should land on dashboard page")
	public void user_should_land_on_dashboard_page() {
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);

		takeScreenshot(driver);
	}

	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
