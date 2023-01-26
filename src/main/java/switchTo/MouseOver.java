package switchTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseOver {
    WebDriver driver;
    String baseURl = "https://courses.letskodeit.com/practice";
    // WaitTypes wt;
    JavascriptExecutor jse;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        jse = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void switchToAlertAccept() throws Exception {
        driver.get(baseURl);
        jse.executeScript("window.scrollBy(0,600)");
        Thread.sleep(3000);
        WebElement mainElement = driver.findElement(By.id("mousehover"));
        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        Thread.sleep(3000);

        WebElement subelement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
        action.moveToElement(subelement).click().perform();
        //subelement.click();
        Thread.sleep(3000);




    }
}
