package screenshots;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

@Test
public class ScreenshotWebElement{

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        WebDriver drv = new FirefoxDriver();
        drv.manage().window().maximize();             //always write wait code after this
        drv.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //for page load
        drv.get("https://opensource-demo.orangehrmlive.com/");           //Testing webpage
        drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   //for Implicit wait

        WebElement uname = drv.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));      //Username....ID....
        uname.sendKeys("Admin");

        WebElement pword = drv.findElement(By.xpath("//*[@type='password']"));       //Password....ID....
        pword.sendKeys("admin123");

        WebElement login_b = drv.findElement(By.xpath("//input[@id='btnLogin']"));
        login_b.click();                             //Login button....XPATH....

        WebElement ele = drv.findElement(By.linkText("Maintenance"));
        ele.click();         //opening link for element for which we want screenshot

        // pass driver as well as the element in takeScreenshot() method.

        Screenshot Screenshot_webele = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(drv, ele);

        // For saving the screenshot in .png/.jpeg format at the desired location

        ImageIO.write(Screenshot_webele.getImage(),"png",new File("C:\\Users\\Chait\\Desktop\\Screenshots\\element.jpeg"));

        System.out.println("Screenshot for specified element captured successfully!");

    }
}
