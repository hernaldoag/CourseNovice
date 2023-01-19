package switchTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchFrame {
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
    public void switchToFrameName() throws Exception {
        driver.get(baseURl);
        driver.switchTo().frame("iframe-name");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search' and @name='course']"));
        searchBox.sendKeys("python");

        driver.switchTo().defaultContent();
        Thread.sleep(6000);
        driver.findElement(By.id("name")).sendKeys("Test Successful");

    }

    @Test
    public void switchToFrameID() throws Exception {
        driver.get(baseURl);
        driver.switchTo().frame("courses-iframe");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search' and @name='course']"));
        searchBox.sendKeys("python");

        driver.switchTo().defaultContent();
        Thread.sleep(6000);
        driver.findElement(By.id("name")).sendKeys("Test Successful");

    }

    @Test
    public void switchToFrameIndex() throws Exception {
        driver.get(baseURl);
        driver.switchTo().frame(0);
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search' and @name='course']"));
        searchBox.sendKeys("python");

        driver.switchTo().defaultContent();
        Thread.sleep(6000);
        driver.findElement(By.id("name")).sendKeys("Test Successful");

    }
}
