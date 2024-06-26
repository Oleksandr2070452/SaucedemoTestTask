package components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class SideBarComponent extends BasePage {
    public SideBarComponent(WebDriver driver) {
        super(driver);
    }

    public static final String BURGER_MENU_BUTTON = "//button[@id='react-burger-menu-btn']";
    public static final String ABOUT_ITEM = "//a[@id='about_sidebar_link']";
    public static final String LOGOUT_ITEM = "//a[@id='logout_sidebar_link']";

    private WebElement getBurgerMenuButton() {
        return waitUntilElementToBeClickableByXpath(BURGER_MENU_BUTTON);
    }

    @Step("Click burger menu button")
    public SideBarComponent clickBurgerMenuButton() {
        getBurgerMenuButton().click();
        return this;
    }

    private WebElement getAboutButton() {
        return waitUntilElementToBeClickableByXpath(ABOUT_ITEM);
    }

    @Step("Click about button")
    public SideBarComponent clickAboutButton() {
        getAboutButton().click();
        return this;
    }

    private WebElement getLogoutButton() {
        return waitUntilElementToBeClickableByXpath(LOGOUT_ITEM);
    }

    @Step("Click logout button")
    public SideBarComponent clickLogoutButton() {
        getLogoutButton().click();
        return this;
    }
}
