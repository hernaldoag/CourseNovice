package SauceDemoFiles.POM.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public static WebElement element = null;


    public static WebElement usernameTextField(WebDriver driver){
        element = driver.findElement(By.id("user-name"));
        return element;
    }

    public static WebElement passwordTextField(WebDriver driver){
        element = driver.findElement(By.id("password"));
        return element;
    }

    public static WebElement LoginButton(WebDriver driver){
        element = driver.findElement(By.id("login-button"));
        return element;
    }

    public static void clickOnLoginButton(WebDriver driver){
        element = LoginButton(driver);
        element.click();
    }

    public static void LogIn(WebDriver driver, String username, String password){
        usernameTextField(driver).sendKeys(username);
        passwordTextField(driver).sendKeys(password);
        LoginButton(driver);
        clickOnLoginButton(driver);
    }
}
