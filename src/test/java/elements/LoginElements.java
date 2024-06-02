package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class LoginElements extends BasePage {
    public LoginElements(WebDriver driver) {
        super(driver);
    }

    public static final String USERNAME_INPUT = "//input[@id='user-name']";
    public static final String PASSWORD_INPUT = "//input[@id='password']";
    public static final String LOGIN_BUTTON = "//input[@id='login-button']";
    public static final String NOT_MATCH_ANY_USER_IN_SERVICE_ERROR_MESSAGE = "//h3[@data-test='error']";

    protected WebElement getUsernameInput() {
        return waitUntilElementToBeVisibleByXpath(USERNAME_INPUT);
    }

    protected WebElement getPasswordInput() {
        return waitUntilElementToBeVisibleByXpath(PASSWORD_INPUT);
    }

    protected WebElement getLoginButton() {
        return waitUntilElementToBeClickableByXpath(LOGIN_BUTTON);
    }

    public WebElement getNoMatchesUserInServiceError() {
        return waitUntilElementToBeVisibleByXpath(NOT_MATCH_ANY_USER_IN_SERVICE_ERROR_MESSAGE);
    }
}
