package pages;

import elements.ErrorElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ErrorPage extends ErrorElements {
    public ErrorPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCookiesBannerDisplayed() {
        try {
            return getCookiesBanner().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Click back to home button")
    public ErrorPage clickBackToHomeButton() {
        if (isCookiesBannerDisplayed()) {
            try {
                getOkButton().click();
            } catch (Exception e) {
                System.out.println("Error clicking OK button: " + e.getMessage());
            }
        } else {
            try {
                getBackToHomeButton().click();
            } catch (Exception e) {
                System.out.println("Error clicking Back to Home button: " + e.getMessage());
            }
        }
        return this;
    }
}
