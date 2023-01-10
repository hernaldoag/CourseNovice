package expediaSite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WaitTypes;

import java.util.List;

public class AutoComplete {
    WebDriver driver;
    String baseURl = "https://www.goibibo.com/";
    WaitTypes wt;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wt = new WaitTypes(driver);
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void tearDown() throws Exception{
        //driver.quit();
        Thread.sleep(3000);
    }

    @Test
    public void testAutoComplete() throws Exception {
        driver.get(baseURl);
        String partialText = "tor";
       // String optionToSelect = "Toronto, Canada ";
        String optionExtra = "(YTO)";
        //driver.findElement(By.xpath("//*[@id=\"navbar-inverse-collapse\"]/div/div/a")).click();
        Thread.sleep(3000);
        WebElement search =  driver.findElement(By.xpath("//*[@class='sc-ksdxgE dvdvQX fswFld ']"));
        search.click();
        //*[@id="root"]/div[4]/div/div/div[1]/div[1]/div/div[2]/div/input
        //WebElement searchField =  driver.findElement(By.xpath("//*[@class='sc-jJoQJp echhfS']"));
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[1]/div/div[2]/div/input"));
        Thread.sleep(3000);
        searchField.sendKeys(partialText);
        Thread.sleep(3000);
        WebElement ulElement = driver.findElement(By.id("autoSuggest-list"));
        String innerHTML = ulElement.getAttribute("innerHTML");
        System.out.println(innerHTML);
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        Thread.sleep(3000);
        //ulElement.click();
        for(WebElement element: liElements){
            System.out.println(element.getText());
            if(element.getText().contains(optionExtra)){
                System.out.println("Selected: " + element.getText());
                element.click();
                break;
            }

        }

    }
}
