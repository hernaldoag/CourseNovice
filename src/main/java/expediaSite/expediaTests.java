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


public class expediaTests {
    WebDriver driver;
    String baseURl = "https://www.expedia.mx/";
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
        driver.quit();
        Thread.sleep(3000);
    }

    @Test
    public void openPage() {
        driver.get(baseURl);
        //driver.findElement(By.xpath("//*[@id=\"navbar-inverse-collapse\"]/div/div/a")).click();
        driver.findElement(By.linkText("Vuelos")).click();

        WebElement departField = driver.findElement(By.id("d1-btn"));
        departField.click();

        List<WebElement> datetoSelect = driver.findElements(By.xpath("//*[@class='uitk-date-picker-day']"));
        String select_day = "30";
        int end_date = 5;
        String endDateStr = "5 de febrero de 2023";
        for (WebElement days: datetoSelect) {
           // System.out.println(days.getAttribute("data-day"));
            if (days.getAttribute("data-day").equals(select_day)){
                days.click();

            }

            if (days.getAttribute("aria-label").equals(endDateStr)){
                days.click();

            }
        }
        WebElement listoButton = driver.findElement(By.xpath("//*[@data-stid='apply-date-picker']"));
        listoButton.click();
        /*
        WebElement endDate = driver.findElement(By.xpath("//*[@class='uitk-date-picker-selection-date']"));
        endDate.click();
        int counter = 31;
        List<WebElement> departtoSelect = driver.findElements(By.xpath("//*[@class='uitk-date-picker-day']"));
        for(WebElement days: departtoSelect) {
            if (days.indexOf(31) == counter);
                days.click();
        }
        */

        /*
        for (int i = 27; datetoSelect.indexOf(i) <= datetoSelect.indexOf(53); i++){
            System.out.println("SelectedValues is " + datetoSelect.indexOf(i));
            if (datetoSelect.indexOf(i) == end_date){
                datetoSelect.get(i).click();
                System.out.println("SelectedValues is " + datetoSelect.get(i).getText());
            }
        }
        */

        //*[@id="wizard-flight-tab-roundtrip"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/section/button[2]/span
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
       // WebElement emailFields = wt.waitForElement(By.id("email"), 3);
       // emailFields.sendKeys("test");
        //driver.findElement(By.id("email")).sendKeys("test");

    }

    @Test
    public void whenReadyTest() {
        driver.get(baseURl);
        //driver.findElement(By.xpath("//*[@id=\"navbar-inverse-collapse\"]/div/div/a")).click();
        WebElement loginLink = driver.findElement(By.linkText("SIGN IN"));
        loginLink.click();


        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement emailFields = wt.waitForElement(By.id("email"), 3);
        emailFields.sendKeys("test");
        wt.clickWhenReady(By.name("commit"), 3);
        //driver.findElement(By.id("email")).sendKeys("test");

    }
}

