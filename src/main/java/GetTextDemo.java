import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetTextDemo {
    WebDriver driver;
    String baseURl = "https://courses.letskodeit.com/practice";

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURl);

    }

    @Test
    public void testGetText(){
        WebElement buttonElement = driver.findElement(By.id("opentab"));
        String elementText = buttonElement.getText();
        System.out.println("The text on element is: " + elementText);
    }

    @AfterMethod
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
