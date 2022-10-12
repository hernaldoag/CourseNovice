import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioAndCheck {
    WebDriver driver;
    String baseURl = "https://courses.letskodeit.com/practice";

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
    public void Radio(){
        WebElement bmw = driver.findElement(By.id("bmwradio"));
        System.out.println(bmw.isSelected());
        bmw.click();
        System.out.println(bmw.isSelected());

        WebElement benz = driver.findElement(By.id("benzradio"));
        System.out.println("Benz is: " + benz.isSelected());
        benz.click();
        System.out.println("BMW is now: " + bmw.isSelected());
        System.out.println("Benz is: " + benz.isSelected());
    }

    @Test
    public void Check() {
        WebElement bmw = driver.findElement(By.id("bmwcheck"));
        System.out.println("BMW is: " + bmw.isSelected());

        WebElement benz = driver.findElement(By.id("benzcheck"));
        System.out.println("Benz is: " + benz.isSelected());

        WebElement honda = driver.findElement(By.id("hondacheck"));
        System.out.println("Benz is: " + honda.isSelected());

        bmw.click();
        benz.click();
        honda.click();

        System.out.println("BMW is: " + bmw.isSelected());

        System.out.println("Benz is: " + benz.isSelected());

        System.out.println("Benz is: " + honda.isSelected());

    }
////input[contains(@type,'radio') and contains(@name,'cars')]
    @Test
    public void testElements() throws  Exception{
        List<WebElement> CarsRadio = driver.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));

        for(WebElement cars : CarsRadio){
            System.out.println("State is "+ cars.isSelected());
            cars.click();
        }
    }

    @Test
    public void testElementsFor() throws  Exception{
        boolean isChecked = false;
        List<WebElement> CarsRadio = driver.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));
        int Size = CarsRadio.size();
        for(int i =0; i < Size; i++){
            System.out.println("State is " + CarsRadio.get(i).isSelected());
            CarsRadio.get(i).click();
            Thread.sleep(2000);
            System.out.println("State updated to " + CarsRadio.get(i).isSelected());
        }

        for(int i =0; i < Size; i++){
            System.out.println("Final State for the Cars is " + CarsRadio.get(i).isSelected());
            Thread.sleep(2000);
        }
    }

    @Test
    public void testElementsCourse() throws  Exception{
        boolean isChecked = false;
        List<WebElement> CarsRadio = driver.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));
        int Size = CarsRadio.size();
        for(int i =0; i < Size; i++){
            isChecked = CarsRadio.get(i).isSelected();
            if (!isChecked){
                CarsRadio.get(i).click();
                Thread.sleep(2000);
            }

        }
    }


    @Test
    public void testElementsByName() throws  Exception {
        boolean isChecked = false;
        //List<WebElement> CarsRadio = driver.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));
        List<WebElement> CarsRadio = driver.findElements(By.name("cars"));
        int Size = CarsRadio.size();
        for (int i = 0; i < Size; i++) {
            System.out.println("State is " + CarsRadio.get(i).isSelected());
            CarsRadio.get(i).click();
            Thread.sleep(2000);
            System.out.println("State updated to " + CarsRadio.get(i).isSelected());
        }

        for (int i = 0; i < Size; i++) {
            System.out.println("Final State for the Cars is " + CarsRadio.get(i).isSelected());
            Thread.sleep(2000);
        }
    }

    @Test
    public void testElementsCheck() throws  Exception {
        boolean isChecked = false;
        List<WebElement> CarsRadio = driver.findElements(By.xpath("//input[contains(@type,'checkbox') and contains(@name,'cars')]"));
        //List<WebElement> CarsRadio = driver.findElements(By.name("cars"));
        int Size = CarsRadio.size();
        for (int i = 0; i < Size; i++) {
            System.out.println("State is " + CarsRadio.get(i).isSelected());
            CarsRadio.get(i).click();
            Thread.sleep(2000);
            System.out.println("State updated to " + CarsRadio.get(i).isSelected());
        }

        for (int i = 0; i < Size; i++) {
            System.out.println("Final State for the Cars is " + CarsRadio.get(i).isSelected());
            Thread.sleep(2000);
        }
    }

}
