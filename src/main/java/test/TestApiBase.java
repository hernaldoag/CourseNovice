package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.lang.reflect.Method;
import utilities.ApiUtility;
import org.apache.logging.log4j.core.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;



public class TestApiBase extends TestBase{
    final static Logger log = Logger.getLogger(TestApiBase.class);

    protected ApiUtility apiUtility;


    @BeforeClass(alwaysRun = true)
    public void setup( )throws IOException {
        super.setup();
        apiUtility = new ApiUtility();
        //consumer = new KafkaConsumerEx();
    }

    @BeforeMethod(alwaysRun = true)
    public void setupScript(Method method) { super.setupScript(method); }


//    protected String getResource(Service service){
//        switch (service){
//            case TITLES:  return properties.getProperty("endpoint")+"title";
//            case ASSETS: return properties.getProperty("endpoint")+ "asset";
//            case ORDERS: return properties.getProperty("endpoint")+ "order";
//            case CONFIRMATION_TITLE: return properties.getProperty("endpoint")+"confirmation/title";
//            case CONFIRMATION_ASSET: return properties.getProperty("endpoint")+"confirmation/asset";
//            case CONFIRMATION_AUDIO: return properties.getProperty("endpoint")+"confirmation/asset/association/audio";
//            case CONFIRMATION_TEXT: return properties.getProperty("endpoint")+"confirmation/asset/association/text";
//            case TITLE_RECEIVED: return properties.getProperty("topic");
//            case TITLES_MGM: return properties.getProperty("endpoint_mgm")+"title";
//            case ASSETS_MGM: return properties.getProperty("endpoint_mgm")+"asset";
//            case ORDERS_MGM: return properties.getProperty("endpoint_mgm")+"order";
//            default: return null;
//        }
//    }
}
