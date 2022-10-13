package reports;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import utilities.DateUtility;
import org.testng.TestListenerAdapter;
import java.util.logging.Logger;



public class CustomListener {

    @Override
    public void onFinish(ITestContext testContext) {
        Logger.info("PASSED TEST CASES");
        testContext.getPassedTests().getAllResults()
                .forEach(result -> {
                    Logger.info(result.getName());
                });

        Logger.info("FAILED TEST CASES");
        testContext.getFailedTests().getAllResults()
                .forEach(result -> {
                    Logger.info(result.getName());
                });

        LOGGER.info(
                "Test completed on: " + testContext.getEndDate().toString());
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
            else if (currentClass instanceof TestUiBase)
                driver = ((TestUiBase) currentClass).getDriver();
            DriverUtility.takeScreeenShot(driver, ((TestBase) currentClass).getTestCaseName() + "_" + DateUtility.getCurrentDate(Constants.Formats.fileFormat));
        }

    }
}
