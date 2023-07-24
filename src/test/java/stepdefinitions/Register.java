package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;


public class Register {
	
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	
	@Given("user navigates to register account page")
	public void user_navigates_to_register_account_page() {
		
		driver= DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		///driver.findElement(By.xpath("//span[text()='My Account']")).click();
		registerPage= homePage.selectRegisterOption();
		//driver.findElement(By.linkText("Register")).click();
	    
	}

	@When("user enters the details into the below fields")
	public void user_enters_the_details_into_the_below_fields(DataTable dataTable) {
	   Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	   
	   //registerPage = new RegisterPage(driver);//object created in previous method line 31.
	   
	   registerPage.enterFirstNameField(dataMap.get("firstName"));
	   //driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
	   registerPage.enterLastNameField(dataMap.get("lastName"));
	   //driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
	   registerPage.enterEmailAdress(CommonUtils.getEmailWithTimeStamp());
	   //driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
	   registerPage.enterTelephoneField(dataMap.get("telephone"));
	   //driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
	   registerPage.enterPasswordField(dataMap.get("password"));
	   //driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
	   registerPage.enterConfirmPasswordField(dataMap.get("password"));
	   //driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	}
	@When("user enters the details into the below fields with duplicate email")
	public void user_enters_the_details_into_the_below_fields_with_duplicate_email(DataTable dataTable) {
	   Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	   
	   //registerPage = new RegisterPage(driver);
	  
	   registerPage.enterFirstNameField(dataMap.get("firstName"));
	   //driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
	   registerPage.enterLastNameField(dataMap.get("lastName"));
	  //driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
	   registerPage.enterEmailAdress(dataMap.get("email"));
	   //driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
	   registerPage.enterTelephoneField(dataMap.get("telephone"));
	   //driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
	   registerPage.enterPasswordField(dataMap.get("password"));
	   //driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
	   registerPage.enterConfirmPasswordField(dataMap.get("password"));
	   //driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	}

	@When("user selects privacy policy")
	public void user_selects_privacy_policy() {
		registerPage.selectPrivacyPolicy();
		//driver.findElement(By.name("agree")).click();
	   
	}

	@When("clicks on continue button")
	public void clicks_on_continue_button() {
		accountSuccessPage= registerPage.selectContinueButton();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
	    
	}

	@Then("user account shoud be created successfully")
	public void user_account_shoud_be_created_successfully() {
		//check for junit Assert
		//accountSuccessPage = new AccountSuccessPage(driver);//object created 85
		Assert.assertEquals("Your Account Has Been Created!",accountSuccessPage.getPageHeading()) ;
		//Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//div[@id='content']/h1")).getText());
	}

	@When("user selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		
		//registerPage= new RegisterPage(driver);
		registerPage.selectYesNewsLetterOption();
	    //driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	}

	@Then("user should get a proper warning message about duplicate email")
	public void user_should_get_a_proper_warning_message_about_duplicate_email() {
		
		
		Assert.assertTrue(registerPage.retrieveDuplicateEmailWarningMsg().contains("Warning: E-Mail Address is already registered!"));
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));
	    
	}

	@When("user dont enters any details into fields")
	public void user_dont_enters_any_details_into_fields() {
		
		//registerPage= new RegisterPage(driver);
		//Intentionally kept blank 
	
	    
	}

	@Then("user should get a proper warning messages for every mandatory fields")
	public void user_should_get_a_proper_warning_messages_for_every_mandatory_fields() {
		Assert.assertTrue(registerPage.retrieveWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.retrieveFirstNameWarningText());
		//Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.retrieveLastNameWarningText());
		//Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.retrieveEmailWarningText());
		//Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.retrieveTelephoneWarningWarningText());
		//Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.retrievePasswordWarningWarningText());
		//Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());
		
	}

}
