package SauceDemoFiles.POM.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepOnePage {
    public static WebElement element = null;

    public static WebElement firstName(WebDriver driver){
        element = driver.findElement(By.id("first-name"));
        return element;
    }
    public static WebElement lastName(WebDriver driver){
        element = driver.findElement(By.id("last-name"));
        return element;
    }

    public static WebElement zipCode(WebDriver driver){
        element = driver.findElement(By.id("postal-code"));
        return element;
    }

    public static WebElement continueButton(WebDriver driver){
        element = driver.findElement(By.id("continue"));
        return element;
    }

    public static void clickContinueButton(WebDriver driver){
        element = continueButton(driver);
        element.click();
    }

    public static void FillInAndContinue(WebDriver driver, String FirstName, String LastName, String postalCode ) {
        firstName(driver).sendKeys(FirstName);
        lastName(driver).sendKeys(LastName);
        zipCode(driver).sendKeys(postalCode);
        clickContinueButton(driver);
    }
}
