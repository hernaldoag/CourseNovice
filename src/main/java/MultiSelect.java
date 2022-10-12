import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MultiSelect {
        WebDriver driver;
        String baseUrl = "https://courses.letskodeit.com/practice";

        @BeforeMethod
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @AfterMethod
        public void tearDown() throws Exception{
            Thread.sleep(2000);
            driver.quit();}

        @Test
        public void MultiSelect() throws  Exception{
            driver.get(baseUrl);
            WebElement element = driver.findElement(By.id("multiple-select-example"));
            Select selection = new Select(element);

            Thread.sleep(2000);
            System.out.println("Select Orange by value");
            selection.selectByValue("orange");

            Thread.sleep(2000);
            System.out.println("De-select orange by Value");
            selection.deselectByValue("orange");

            Thread.sleep(2000);
            System.out.println("select peach by index");
            selection.selectByIndex(2);

            Thread.sleep(2000);
            System.out.println("Select apple by Visible Text");
            selection.selectByVisibleText("Apple");

            Thread.sleep(2000);
            System.out.println("All selected options");
            List<WebElement> selectedItems = selection.getAllSelectedOptions();
            for(WebElement option : selectedItems){
                System.out.println("This values is selected: " + option.getText());
            }

            Thread.sleep(2000);
            System.out.println("De-select all selected options");
            selection.deselectAll();

        }


}
