package guidebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

public class MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp()throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void multipleWindows() {
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector(".example a")).click();
        Object[] allWindows = driver.getWindowHandles().toArray();
        driver.switchTo().window(allWindows[0].toString());
        //assertThat(driver.getTitle(), is(not("New Window")));
        Assert.assertNotSame(driver.getTitle(),"New Window");
        driver.switchTo().window(allWindows[1].toString());
        //assertThat(driver.getTitle(), is("New Window"));
        Assert.assertEquals(driver.getTitle(), "New Window");
    }

    @Test
    public void multipleWindowsRedux(){
        driver.get("http://the-internet.herokuapp.com/windows");
        String firstWindow = driver.getWindowHandle();
        String newWindow = "";
        driver.findElement(By.cssSelector(".example a")).click();
        Set<String> allWindows = driver.getWindowHandles();

        for(String window : allWindows){
            if(!window.equals(firstWindow)){
                newWindow = window;
            }
        }

        driver.switchTo().window(firstWindow);
        //assertThat(driver.getTitle(),is(not(equalTo("New window"))));
        Assert.assertNotSame(driver.getTitle(),"New Window");


        driver.switchTo().window(newWindow);
        //assertThat(driver.getTitle(), is(equalTo("New Window")));
        Assert.assertEquals(driver.getTitle(), "New Window");
    }
}
