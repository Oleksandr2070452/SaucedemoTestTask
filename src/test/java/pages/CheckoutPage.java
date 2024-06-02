package pages;

import elements.CheckoutElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static heplers.Randomizers.*;

public class CheckoutPage extends CheckoutElements {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Set first name input")
    public CheckoutPage setFirstNameInput() {
        randomFistName(getFirstNameInput());
        return this;
    }

    @Step("Set last name input")
    public CheckoutPage setLastNameInput() {
        randomLastName(getLastNameInput());
        return this;
    }

    @Step("Set post code input")
    public CheckoutPage setPostCodeInput() {
        randomNumber(getPostCodeInput());
        return this;
    }

    @Step("Click continue button")
    public CheckoutPage clickContinueButton() {
        getContinueButton().click();
        return this;
    }
}
