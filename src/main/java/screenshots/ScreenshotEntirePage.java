package screenshots;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotEntirePage
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver drv = new ChromeDriver();
        drv.manage().window().maximize();//always write wait code after this
        drv.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //for page load
        drv.get("https://www.softwaretestinghelp.com/");                          //Testing webpage
        drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //for Implicit wait

        WebElement auto = drv.findElement(By.xpath("//ul[@id='mega-menu-primary']/li[6]"));
        //li[@id='mega-menu-item-82200']
        //WebElement auto = drv.findElement(By.cssSelector("#mega-menu-item-82200"));
        //WebElement auto = drv.findElement(By.xpath("//*[contains(@class,'mega-menu-link') and contains (text(), \"Automation\")]"));

        System.out.println("Element was found");
        Actions actions = new Actions(drv);

        //Hovering on main menu
        actions.moveToElement(auto);
        actions.click();
        //Thread.sleep(2000);
        //auto.click();                           //click Automation tab

        //WebElement jmeter = drv.findElement(By.linkText("JMeter"));  //link to JMeter page

        WebElement jmeter = drv.findElement(By.xpath("//*[contains(@class,'mega-menu-link') and contains (text(), \"JMeter\")]"));
        System.out.println("Element was found");
        //*[@id="mega-menu-item-82203"]/a
        //*[@id="mega-menu-item-82203"]/a
        Actions jmeterAction = new Actions(drv);
        jmeterAction.moveToElement(jmeter);
        Thread.sleep(10000);
        jmeterAction.click();
        Thread.sleep(10000);
        //scroll down to open a link among various links, in the Video Tutorials section of the page

        JavascriptExecutor js = (JavascriptExecutor) drv;
        js.executeScript("window.scrollBy(0,1700)");           //scrolling downwards
        Thread.sleep(1500);

        //WebElement udv = drv.findElement(By.xpath("//*[contains (text(), 'User-Defined Variables')]"));
        WebElement udv = drv.findElement(By.xpath("//*[@id=\"post-15436\"]/div/div[2]/p[12]/a[6]"));
        System.out.println("Element was found");
        //*[@id="post-15436"]/div/div[2]/p[12]/a[6]
        Actions textActions = new Actions(drv);

        udv.click();                                   //opening User-Defined Variables link
        Thread.sleep(1500);

        //Capturing the Screenshot with the help of  ashot()

        Screenshot screenshot=new AShot().takeScreenshot(drv);
        ImageIO.write(screenshot.getImage(),"PNG",new File("C:\\Users\\hernaldo.alvarez\\Documents\\JavaCourse\\justDemoing\\CourseNovice\\src\\screenshots\\entirepage.png"));

        //The screenshot to be captured will be in .png image format and would be saved at above mentioned path.

        System.out.println("Screenshot for full page is captured successfully!");
    }
}
