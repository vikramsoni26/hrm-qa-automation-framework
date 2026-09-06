package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	   @SuppressWarnings("unused")
	   private WebDriver driver;
       private WebDriverWait wait;

       private By userDropdown = By.xpath("//span[@class='oxd-userdropdown-tab']");
       private By logoutLink = By.xpath("//a[text()='Logout']");

       public DashboardPage(WebDriver driver) {
          this.driver = driver;
          this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

       public void logout() {

          wait.until(ExpectedConditions.elementToBeClickable(userDropdown))
                .click();

          wait.until(ExpectedConditions.elementToBeClickable(logoutLink))
                .click();
    }

    public boolean isLoginPageDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("username")
                )
        ).isDisplayed();
    }
	
	
	
}
