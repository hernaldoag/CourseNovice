package windowSize;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WaitTypes;

import java.io.File;
import java.time.Duration;

public class ScrollDemo {
    WebDriver driver;
    String baseURl = "https://courses.letskodeit.com/practice";
    // WaitTypes wt;

    private JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        /*
        String filename = getRandomString(10) + ".png";
        String directory = System.getProperty("user.dir") + "//screenshots//";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + filename));
        */

        driver.quit();
        //Thread.sleep(3000);
    }

    @Test
    public void testScreenshots() throws Exception {
        js.executeScript("window.location = 'https://courses.letskodeit.com/practice';");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 1900);");
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0, -1900);");
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.id("mousehover"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);


    }
}
