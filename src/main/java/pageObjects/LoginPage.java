package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	@SuppressWarnings("unused")
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	// Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By dashboardText = By.xpath("//h6[text()='Dashboard']");
    private By errorMessage = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
    
    // Constructor
    public LoginPage(WebDriver driver) {
    	this.driver = driver;
    	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    // Page actions
    public void enterUsername(String username) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField))
    	.sendKeys(username);
    	
    }
    
    public void enterPassword(String Password) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField))
        .sendKeys(Password);
    	
    }
    
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton))
                .click();
    }
    
    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText))
                .isDisplayed();
    }
	
    public boolean isErrorMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage))
                .isDisplayed();
    }
    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
