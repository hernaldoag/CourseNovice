package ui.factories;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver getDriver(){

        WebDriver driver = null;
        Browser browser =  System.getProperty("browser") == null ? Browser.CHROME : Browser.findValue(System.getProperty("browser"));
        switch (browser){
            case CHROME:
                /*
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("disable-infobars");
                if(System.getProperty("headless").toUpperCase().equals("TRUE"))
                    chromeOptions.addArguments("headless");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriverservers/chromedriver.exe");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().deleteAllCookies();
                break;

                 */
            case FIREFOX:
                /*
                System.setProperty("webdriver.gecko.driver","src/main/resources/webdriverservers/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;*/
        }
        driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
        return driver;
    }

    public enum Browser{
        CHROME("CHROME"),
        FIREFOX("FIREFOX");

        private final String value;

        Browser(String value){this.value = value;}

        public String getValue() {
            return this.value;
        }

        public static Browser findValue(String browser){
            for(Browser value : values()){
                if(value.getValue().equals(browser.toUpperCase())){
                    return value;
                }
            }return null;
        }
    }
}
