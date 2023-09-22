package pages;
import org.openqa.selenium.WebDriver;
import util.SeleniumActions;

public abstract class BasePage implements Loadable {
    protected WebDriver driver;
    protected SeleniumActions actions;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        this.actions = new SeleniumActions(this.driver);
    }

}
