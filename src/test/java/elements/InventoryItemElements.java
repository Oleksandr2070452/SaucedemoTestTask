package elements;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class InventoryItemElements extends BasePage {
    public InventoryItemElements(WebDriver driver) {
        super(driver);
    }

    public static final String ITEM_PRICE = "//div[@data-test='inventory-item-price']";
    public static final String INVENTORY_ITEM = "//div[@data-test='inventory-item']";

    public boolean getItemPrice(String price) {
        return waitUntilElementToBeVisibleByXpath(ITEM_PRICE).getText().contains(price);
    }

    public boolean isInventoryItemVisible() {
        return waitUntilElementToBePresenceByXpath(INVENTORY_ITEM).isDisplayed();
    }
}
