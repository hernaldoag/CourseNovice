import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementState {
    WebDriver driver;
    String baseURl = "https://duckduckgo.com/";

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURl);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void ElementState(){
        WebElement e1 = driver.findElement(By.xpath("//*[@id=\"searchbox_homepage\"]/div/div/button"));
        System.out.println("E1 is enabled? " + e1.isEnabled());

    }
}
