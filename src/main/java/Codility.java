import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.junit.Test;

import java.util.List;

public class Codility {
    WebDriver driver;
    String baseURl = "https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_search/6f03f4361b080eeb747193aadd94cd2b/static/attachments/reference_page.html";

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
    public void DropDownTest() throws Exception {
        driver.navigate().to("http://the-internet.herokuapp.com/dropdown");
        List<WebElement> elementsDrop = driver.findElements(By.xpath("//*[@id=\"dropdown\"]"));

        for (WebElement options : elementsDrop) {
            System.out.println("Let's try this");
            if (options.getText() == "Option 2") {
                options.click();
                Thread.sleep(2000);
                System.out.println(options.getText());
            }
            System.out.println(options.getText());
        }
    }


}
