import genericMethods.GenericMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GenericMethodDemo {

    private WebDriver driver;

    private String baseURL;

    private GenericMethod gm;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL = "https://courses.letskodeit.com/practice";
        gm = new GenericMethod(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void testMethod(){
        driver.get(baseURL);
        WebElement element = gm.getElement("name", "id");
       element.sendKeys("test");
    }


    @Test
    public void testMethodElements() throws  Exception {
        driver.get(baseURL);
        List<WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");

        int size = elementList.size();
        System.out.println("size of element list is: " + size);
    }

    @AfterMethod
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
