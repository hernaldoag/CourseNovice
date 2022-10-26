import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHiddenElements {
    WebDriver driver;
    String baseURl = "https://courses.letskodeit.com/practice";
    String baseURl2 = "https://www.expedia.mx/";

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
    public void testBox() throws Exception{
        driver.get(baseURl);
        WebElement textBox = driver.findElement(By.id("displayed-text"));
        System.out.println("TextBox displayed " + textBox.isDisplayed());
        Thread.sleep(2000);

        WebElement hidebutton = driver.findElement(By.id("hide-textbox"));
        hidebutton.click();
        Thread.sleep(2000);
        System.out.println("TextBox displayed " + textBox.isDisplayed());

        WebElement showbutton = driver.findElement(By.id("show-textbox"));
        showbutton.click();
        Thread.sleep(2000);
        System.out.println("TextBox displayed " + textBox.isDisplayed());


    }

    @Test
    public void testExpedia() throws Exception{
        driver.get(baseURl2);
        WebElement people = driver.findElement(By.xpath("//*[(@type='button') and contains(text(),\"1 hab., 2 personas\")]"));

        people.click();
        Thread.sleep(2000);
        //WebElement children = driver.findElement(By.xpath("//*[@id=\"uitk-step-increment-niños-829-title\"]"));
       // WebElement children = driver.findElement(By.id("uitk-step-increment-niños-829-title"));
        WebElement children = driver.findElement(By.xpath("//*[@id=\"adaptive-menu\"]/div[2]/div/div/section/div[1]/div[3]/div/button[2]"));
        Thread.sleep(2000);
        children.click();

        WebElement childrenNo = driver.findElement(By.id("child-age-input-0-0"));
        Select selection = new Select(childrenNo);
        Thread.sleep(2000);
        System.out.println("selecting age");
        selection.selectByIndex(8);
        System.out.println("selecting age:" + selection.getFirstSelectedOption().getText());
        Thread.sleep(1000);
    }

    @Test
    public void testExpediaCustom() throws Exception{
        driver.get(baseURl2);
        WebElement people = driver.findElement(By.xpath("//*[(@type='button') and contains(text(),\"1 hab., 2 personas\")]"));

        people.click();
        Thread.sleep(2000);
        //WebElement children = driver.findElement(By.xpath("//*[@id=\"uitk-step-increment-niños-829-title\"]"));
        // WebElement children = driver.findElement(By.id("uitk-step-increment-niños-829-title"));
        WebElement children = driver.findElement(By.xpath("//*[contains(text(),'Aumentar el número de adultos en la habitación 1')]"));
        Thread.sleep(2000);
        children.click();

        WebElement childrenNo = driver.findElement(By.id("child-age-input-0-0"));
        Select selection = new Select(childrenNo);
        Thread.sleep(2000);
        System.out.println("selecting age");
        selection.selectByIndex(8);
        System.out.println("selecting age:" + selection.getFirstSelectedOption().getText());
        Thread.sleep(1000);
    }



}
