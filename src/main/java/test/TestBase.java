package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestBase extends CommonBase{

    private ThreadLocal<String> testCaseNames = new ThreadLocal<>();

    @BeforeClass(alwaysRun = true)
    public void setup() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(getPropertiesPath()));
    }

    @BeforeMethod(alwaysRun = true)
    public void setupScript(Method method) {
        testCaseNames.set(method.getDeclaringClass().getSimpleName() + "_" + method.getName());
    }

    public String getTestCaseName() {
        return this.testCaseNames.get();
    }
}
