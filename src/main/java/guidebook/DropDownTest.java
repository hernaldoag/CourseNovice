package guidebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;

public class DropDownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp()throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void dropDownTest(){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdownlist = driver.findElement(By.id("dropdown"));

        List<WebElement> options = dropdownlist.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++){
            if (options.get(i).getText().equals("Option 1")){
                options.get(i).click();
            }
        }
        String selectedOption = "";
        for(int i = 0; i < options.size(); i++){
            if (options.get(i).isSelected()){
                selectedOption = options.get(i).getText();
            }
        }
        Assert.assertEquals(selectedOption, "Option 1");
        //   assertThat(selectedOption, is("Option 1"));
    }
}
