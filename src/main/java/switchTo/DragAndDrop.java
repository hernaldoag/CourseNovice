package switchTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {
    WebDriver driver;
    String baseURl = "https://jqueryui.com/droppable/";
    // WaitTypes wt;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void DragAndDrop() throws Exception {
        driver.get(baseURl);
        driver.switchTo().frame(0);
        WebElement fromElement  = driver.findElement(By.id("draggable"));

        WebElement toElement  = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);

        //Drag and Drop
        actions.dragAndDrop(fromElement, toElement).build().perform();


        // Clink and hold



    }


    @Test
    public void ClickAndHold() throws Exception {
        driver.get(baseURl);
        driver.switchTo().frame(0);
        WebElement fromElement  = driver.findElement(By.id("draggable"));

        WebElement toElement  = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);

        // Clink and hold
        actions.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
    }


}
