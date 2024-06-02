package pages;

import elements.LoginElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginPage extends LoginElements {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Set username")
    public LoginPage setUsername(String username) {
        getUsernameInput().sendKeys(username);
        return this;
    }

    @Step("Set password")
    public LoginPage setPassword(String password) {
        getPasswordInput().sendKeys(password);
        return this;
    }

    @Step("Click login button")
    public LoginPage clickLoginButton() {
        getLoginButton().click();
        return this;
    }
}
