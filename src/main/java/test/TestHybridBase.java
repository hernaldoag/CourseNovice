package test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ui.factories.*;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestHybridBase extends TestApiBase {
    final static Logger log = Logger.getLogger(TestApiBase.class);
    private ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    protected String uiUser;
    protected String uiPass;

    @BeforeClass(alwaysRun = true)
    public void setup() throws IOException {
        super.setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void setupScript(Method method){
        super.setupScript(method);
        drivers.set(DriverFactory.getDriver());
        getDriver().get(properties.getProperty("event"));
        uiUser = properties.getProperty("user");
        uiPass = properties.getProperty("pwd");
    }

    @AfterMethod(alwaysRun = true)
    public void finishScript(){
        if(getDriver() != null) {
            getDriver().close();
            getDriver().quit();
        }
    }

    public WebDriver getDriver(){
        return drivers.get();
    }
    /*
    public void updateDeteUi()
    {
        DBUtility.execute(dbInfo, Queries.updateDeteUi);
        Utility.wait(5);
    }

     */
}
