package switchTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Switchto {

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
        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void testJSExecution() throws Exception {
        driver.get(baseURl);

       // WebElement searchBox = driver.findElement(By.id("search-courses"));

        //searchBox.sendKeys("python");

        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent: "+ parentHandle);

        WebElement openWindow = driver.findElement(By.id("openwindow"));
        openWindow.click();
        Set<String> handles = driver.getWindowHandles();
        for (String handle: handles){
            System.out.println(handle);
            if (!handle.equals(parentHandle)){
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                WebElement searchBox = driver.findElement(By.xpath("//*[@id='search' and @name='course']"));

                searchBox.sendKeys("python");
                Thread.sleep(2000);
                driver.close();
                break;
            }
        }
        driver.switchTo().window(parentHandle);
        driver.findElement(By.id("name")).sendKeys("Test Successful");

    }
}
