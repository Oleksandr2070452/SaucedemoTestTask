package pages;

import elements.CartElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CartPage extends CartElements {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click checkout button")
    public CartPage clickCheckoutButton() {
        getCheckoutButton().click();
        return this;
    }
}
