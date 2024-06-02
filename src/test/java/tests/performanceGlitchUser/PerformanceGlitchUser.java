package tests.performanceGlitchUser;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import tests.TestInit;

import java.util.Iterator;
import java.util.List;

import static utils.UserData.PASSWORD;
import static utils.UserData.PERFORMANCE_GLITCH_USER_NAME;

public class PerformanceGlitchUser extends TestInit {

    @Test
    @Description("Negative: User order inventory as a performance glitch user ")
    public void userOrderInventoryAsPerformanceGlitchUser() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.setUsername(PERFORMANCE_GLITCH_USER_NAME).setPassword(PASSWORD).clickLoginButton();

        inventoryPage.clickFirstInventoryAddToCardButton().clickInventoryBasketIcon();

        cartPage.clickCheckoutButton();

        checkoutPage.setFirstNameInput().setLastNameInput().setPostCodeInput().clickContinueButton();

        assertTrue(checkoutPage.getLastNameIsRequiredErrorMessage().getText().contains("Error: Postal Code is required"), "Error message is not visible");
    }

    @Test
    @Description("Negative: User filter by alphabet inventory as a performance glitch user ")
    public void userFilterInventoriesByAlphabetAsPerformanceGlitchUser() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.setUsername(PERFORMANCE_GLITCH_USER_NAME).setPassword(PASSWORD).clickLoginButton();

        inventoryPage.clickFilterContainer().clickAlphabetZAFilterOption();

        List<String> inventoryNames = inventoryPage.getAllInventoryNames();

        Iterator<String> iter = inventoryNames.iterator();
        String currentItem = iter.next();
        while (iter.hasNext()) {
            String nextItem = iter.next();

            assertTrue(currentItem.compareTo(nextItem) >= 0, "Inventories are not sorted correctly");
        }

    }

    @Test
    @Description("Negative: User filter by price inventory as a performance glitch user ")
    public void userFilterInventoriesByPriceAsPerformanceGlitchUser() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage
                .setUsername(PERFORMANCE_GLITCH_USER_NAME)
                .setPassword(PASSWORD)
                .clickLoginButton();

        inventoryPage
                .clickFilterContainer()
                .clickFromLowToHighPriceOption();
        List<Double> inventoryPrices = inventoryPage.getAllInventoryPrices();

        Iterator<Double> iter = inventoryPrices.iterator();
        Double currentPrice = iter.next();
        while (iter.hasNext()) {
            Double nextPrice = iter.next();

            assertTrue(currentPrice <= nextPrice, "Inventories are not sorted by low to high price");
        }
    }
}
