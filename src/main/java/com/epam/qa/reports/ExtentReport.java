package com.epam.qa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.epam.qa.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public class ExtentReport {
    public static ExtentReports extent;

    private ExtentReport() {

    }

    public static void initReports() throws Exception {

        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportPath());
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("My Store Report");
            extent.attachReporter(spark);
        }
        extent.setSystemInfo("Company Name", "Epam");
        extent.setSystemInfo("Project Name", "Cucumber Selenium");
        extent.setSystemInfo("Department Name", "QA");
        extent.setSystemInfo("SDET Name", "Jhalinson Acosta");
        extent.setSystemInfo("Company Name", "Applaudo Studio");

    }

    public static void flushReports() throws Exception {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportPath()).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void createTest(String testCaseName) {

        ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }

}
