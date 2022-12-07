package demos;

import genericMethods.GenericMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementListDemo {

    private WebDriver driver;
    private String baseUrl;
    private GenericMethod gm;


    @BeforeMethod
    public void setUp() throws  Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/practice";
        gm = new GenericMethod(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


    @Test
    public void testMethod() throws Exception{
        driver.get(baseUrl);

        List<WebElement> element = gm.getElementList("//input[@type='text']", "xpath");
        int size = element.size();
        System.out.println("Size of element list is: " + size);

    }

    @AfterMethod
    public void tearDown() throws  Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
