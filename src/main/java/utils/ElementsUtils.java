package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtils {
	
	WebDriver driver;
	
	public ElementsUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnElement(WebElement element, long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
	}
	
	public void typeTextIntoElement(WebElement element,String textToBeTyped, long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webElement;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		return webElement;
	}
	
	
}
