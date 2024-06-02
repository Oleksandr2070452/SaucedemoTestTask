package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ErrorElements extends BasePage {
    public ErrorElements(WebDriver driver) {
        super(driver);
    }

    public static final String BACK_TO_HOME_BUTTON = "//button[text()='Return to home']";
    public static final String COOKIES_BANNER = "//div[@id='onetrust-banner-sdk']";
    public static final String ACCEPT_COOKIES_OK_BUTTON = "//button[@id='onetrust-accept-btn-handler']";

    protected WebElement getBackToHomeButton() {
        return waitUntilElementToBeClickableByXpath(BACK_TO_HOME_BUTTON);
    }

    public WebElement getCookiesBanner() {
        return waitUntilElementToBePresenceByXpath(COOKIES_BANNER);
    }

    public WebElement getOkButton() {
        return waitUntilElementToBeClickableByXpath(ACCEPT_COOKIES_OK_BUTTON);
    }
}
