package SauceDemoFiles.Elements;

import SauceDemoFiles.POM.cart.CartPage;
import SauceDemoFiles.POM.cart.CheckoutStepOnePage;
import SauceDemoFiles.POM.cart.CheckoutStepTwoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import SauceDemoFiles.POM.login.*;

import java.time.Duration;

public class SauceLoginPOM {

    WebDriver driver;
    String demoURL = "https://www.saucedemo.com/";
    String demoInventory = "https://www.saucedemo.com/inventory.html";
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void testLogin(){
        driver.get(demoURL);
        LoginPage.usernameTextField(driver).sendKeys("standard_user");
        LoginPage.passwordTextField(driver).sendKeys("secret_sauce");
        //LoginPage.LoginButton(driver);
        LoginPage.clickOnLoginButton(driver);
        System.out.println("User is logged in");

        InventoryPage.addToCartSLBackPack(driver);
        InventoryPage.clickAddToCartSLBackPack(driver);
        InventoryPage.addToCartSLBoltTee(driver);
        InventoryPage.clickAddToCartSLBoltTee(driver);
        System.out.println("Items added");
    }

    @Test
    public void testLoginMethod()throws Exception{
        driver.get(demoURL);
        LoginPage.LogIn(driver, "standard_user","secret_sauce");
        //LoginPage.usernameTextField(driver).sendKeys("standard_user");
        //LoginPage.passwordTextField(driver).sendKeys("password");
        //LoginPage.LoginButton(driver);
        //LoginPage.clickOnLoginButton(driver);
        System.out.println("User is logged in");
        //driver.get(demoInventory);
        InventoryPage.addToCartSLBackPack(driver);
        InventoryPage.clickAddToCartSLBackPack(driver);
        Thread.sleep(10);
        System.out.println("backpack added");
        InventoryPage.addToCartSLBoltTee(driver);
        InventoryPage.clickAddToCartSLBoltTee(driver);
        System.out.println("Items added");
        InventoryPage.clickShoppingCart(driver);
        CartPage.clickCheckoutButton(driver);
        Thread.sleep(10);
        CheckoutStepOnePage.FillInAndContinue(driver, "herny", "sanchez", "90210");

        System.out.println("first check out completed");
        Thread.sleep(100);
        CheckoutStepTwoPage.clickFinish(driver);
        CheckoutStepTwoPage.CheckoutLabel(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
}
