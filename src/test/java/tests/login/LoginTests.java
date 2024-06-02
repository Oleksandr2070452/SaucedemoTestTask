package tests.login;

import components.SideBarComponent;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestInit;

import static utils.UserData.*;

public class LoginTests extends TestInit {

    @Test
    @Description("Happy path negative: standart user login")
    public void standartUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .setUsername(STANDART_USER_NAME)
                .setPassword(PASSWORD)
                .clickLoginButton();

        assertTrue(loginPage.getNoMatchesUserInServiceError().isDisplayed(), "Error message is not visible");
        assertTrue(loginPage.getNoMatchesUserInServiceError().getText().contains("Epic sadface" +
                        ": Username and password do not match any user in this service"),
                "Error message text is not visible");

    }

    @Test
    @Description("Happy path negative: locked out user login")
    public void lockedOutUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .setUsername(LOCKED_OUT_USER_NAME)
                .setPassword(PASSWORD)
                .clickLoginButton();

        assertTrue(loginPage.getNoMatchesUserInServiceError().isDisplayed(), "Error message is not visible");
        assertTrue(loginPage.getNoMatchesUserInServiceError().getText().contains("Epic sadface: Sorry, this user has been locked out."),
                "Error message text is not displayed");
    }

    @Test
    @Description("Happy path positive: problem user login")
    public void problemUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        SideBarComponent sideBarComponent = new SideBarComponent(driver);

        loginPage
                .setUsername(PROBLEM_USER_NAME)
                .setPassword(PASSWORD)
                .clickLoginButton();

        assertTrue(getUrl("/inventory.html"), "Endpoint is incorrect");

        sideBarComponent
                .clickBurgerMenuButton()
                .clickLogoutButton();

        assertTrue(getUrl("saucedemo.com/"));
    }

    @Test
    @Description("Happy path positive: performance glitch user login")
    public void performanceGlitchUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        SideBarComponent sideBarComponent = new SideBarComponent(driver);

        loginPage
                .setUsername(PERFORMANCE_GLITCH_USER_NAME)
                .setPassword(PASSWORD)
                .clickLoginButton();

        assertTrue(getUrl("/inventory.html"), "Endpoint is incorrect");
        assertTrue(getTitle("Swag Labs"));

        sideBarComponent
                .clickBurgerMenuButton()
                .clickLogoutButton();

        assertTrue(getUrl("saucedemo.com/"));
    }

    @Test
    @Description("Happy path positive: error user login")
    public void errorUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        SideBarComponent sideBarComponent = new SideBarComponent(driver);

        loginPage
                .setUsername(ERROR_USER_NAME)
                .setPassword(PASSWORD)
                .clickLoginButton();

        assertTrue(getUrl("/inventory.html"), "Endpoint is incorrect");
        assertTrue(getTitle("Swag Labs"));

        sideBarComponent
                .clickBurgerMenuButton()
                .clickLogoutButton();

        assertTrue(getUrl("saucedemo.com/"));
    }

    @Test
    @Description("Happy path positive: visual user login")
    public void visualUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        SideBarComponent sideBarComponent = new SideBarComponent(driver);

        loginPage
                .setUsername(VISUAL_USER_NAME)
                .setPassword(PASSWORD)
                .clickLoginButton();

        assertTrue(getUrl("/inventory.html"), "Endpoint is incorrect");
        assertTrue(getTitle("Swag Labs"));

        sideBarComponent
                .clickBurgerMenuButton()
                .clickLogoutButton();

        assertTrue(getUrl("saucedemo.com/"));


    }
}
