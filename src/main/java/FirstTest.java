import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {
    WebDriver driver;
    String baseURl = "https://courses.letskodeit.com/practice";

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void openPage(){
        driver.get(baseURl);
        //driver.findElement(By.xpath("//*[@id=\"navbar-inverse-collapse\"]/div/div/a")).click();
        //driver.findElement(By.linkText("SIGN IN"));
        driver.findElement(By.xpath("//*[@id=\"navbar-inverse-collapse\"]//a[@href=\"/login\"]")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("test123@test.io");
        driver.findElement(By.id("password")).sendKeys("12351test");
        driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/div/div/div/form/div[4]/div[1]/input")).click();
        driver.findElement(By.xpath("//span[@class=\"dynamic-text help-block\"]")).isDisplayed();
    }

}
