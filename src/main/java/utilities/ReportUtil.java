package utilities;

import utilities.ReportUtil.*;
//import org.apache.log4j.Logger;
import org.testng.Reporter;

import java.util.logging.Logger;

public class ReportUtil {final static Logger log = Logger.getLogger(ReportUtil.class);

    public static void addNewLine(String message){
        log.debug(message);
        Reporter.log("<br>"+message+"</br>");
    }
}
