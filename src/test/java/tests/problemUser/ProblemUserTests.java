package tests.problemUser;

import components.SideBarComponent;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.*;
import tests.TestInit;

import static utils.UserData.PASSWORD;
import static utils.UserData.PROBLEM_USER_NAME;

public class ProblemUserTests extends TestInit {

    private String priceInInventory = "29.99";
    private String priceInItem = "49.99";

    @Test
    @Description("Negative: User order inventory as a problem user ")
    public void userOrderInventoryAsProblemUser() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage
                .setUsername(PROBLEM_USER_NAME)
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

        assertTrue(checkoutPage.getLastNameIsRequiredErrorMessage().getText().contains("Error: Last Name is required"),
                "Error message is not visible");
    }

    @Test
    @Description("Negative: User check the price as a problem user ")
    public void userCheckPriceAsProblemUser() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        InventoryItemPage inventoryItemPage = new InventoryItemPage(driver);

        loginPage
                .setUsername(PROBLEM_USER_NAME)
                .setPassword(PASSWORD)
                .clickLoginButton();

        String inventoryPrice = String.valueOf(inventoryPage.getFirstInventoryPrice(priceInInventory));
        String inventoryItemPrice = String.valueOf(inventoryItemPage.getItemPrice(priceInItem));

        inventoryPage
                .clickFirstInventory();


        assertNotEquals(inventoryPrice, inventoryItemPrice, "The price should be not equal");
    }

    @Test
    @Description("Negative: User check basket with inventory as a problem user ")
    public void userCheckInventoryBasketAsProblemUser() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        InventoryItemPage inventoryItemPage = new InventoryItemPage(driver);

        loginPage
                .setUsername(PROBLEM_USER_NAME)
                .setPassword(PASSWORD)
                .clickLoginButton();

        inventoryPage
                .clickFirstInventoryAddToCardButton()
                .clickInventoryBasketIcon();

        assertTrue(inventoryItemPage.isInventoryItemVisible(), "The item is not visible");
    }

    @Test
    @Description("Negative: User check about item in burger menu with inventory as a problem user ")
    public void userCheckAboutInBurgerMenuAsProblemUser() {
        LoginPage loginPage = new LoginPage(driver);
        SideBarComponent sideBarComponent = new SideBarComponent(driver);
        ErrorPage errorPage = new ErrorPage(driver);

        loginPage
                .setUsername(PROBLEM_USER_NAME)
                .setPassword(PASSWORD)
                .clickLoginButton();

        sideBarComponent
                .clickBurgerMenuButton()
                .clickAboutButton();

        assertTrue(getUrl("error/404"));

        errorPage.clickBackToHomeButton();

        assertTrue(getUrl("saucelabs.com"));
    }
}
