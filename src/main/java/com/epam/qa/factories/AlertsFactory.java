package com.epam.qa.factories;

import com.epam.qa.driver.DriverManager;
import com.epam.qa.enums.AlertsStrategy;
import org.openqa.selenium.By;

public class AlertsFactory {
    public static void performAlerts(AlertsStrategy alertsStrategy, By locator) {

        if (alertsStrategy == AlertsStrategy.ACCEPT) {
            DriverManager.getDriver().switchTo().alert().accept();

        } else if (alertsStrategy == AlertsStrategy.DISMISS) {
            DriverManager.getDriver().switchTo().alert().dismiss();
        } else if (alertsStrategy == AlertsStrategy.SENDTEXT) {
            DriverManager.getDriver().switchTo().alert().sendKeys("");
        } else if (alertsStrategy == AlertsStrategy.NONE) {

            DriverManager.getDriver().findElement(locator);
        }

    }
    public static String performAlertsGetText(AlertsStrategy alertsStrategy, By locator) {

        String  text = "";
        if (alertsStrategy == AlertsStrategy.GETTEXT) {
            text = DriverManager.getDriver().switchTo().alert().getText();
        }
        return text;
    }
}
