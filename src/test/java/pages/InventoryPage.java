package pages;

import elements.InventoryElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends InventoryElements {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click first inventory add to card button")
    public InventoryPage clickFirstInventoryAddToCardButton() {
        getFirstInventoryAddToCardButton().click();
        return this;
    }

    @Step("Click inventory basket icon")
    public InventoryPage clickInventoryBasketIcon() {
        getInventoryBasketIcon().click();
        return this;
    }

    @Step("Click first inventory")
    public InventoryPage clickFirstInventory() {
        getFirstInventory().click();
        return this;
    }

    @Step("Click filter container")
    public InventoryPage clickFilterContainer() {
        getFilterContainer().click();
        return this;
    }

    @Step("CLick alphabet Z-A filter option ")
    public InventoryPage clickAlphabetZAFilterOption() {
        getZAFilterOption().click();
        return this;
    }

    @Step("Click low to high price option")
    public InventoryPage clickFromLowToHighPriceOption() {
        getPriceFromLowToHigh().click();
        return this;
    }
}
