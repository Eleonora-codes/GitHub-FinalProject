
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class LoginPage extends BasePage {
    By emailFieldLocator = By.name("login");
    By passwordFieldLocator = By.name("password");
    By loginButtonLocator = By.name("commit");

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    public void login(String email, String password) {
        WebElement emailElement = this.driver.findElement(this.emailFieldLocator);
        emailElement.sendKeys(new CharSequence[]{email});
        WebElement passwordElement = this.driver.findElement(this.passwordFieldLocator);
        passwordElement.sendKeys(new CharSequence[]{password});
        WebElement buttonElement = this.driver.findElement(this.loginButtonLocator);
        buttonElement.click();
    }

    public boolean isDisplayed() {
        boolean isLoginButtonDisplayed = this.actions.isDisplayed(this.loginButtonLocator, 10);
        return isLoginButtonDisplayed;
    }
}
