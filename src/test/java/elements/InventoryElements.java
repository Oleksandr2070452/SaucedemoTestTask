package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class InventoryElements extends BasePage {
    public InventoryElements(WebDriver driver) {
        super(driver);
    }

    public static final String FIRST_INVENTORY_ADD_TO_CARD_BUTTON = "(//button[contains(@id, 'add-to-cart')])[1]";
    public static final String INVENTORY_BASKET_ICON = "//a[@data-test='shopping-cart-link']";
    public static final String FIRST_INVENTORY = "(//div[@data-test='inventory-item-name'])[1]";
    public static final String FIRST_INVENTORY_PRICE = "(//div[@data-test='inventory-item-price'])[1]";
    public static final String INVENTORY_CONTAINER = "//div[@data-test='inventory-list']";
    public static final String FILTER_CONTAINER = "//select[@data-test='product-sort-container']";
    public static final String Z_A_FILTER_OPTION = "//option[@value='za']";
    public static final String PRICE_LIST = "//div[@data-test='inventory-item-price']";
    public static final String FROM_LOW_TO_HIGH_PRICE_OPTION = "//option[@value='lohi']";

    protected WebElement getFirstInventoryAddToCardButton() {
        return waitUntilElementToBeVisibleByXpath(FIRST_INVENTORY_ADD_TO_CARD_BUTTON);
    }

    protected WebElement getInventoryBasketIcon() {
        return waitUntilElementToBeVisibleByXpath(INVENTORY_BASKET_ICON);
    }

    protected WebElement getFirstInventory() {
        return waitUntilElementToBeVisibleByXpath(FIRST_INVENTORY);
    }

    public boolean getFirstInventoryPrice(String price) {
        return waitUntilElementToBeVisibleByXpath(FIRST_INVENTORY_PRICE).getText().contains(price);
    }

    public List<String> getAllInventoryNames() {
        List<WebElement> inventoryNameElements = getListVisibilityOfElements(INVENTORY_CONTAINER);
        List<String> inventoryNames = new ArrayList<>();
        for (WebElement element : inventoryNameElements) {
            inventoryNames.add(element.getText());
        }
        return inventoryNames;
    }

    public List<Double> getAllInventoryPrices() {
        List<WebElement> inventoryPriceElements = getListVisibilityOfElements(PRICE_LIST);
        List<Double> inventoryPrices = new ArrayList<>();
        for (WebElement element : inventoryPriceElements) {
            String priceText = element.getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            inventoryPrices.add(price);
        }
        return inventoryPrices;
    }

    protected WebElement getFilterContainer() {
        return waitUntilElementToBeClickableByXpath(FILTER_CONTAINER);
    }

    protected WebElement getZAFilterOption() {
        return waitUntilElementToBeClickableByXpath(Z_A_FILTER_OPTION);
    }

    protected WebElement getPriceFromLowToHigh() {
        return waitUntilElementToBeVisibleByXpath(FROM_LOW_TO_HIGH_PRICE_OPTION);
    }
}
