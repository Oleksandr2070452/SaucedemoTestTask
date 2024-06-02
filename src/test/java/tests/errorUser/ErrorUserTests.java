package tests.errorUser;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import tests.TestInit;

import static utils.UserData.ERROR_USER_NAME;
import static utils.UserData.PASSWORD;

public class ErrorUserTests extends TestInit {

    @Test
    @Description("Negative: User order inventory as a error user ")
    public void userOrderInventoryAsErrorUser() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage
                .setUsername(ERROR_USER_NAME)
                .setPassword(PASSWORD)
                .clickLoginButton();

        inventoryPage
                .clickFirstInventoryAddToCardButton()
                .clickInventoryBasketIcon();

        cartPage
                .clickCheckoutButton();

        checkoutPage
                .setFirstNameInput()
                .setLastNameInput()
                .setPostCodeInput()
                .clickContinueButton();

        assertTrue(checkoutPage.getLastNameIsRequiredErrorMessage().getText().contains("Error: Postal Code is required"),
                "Error message is not visible");
    }

    @Test
    @Description("Negative: User order inventory as a error user ")
    public void userCheckFilteringAsErrorUser() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage
                .setUsername(ERROR_USER_NAME)
                .setPassword(PASSWORD)
                .clickLoginButton();

        inventoryPage
                .clickFilterContainer()
                .clickAlphabetZAFilterOption();

        assertTrue(isAlertVisible(), "Alert is not appear");

        acceptAlert();
    }
}
