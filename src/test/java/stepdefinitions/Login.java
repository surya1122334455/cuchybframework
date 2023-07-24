package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


public class Login {
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	
	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
		driver= DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Login")).click();
		loginPage= homePage.clickOnLoginoption();
		}

	@When("^user enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
		//loginPage= new LoginPage(driver); because return type is created in above method
		loginPage.enterEmailAdress(emailText);
		//driver.findElement(By.id("input-email")).sendKeys(emailText);
	   
	}

	@And("^user enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {
		loginPage.enterPassword(passwordText);
		//driver.findElement(By.id("input-password")).sendKeys(passwordText);
	    
	}

	@And("user clicks on Login button")
	public void user_clicks_on_login_button() {
		accountPage = loginPage.clickOnLoginButton();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
	    
	}

	@Then("user should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
	    //accountPage =new AccountPage(driver);//object created in 47 line
		Assert.assertTrue(accountPage.displayStatusofEditYourAccountInformationOptions());
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	   
	}

	@When("user enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		//loginPage = new LoginPage(driver);//object created in 1st method
		loginPage.enterEmailAdress(CommonUtils.getEmailWithTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
	}

	@When("user enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String inavalidPasswordText) {
		loginPage.enterPassword(inavalidPasswordText);
		//driver.findElement(By.id("input-password")).sendKeys(inavalidPasswordText);
	}

	@Then("user should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		
		Assert.assertTrue(loginPage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	    
	}

	@When("user dont enters email address into email field")
	public void user_dont_enters_email_address_into_email_field() {
		//loginPage = new LoginPage(driver); //object created in 1st method
		loginPage.enterEmailAdress("");
		//driver.findElement(By.id("input-email")).sendKeys("");
	}

	@When("user dont enters  password into password field")
	public void user_dont_enters_password_into_password_field() {
		loginPage.enterPassword("");
		//driver.findElement(By.id("input-password")).sendKeys("");
	}

}
