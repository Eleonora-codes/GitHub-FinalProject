import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import util.SeleniumActions;
import util.WebDriverUtil;

public class GitHubLoginTest {
    private WebDriver driver;

    public GitHubLoginTest() {
    }

    @Test
    public void validLoginEntering() {
        driver = WebDriverUtil.getWebDriver();
        driver.get("https://github.com/login");

        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.login("katejpxpress@gmail.com", "Elin/1234");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isDisplayed());

        WebDriverUtil close = new WebDriverUtil();
        WebDriverUtil.closeDriver();
    }

    @Test
    public void avatarChecking() {
        driver = WebDriverUtil.getWebDriver();
        driver.get("https://github.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("katejpxpress@gmail.com", "Elin/1234");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isDisplayed());

        WebElement avatarElement = driver.findElement(By.cssSelector("img[height ='32']"));
        avatarElement.click();
        Assert.assertTrue(avatarElement.isDisplayed());

        WebDriverUtil close = new WebDriverUtil();
        WebDriverUtil.closeDriver();

    }

    @Test
    public void invalidPasswordEntering() {
        driver = WebDriverUtil.getWebDriver();
        driver.get("https://github.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("katejpxpress@gmail.com", "tsrdytf");

        HomePage homePage = new HomePage(driver);
        Assert.assertFalse(homePage.isDisplayed());

        WebDriverUtil close = new WebDriverUtil();
        WebDriverUtil.closeDriver();
    }

    @Test
    public void emptyPasswordChecking() {
       driver = WebDriverUtil.getWebDriver();
        driver.get("https://github.com/login");

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isDisplayed());

        loginPage.login("katejpxpress@gmail.com", " ");
        HomePage homePage = new HomePage(driver);

        Assert.assertFalse(homePage.isDisplayed());
        driver.quit();
    }

    @Test
    public void validLoginEntering1() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://github.com/login");

        By locatorOfAvatarElement3 = By.cssSelector("svg[ height = '48']");
        SeleniumActions actions3 = new SeleniumActions(driver);

        boolean isLocatorOfAvatar3ElementDisplayed = actions3.isDisplayed(locatorOfAvatarElement3, 5);
        Assert.assertTrue(isLocatorOfAvatar3ElementDisplayed);

        LoginPage loginPage1 = new LoginPage(driver);
        loginPage1.login("katejpxpress@gmail.com", "Elin/1234");

        By locatorOfAvatarElement1 = By.cssSelector("svg[height = '32']");
        SeleniumActions actions1 = new SeleniumActions(driver);
        boolean isLocatorOfAvatarElement1Displayed = actions1.isDisplayed(locatorOfAvatarElement1, 5);
        Assert.assertTrue(isLocatorOfAvatarElement1Displayed);

        WebElement dashboardElement = driver.findElement(By.className("AppHeader-context-item-label"));
        Assert.assertEquals(dashboardElement.getText(), "Dashboard");
        driver.quit();
    }

    @Test
    public void avatarChecking1() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://github.com/login");

        LoginPage loginPage1 = new LoginPage(driver);
        loginPage1.login("katejpxpress@gmail.com", "Elin/1234");

        WebElement avatarElement = driver.findElement(By.cssSelector("img[height ='32']"));
        avatarElement.click();

        WebElement setStatusElement = driver.findElement(By.cssSelector("span[data-view-component='true']"));
        By locatorOfAvatarElement1 = By.cssSelector(".Button-label .avatar.circle");
        SeleniumActions actions1 = new SeleniumActions(driver);
        boolean isLocatorOfAvatarElement1Displayed = actions1.isDisplayed(locatorOfAvatarElement1, 5);
        Assert.assertTrue(isLocatorOfAvatarElement1Displayed);

        WebElement userElement = driver.findElement(By.xpath("//div/div//span [ @class='Truncate-text' ] "));
        Assert.assertEquals(userElement.getText(), "AlreadyKnown-User");
        driver.quit();
    }

    @Test
    public void invalidPasswordEntering1() {
        driver = WebDriverUtil.getWebDriver();
        driver.get("https://github.com/login");

        By locatorOfAvatarElement3 = By.cssSelector("svg[ height = '48']");
        SeleniumActions actions3 = new SeleniumActions(driver);

        actions3.isDisplayed(locatorOfAvatarElement3, 5);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("katejpxpress@gmail.com", ",fhygukh ");
        boolean variable = actions3.isDisplayed(By.className("js-flash-alert"), 10);
        Assert.assertTrue(variable);

        WebElement errorElement = driver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        driver.quit();
    }

    @Test
    public void emptyPasswordChecking1() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://github.com/login");

        By locatorOfAvatarElement3 = By.cssSelector("svg[ height = '48']");
        SeleniumActions actions3 = new SeleniumActions(driver);

        boolean isLocatorOfAvatar3ElementDisplayed = actions3.isDisplayed(locatorOfAvatarElement3, 5);
        Assert.assertTrue(isLocatorOfAvatar3ElementDisplayed);

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isDisplayed());
        loginPage.login("katejpxpress@gmail.com", " ");

        boolean variable = actions3.isDisplayed(By.className("js-flash-alert"), 10);
        Assert.assertTrue(variable);

        WebElement errorElement = driver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }

    }
}