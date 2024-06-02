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
            getOkButton().click();
        } else {
            getBackToHomeButton().click();
        }
        return this;
    }

}
