package switchTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Sliders {

    WebDriver driver;
    String baseURl = "https://jqueryui.com/slider/";
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
    public void testSlider() throws Exception {
        driver.get(baseURl);
        driver.switchTo().frame(0);
        Thread.sleep(3000);

        WebElement elementSlider  = driver.findElement(By.xpath("//div[@id='slider']/span"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(elementSlider, 100,0).perform();




    }
}
