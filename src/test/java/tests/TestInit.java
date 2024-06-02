package tests;

import listeners.TestListeners;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListeners.class)
public class TestInit extends Assert {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quitTest() {
        driver.quit();
    }

    public boolean getUrl(String endpoint) {
        return driver.getCurrentUrl().contains(endpoint);
    }

    public boolean getTitle(String title) {
        return driver.getTitle().contains(title);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public boolean isAlertVisible() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}