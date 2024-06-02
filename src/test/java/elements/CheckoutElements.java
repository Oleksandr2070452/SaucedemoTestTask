package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class CheckoutElements extends BasePage {
    public CheckoutElements(WebDriver driver) {
        super(driver);
    }

    public static final String FIRST_NAME_INPUT = "//input[@id='first-name']";
    public static final String LAST_NAME_INPUT = "//input[@id='last-name']";
    public static final String POST_CODE_INPUT = "//input[@id='last-name']";
    public static final String CONTINUE_BUTTON = "//input[@id='continue']";
    public static final String LAST_NAME_IS_REQUIRED_ERROR_MESSAGE = "//h3[@data-test='error']";

    protected WebElement getFirstNameInput() {
        return waitUntilElementToBeVisibleByXpath(FIRST_NAME_INPUT);
    }

    protected WebElement getLastNameInput() {
        return waitUntilElementToBeVisibleByXpath(LAST_NAME_INPUT);
    }

    protected WebElement getPostCodeInput() {
        return waitUntilElementToBeVisibleByXpath(POST_CODE_INPUT);
    }

    protected WebElement getContinueButton() {
        return waitUntilElementToBeClickableByXpath(CONTINUE_BUTTON);
    }

    public WebElement getLastNameIsRequiredErrorMessage() {
        return waitUntilElementToBeVisibleByXpath(LAST_NAME_IS_REQUIRED_ERROR_MESSAGE);
    }
}
