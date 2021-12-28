package com.epam.qa.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
    private static ThreadLocal<ExtentTest> tlTest = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return tlTest.get();
    }

    public static void setExtentTest(ExtentTest test) {
        tlTest.set(test);
    }

    public static void unLoad() {
        tlTest.remove();
    }
}
