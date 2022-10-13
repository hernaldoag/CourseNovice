package test;

import java.util.Properties;
import miscellaneous.Constants;

public abstract class CommonBase {

    protected Properties properties;

    protected String getExcelParameters(){
        return Constants.ExcelParameters.parametersExcel;
    }

    protected String getPropertiesPath(){
        switch (System.getProperty("environment").toLowerCase()){
            case "dev": return Constants.Environments.dev;
            case "stg": return Constants.Environments.stg;
            case "qa": return Constants.Environments.qa;
            case "local": return Constants.Environments.local;
            case "kafka_Local": return Constants.Environments.kafka_local;
            default: return null;
        }
    }

}
