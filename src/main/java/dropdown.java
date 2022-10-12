import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class dropdown {

    WebDriver driver;
    String baseURl = "http://the-internet.herokuapp.com/";

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

    @Test
    public void DropDownTestSelect() throws Exception {
        driver.navigate().to("http://the-internet.herokuapp.com/dropdown");
        WebElement elementsDrop = driver.findElement(By.id("dropdown"));
        Select selection = new Select(elementsDrop);

        List<WebElement> options = selection.getOptions();
        System.out.println("Let's try this");

        Thread.sleep(2000);
        System.out.println("Select option 1 by value");
        selection.selectByValue("1");

        Thread.sleep(2000);
        System.out.println("Select option 0 by value");
        selection.selectByValue("0");

        Thread.sleep(2000);
        System.out.println("Select Option 2 by value");
        selection.selectByVisibleText("Option 2");

        for (int i = 0; i < options.size(); i++) {

           /** if (options.get(i).getText() == "Option 4") {
                options.get(i).click();
                Thread.sleep(2000);
                System.out.println("Selected Value is: " + options.get(i).isSelected());
            }*/
           System.out.println(options.get(i).getText());
        }
    }



    @Test
    public void DropDownTestCourseForEach() throws Exception {
        String CourseURL = "https://courses.letskodeit.com/practice";
        driver.get(CourseURL);
        WebElement elementsDrop = driver.findElement(By.id("carselect"));

        Select selection = new Select(elementsDrop);
        Thread.sleep(2000);
        System.out.println("Select Benz by value");
        selection.selectByValue("benz");

        Thread.sleep(2000);
        System.out.println("Select Honda by value");
        selection.selectByValue("honda");


        Thread.sleep(2000);
        System.out.println("Select BMW by value");
        selection.selectByVisibleText("BMW");


        Thread.sleep(2000);
        System.out.println("Print all options");
        List<WebElement> options = selection.getOptions();

        for (WebElement values : options){
           System.out.println(" Option Name: " + values.getText());
        }



    }


    @Test
    public void DropDownTestCourseFor() throws Exception {
        String CourseURL = "https://courses.letskodeit.com/practice";
        driver.get(CourseURL);
        WebElement elementsDrop = driver.findElement(By.id("carselect"));

        Select selection = new Select(elementsDrop);
        Thread.sleep(2000);
        System.out.println("Select Benz by value");
        selection.selectByValue("benz");

        Thread.sleep(2000);
        System.out.println("Select Honda by value");
        selection.selectByValue("honda");


        Thread.sleep(2000);
        System.out.println("Select BMW by Visible Text");
        selection.selectByVisibleText("BMW");


        Thread.sleep(2000);
        System.out.println("Print all options");
        List<WebElement> options = selection.getOptions();

        for (int i =0; i< options.size(); i++){
            //String OptionName = options.get(i).getText();
            System.out.println("    Option Name: " +  options.get(i).getText());
        }



    }

}
