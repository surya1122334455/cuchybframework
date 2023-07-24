package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);//this here refers to initialize webelement of this current class
		
	}
	
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	public LoginPage clickOnLoginoption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	public void enterTextInSearchBoxField(String searchProduct) {
		searchBoxField.sendKeys(searchProduct);
	}
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public SearchResultPage clickOnSearchButton(){
		searchButton.click();
		return new SearchResultPage(driver);

	}
}
