package screenshots;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ScreenshotCompare {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        WebDriver drv = new FirefoxDriver();
        drv.manage().window().maximize();           //always write wait code after this
        drv.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);    //for page load
        drv.get("https://www.naukri.com/nlogin/login");                        //Testing webpage
        drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     //for Implicit wait

        // Finding the logo element and capturing its screenshot

        WebElement logo = drv.findElement(By.xpath("//a[@class='nLogo fl']/img"));
        Screenshot logoSrcshot = new AShot().takeScreenshot(drv, logo);

        // Reading the image for comparision

        BufferedImage expectedImage = ImageIO.read(new File("C:\\Users\\Chait\\Desktop\\naukri_Logo.png"));
        BufferedImage actualImage = logoSrcshot.getImage();

        ImageDiffer img_differnece = new ImageDiffer();

        // Creating ImageDiffer object and calling the method makeDiff()

        ImageDiff differnece = img_differnece.makeDiff(actualImage, expectedImage);

        if (differnece.hasDiff() == true)        //Checking the difference using in-built functions)
        {

            System.out.println("Both logo images matched"); //in case when no difference found
        }

        else
        {
            System.out.println("The logo images are different"); //in case when difference found
        }

    }
}
