package switchTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class jsPopup {

    WebDriver driver;
    String baseURl = "https://courses.letskodeit.com/practice";
    // WaitTypes wt;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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

        driver.findElement(By.id("name")).sendKeys("Herny");
       driver.findElement(By.id("alertbtn")).click();
       Thread.sleep(3000);
       Alert alert = driver.switchTo().alert();
       alert.accept();



    }

    @Test
    public void switchToAlertCancel() throws Exception {
        driver.get(baseURl);

        driver.findElement(By.id("name")).sendKeys("Herny");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();



    }
}
