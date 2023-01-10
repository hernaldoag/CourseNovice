package screenshots.course;

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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ScreenshotDemo {

    WebDriver driver;
    String baseURl = "https://es-la.facebook.com/";
    WaitTypes wt;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wt = new WaitTypes(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        String filename = getRandomString(10) + ".png";
        String directory = System.getProperty("user.dir") + "//screenshots//";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + filename));
        driver.quit();
        //Thread.sleep(3000);
    }

    @Test
    public void testScreenshots() throws Exception {
        driver.get(baseURl);
        driver.findElement(By.name("login")).click();
       // driver.findElement(By.id("//*[@id=\"u_0_5_nq\"]")).click();

    }

    public static String getRandomString(int lenght){

        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for(int i = 0; i< lenght; i++){
            int index = (int)(Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}
