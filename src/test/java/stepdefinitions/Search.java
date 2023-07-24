package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;


public class Search {
	WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	
	@Given("user opens the application")
	public void user_opens_the_application() {
		driver= DriverFactory.getDriver();

	}

	@When("user enters valid product {string} in the search field")
	public void user_enters_valid_product_in_the_search_field(String validProduct) {
		homePage= new HomePage(driver);
		
		homePage.enterTextInSearchBoxField(validProduct);
		//driver.findElement(By.name("search")).sendKeys(validProduct);
	   
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
		
		searchResultPage = homePage.clickOnSearchButton();
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	    
	}

	@Then("user should get valid product displayed in the search results")
	public void user_should_get_valid_product_displayed_in_the_search_results() {
		
		//SearchResultPage searchResult = new SearchResultPage(driver);//object created in 37
		Assert.assertTrue(searchResultPage.validProductDisplayed());
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	    
		Assert.fail();
	}
	
	@When("user enters invalid product {string} in the search field")
	public void user_enters_invalid_product_in_the_search_field(String invalidProduct) {
		
		homePage= new HomePage(driver);
		
		homePage.enterTextInSearchBoxField(invalidProduct);
		//driver.findElement(By.name("search")).sendKeys(invalidProduct);
	}
	
	@Then("user should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		Assert.assertEquals("There is no product that matches the search criteria.", searchResultPage.retrieveInvalidProductMessageText());
		//Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());
	    
	}
	
	@When("user dont enter any product in the search")
	public void user_dont_enter_any_product_in_the_search() {
		//intentionally kept blank
		homePage=new HomePage(driver);
	   
	}

}
