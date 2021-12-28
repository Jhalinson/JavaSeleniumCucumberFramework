package com.epam.qa.constants;

import com.epam.qa.enums.ConfigProperties;
import com.epam.qa.utils.ReaderPropertyFile;

public class FrameworkConstants {

    private final static String CONFIGPATH       = "/Users/jhalinsonacosta/Desktop/cucumberframework/src/test/resources/config/config.properties";
    private final static String EXCELPATH        = "/Users/jhalinsonacosta/Desktop/cucumberframework/src/test/resources/excel/testdata.xlsx";
    private final static long   PAGELOAD         = 10;
    private final static long   EXPLICITWAIT     = 10;
    private final static String EXTENTREPORTPATH = System.getProperty("user.dir") + "/extent-test-output";


    public static long getPageLoad() {
        return PAGELOAD;
    }

    public static String getExcelPath() {
        return EXCELPATH;
    }

    public static String getExtentReportPath() throws Exception {

        if (ReaderPropertyFile.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
            return EXTENTREPORTPATH + "/" + "index.html";
        } else {
            return EXTENTREPORTPATH + "/" + "index.html";
        }

    }
    public static long getExplicitWait() {
        return EXPLICITWAIT;
    }

    public static String getConfigPath() {
        return CONFIGPATH;
    }
}
