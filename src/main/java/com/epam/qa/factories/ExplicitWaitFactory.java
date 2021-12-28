package com.epam.qa.factories;

import com.epam.qa.constants.FrameworkConstants;
import com.epam.qa.driver.DriverManager;
import com.epam.qa.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitFactory {

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By locator) {
        WebElement element = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait(), 1))
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait(),1))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait(),1))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } else if (waitStrategy == WaitStrategy.NONE) {

            element= DriverManager.getDriver().findElement(locator);
        }
        return element;
    }

}
