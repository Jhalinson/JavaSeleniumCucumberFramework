package com.epam.qa.utils;

import com.epam.qa.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotsUtils {
    private ScreenshotsUtils() {

    }

    public static String getBase64Image() {


        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

    }
}
