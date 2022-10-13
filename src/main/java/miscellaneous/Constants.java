package miscellaneous;

public class Constants {
    public static class Common{
        public static final String description = "Automation Test: %s";
        public static final String workDirectory = System.getProperty("user.dir")+"\\";
    }

    public static class ExcelParameters{

        public static final String devExcel = "src/test/resources/environments/dev/Parameters.xlsx";
        public static final String parametersExcel = "src/test/resources/WBIS_Parameters.xlsx";
    }

    public static class Environments{
        public static final String local = "src/test/resources/environments/local/local.properties";
        public static final String kafka_local = "src/test/resources/environments/local/kafka_Local_server.properties";
        public static final String dev = "src/test/resources/environments/dev/dev.properties";
        public static final String stg = "src/test/resources/environments/stg/stg.properties";
        public static final String qa = "src/test/resources/environments/qa/qa.properties";
    }

    public static class ExcelCommonColumns{
        public static final String testCaseName = "TestCaseNAme";
        public static final String request = "Request";
    }

    public static class ExcelSheets{
        public static final String Titles = "postTitles";
        public static final String Assets = "postAssets";
        public static final String AssetsExcel = "postAssets";
        public static final String TitlesExcel = "postTitles";
        public static final String AssetExcelMGM = "postAssetsMGM";
        public static final String TitlesExcelMGM = "postTitlesMGM";
    }

    public static class Formats {
        public static final String orderDateFormat = "yyyy-MM-dd'T'HH:mm:ss";
        public static final String fileFormat = "yyyy-MM-dd-HH-mm-ss-SSS";
        public static final String timeStampFormat = "yyyy-MM-dd'T'HH:mm:ss.mmm-08:00";
    }

    public static final String TENANT_ID = "WB";

    public static final String SOURCE = "wb-integration";

    //Channels
    public static final String ERROR_CHANNEL = "integrationFlowErrors";
    public static final String ACKNOWLEDGED_TITLES_CHANNEL = "acknowledgedTitles.input";
    public static final String PROCESSED_TITLES_CHANNEL = "processedTitles.input";


    public static class Files{
        public static final String assetSync = "Files/assets/";
        public static final String titleSync = "Files/titles/";

    }

    public static class DbCommonColumns{
        public static final String correlationId = "correlation";
        public static final String targetargs = "targetargs";


    }
}
