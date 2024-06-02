package pages;

import elements.ErrorElements;
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

    public ErrorPage clickBackToHomeButton() {
        if (isCookiesBannerDisplayed()) {
            getOkButton().click();
        } else {
            getBackToHomeButton().click();
        }
        return this;
    }

}
