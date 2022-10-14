package reports;

import miscellaneous.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;
import test.TestApiBase;
import test.TestBase;
import test.TestHybridBase;
import test.TestUiBase;
import utilities.DateUtility;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;
import utilities.DriverUtility;



public class CustomListener extends TestListenerAdapter {
   // final static Logger logger = Logger.getLogger(TestListenerAdapter.class);
    @Override
    public void onFinish(ITestContext testContext) {
        //Logger.info("PASSED TEST CASES");
        testContext.getPassedTests().getAllResults()
                .forEach(result -> {
          //          Logger.info(result.getName());
                });

        //Logger.info("FAILED TEST CASES");
        testContext.getFailedTests().getAllResults()
                .forEach(result -> {
          //          Logger.info(result.getName());
                });

        //LOGGER.info(
               // "Test completed on: " + testContext.getEndDate().toString());
    }

    public void onTestFailure(ITestResult iTestResult) {
        super.onTestFailure(iTestResult);
        Object currentClass = iTestResult.getInstance();

        if (currentClass instanceof TestBase) {

        }

        if (currentClass instanceof TestHybridBase || currentClass instanceof TestUiBase) {

            WebDriver driver = null;
            if (currentClass instanceof TestHybridBase)
                driver = ((TestHybridBase) currentClass).getDriver();
            //else if (currentClass instanceof TestUiBase)
              //  driver = ((TestUiBase) currentClass).getDriver();
            //DriverUtility.takeScreeenShot(driver, ((TestBase) currentClass).getTestCaseName() + "_" + DateUtility.getCurrentDate(Constants.Formats.fileFormat));
        }

    }
}
