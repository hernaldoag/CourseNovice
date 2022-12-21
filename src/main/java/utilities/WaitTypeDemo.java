package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WaitTypes;
import java.time.Duration;

public class WaitTypeDemo {
    WebDriver driver;
    String baseURl = "https://courses.letskodeit.com/practice";
    WaitTypes wt;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wt = new WaitTypes(driver);
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void openPage(){
        driver.get(baseURl);
        //driver.findElement(By.xpath("//*[@id=\"navbar-inverse-collapse\"]/div/div/a")).click();
        WebElement loginLink = driver.findElement(By.linkText("SIGN IN"));
        loginLink.click();


        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement emailFields = wt.waitForElement(By.id("email"), 3);
        emailFields.sendKeys("test");
        //driver.findElement(By.id("email")).sendKeys("test");

    }
}
