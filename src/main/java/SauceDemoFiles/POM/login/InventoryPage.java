package SauceDemoFiles.POM.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    public static WebElement element = null;
    WebDriver driver;

    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }
    public static WebElement addToCartSLBackPack(WebDriver driver){
        element = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        return element;
    }

    public static void clickAddToCartSLBackPack(WebDriver driver){
        element = addToCartSLBackPack(driver);
        element.click();
    }

    public static WebElement addToCartSLBoltTee(WebDriver driver){
        element = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        return element;
    }

    public static void clickAddToCartSLBoltTee(WebDriver driver){
        element = addToCartSLBoltTee(driver);
        element.click();
    }

    public static WebElement shoppingCart(WebDriver driver){
        element = driver.findElement(By.id("shopping_cart_container"));
        return element;
    }
    public static void clickShoppingCart(WebDriver driver){
        element = shoppingCart(driver);
        element.click();
    }
}
