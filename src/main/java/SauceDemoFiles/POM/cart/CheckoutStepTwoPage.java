package SauceDemoFiles.POM.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepTwoPage {

    public static WebElement element = null;

    public static WebElement finish(WebDriver driver){
        element = driver.findElement(By.id("finish"));
        return element;
    }

    public static void clickFinish(WebDriver driver){
        element = finish(driver);
        element.click();
    }

    public static WebElement CheckoutLabel(WebDriver driver){
        element = driver.findElement(By.xpath("//*[contains(text(), 'Checkout: Complete!')]"));
        return element;
    }

    public static WebElement backHome(WebDriver driver){
        element = finish(driver);
        return element;
    }
}
