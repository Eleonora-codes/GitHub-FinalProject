package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePage extends BasePage {
    By avatarLocator = By.cssSelector(".Button-label .avatar.circle");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage(FirefoxDriver geckoDriver) {
        super(geckoDriver);
    }

    public boolean isDisplayed() {
        boolean isAvatarDisplayed = this.actions.isDisplayed(this.avatarLocator, 10);
        return isAvatarDisplayed;
    }
}
