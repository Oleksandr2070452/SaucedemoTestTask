package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class CartElements extends BasePage {
    public CartElements(WebDriver driver) {
        super(driver);
    }

    public static final String CHECKOUT_BUTTON = "//button[@id='checkout']";

    protected WebElement getCheckoutButton() {
        return waitUntilElementToBeClickableByXpath(CHECKOUT_BUTTON);
    }
}
