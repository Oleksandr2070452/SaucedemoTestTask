package heplers;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;

public class Randomizers {
    private static final Faker faker = new Faker();

    public static void randomFistName(WebElement element) {
        String randomName = faker.name().firstName();
        element.sendKeys(randomName);
    }

    public static void randomLastName(WebElement element) {
        String randomName = faker.name().lastName();
        element.sendKeys(randomName);
    }

    public static void randomNumber(WebElement element) {
        String randomNumber = faker.number().digits(5);
        element.sendKeys(randomNumber);
    }

}
