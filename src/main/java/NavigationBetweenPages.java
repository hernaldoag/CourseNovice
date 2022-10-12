import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationBetweenPages {
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
    public void navigate() throws InterruptedException {
        driver.get(baseURl);
        String title = driver.getTitle();
        System.out.println("title of page is: " + title);

        String currentURL = driver.getCurrentUrl();

        System.out.println("Current url is: " + currentURL);

        String URLToNavigate = "https://courses.letskodeit.com/login";

        driver.navigate().to(URLToNavigate);
        currentURL = driver.getCurrentUrl();
        System.out.println("Current url is: " + currentURL);

        Thread.sleep(200);

        driver.navigate().back();
        currentURL = driver.getCurrentUrl();
        System.out.println("Current url is: " + currentURL);

        Thread.sleep(200);

        driver.navigate().forward();
        currentURL = driver.getCurrentUrl();
        System.out.println("Current url is: " + currentURL);

    }

}
