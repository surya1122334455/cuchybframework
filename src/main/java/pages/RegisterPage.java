package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
public RegisterPage(WebDriver driver) {
	
	this.driver= driver;
	PageFactory.initElements(driver, this);
}

	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	public void enterFirstNameField(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	public void enterLastNameField(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public void enterEmailAdress(String emailText) {
		emailField.sendKeys(emailText);
}
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	public void enterTelephoneField(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	public void enterPasswordField(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	public void enterConfirmPasswordField(String confirmPasswordText) {
		confirmPasswordField.sendKeys(confirmPasswordText);
	}
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	public void selectPrivacyPolicy() {
		privacyPolicyOption.click();
	}
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	public AccountSuccessPage selectContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterButton;
	
	public void selectYesNewsLetterOption() {
		yesNewsLetterButton.click();
	}
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarningMessage;
	
	public String retrieveDuplicateEmailWarningMsg() {
		return duplicateEmailWarningMessage.getText();
	}
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement WarningMessage;
	
	public String retrieveWarningMessageText() {
		return WarningMessage.getText();
	}
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firtsNameWarning;
	
	public String retrieveFirstNameWarningText() {
		return firtsNameWarning.getText();
	}
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	public String retrieveLastNameWarningText() {
		return lastNameWarning.getText();
	}
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	public String retrieveEmailWarningText() {
		return emailWarning.getText();
	}
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	public String retrieveTelephoneWarningWarningText() {
		return telephoneWarning.getText();
	}
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public String retrievePasswordWarningWarningText() {
		return passwordWarning.getText();
	}
}