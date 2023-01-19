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

public class WindowSize {
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
        long height  = (long) js.executeScript("return window.innerHeight;");
        long width  = (long) js.executeScript("return window.innerWidth;");
        System.out.println("Height is: " + height);
        System.out.println("Width is: "+ width);
    }


}
