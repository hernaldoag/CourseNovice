package screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ScreeshotAsTest {
    WebDriver driver;
    String baseUrl = "https://www.softwaretestinghelp.com/";
    String ElementURL = "https://opensource-demo.orangehrmlive.com/";

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
    public void takeScreenshot() throws  Exception{
        driver.get(baseUrl);
        //WebElement element = driver.findElement(By.id("multiple-select-example"));
        //WebElement auto = driver.findElement(By.xpath("//ul[@id='mega-menu-primary']/li[6]"));

        WebElement auto = driver.findElement(By.xpath("/html/body/nav[2]/div/div/ul/li[6]/a"));
        //*[@id="mega-menu-item-82200"]/a    //li[@id='mega-menu-item-82200']/a
        //WebElement auto = driver.findElement(By.xpath("//*[contains(@class,'mega-menu-link') and contains (text(), \"Automation\")]"));
        //Actions actions = new Actions(driver);
        System.out.println("Element was found");


        //Hovering on main menu
        //actions.moveToElement(auto).click();
        //actions.click();
        //Thread.sleep(2000);
        auto.click();                           //click Automation tab
        Thread.sleep(2000);
        //WebElement jmeter = drv.findElement(By.linkText("JMeter"));  //link to JMeter page

        //WebElement jmeter = driver.findElement(By.xpath("//*[contains(@class,'mega-menu-link') and contains (text(), \"JMeter\")]"));
        WebElement jmeter = driver.findElement(By.xpath("/html/body/nav[2]/div/div/ul/li[6]/ul/li/ul/li[3]/ul/li[1]/a"));
        System.out.println("Element was found");
        //*[@id="mega-menu-item-82203"]/a
        //*[@id="mega-menu-item-82203"]/a
        //Actions jmeterAction = new Actions(driver);
        //jmeterAction.moveToElement(jmeter);
        //Thread.sleep(10000);
        jmeter.click();
        Thread.sleep(10000);
        //scroll down to open a link among various links, in the Video Tutorials section of the page

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1700)");           //scrolling downwards
        Thread.sleep(1500);

        WebElement udv = driver.findElement(By.xpath("//*[@id=\"post-15436\"]/div/div[2]/p[12]/a[6]"));
                //"//*a[contains (text(), 'User-Defined Variables')]"));
        //*[@id="post-15436"]/div/div[2]/p[12]/a[6]
        //WebElement udv = driver.findElement(By.xpath("//*[@id=\"post-15436\"]/div/div[2]/p[12]/a[6]"));
        System.out.println("Element was found");
        //*[@id="post-15436"]/div/div[2]/p[12]/a[6]
        Actions textActions = new Actions(driver);

        udv.click();                                   //opening User-Defined Variables link
        Thread.sleep(1500);

        //Capturing the Screenshot with the help of  ashot()

        Screenshot screenshot=new AShot().takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"PNG",new File("C:\\Users\\hernaldo.alvarez\\Documents\\JavaCourse\\justDemoing\\CourseNovice\\src\\screenshots\\entirepage.png"));

        //The screenshot to be captured will be in .png image format and would be saved at above mentioned path.

        System.out.println("Screenshot for full page is captured successfully!");

    }


    @Test
    public void takeScreenshotWebElement() throws  Exception {
        driver.get(ElementURL);
        //Testing webpage
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   //for Implicit wait

        WebElement uname = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));      //Username....ID....
        uname.sendKeys("Admin");

        WebElement pword = driver.findElement(By.xpath("//*[@type='password']"));       //Password....ID....
        pword.sendKeys("admin123");

        WebElement login_b = driver.findElement(By.xpath("//*[@id=  \"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        //WebElement login_b = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        login_b.click();                             //Login button....XPATH....

        WebElement ele = driver.findElement(By.xpath("//ul[@class=\"oxd-main-menu\"]/li[5]"));
        ele.click();         //opening link for element for which we want screenshot

        // pass driver as well as the element in takeScreenshot() method.
        WebElement ele2 = driver.findElement(By.xpath("//ul[@class=\"oxd-main-menu\"]/li[5]"));
        //ele2.click();
        /**
        Screenshot Screenshot_webele = new AShot().coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, ele2);
        */
        Screenshot Screenshot_webele = new AShot().coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver, ele2);

        // For saving the screenshot in .png/.jpeg format at the desired location

        ImageIO.write(Screenshot_webele.getImage(),"png",new File("C:\\Users\\hernaldo.alvarez\\Documents\\JavaCourse\\justDemoing\\CourseNovice\\src\\screenshots\\element.jpeg"));

        System.out.println("Screenshot for specified element captured successfully!");
    }
}
