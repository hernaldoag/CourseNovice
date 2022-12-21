package SauceDemoFiles.POM.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public static WebElement element = null;
    public static WebElement checkoutButton(WebDriver driver){
        element = driver.findElement(By.id("checkout"));
        return element;
    }

    public static void clickCheckoutButton(WebDriver driver){
        element = checkoutButton(driver);
        element.click();
    }
}
