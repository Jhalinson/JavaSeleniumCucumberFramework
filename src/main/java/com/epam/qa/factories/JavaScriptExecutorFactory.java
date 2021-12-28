package com.epam.qa.factories;

import com.epam.qa.driver.DriverManager;
import com.epam.qa.enums.JavaScriptExecutorStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorFactory {
    public static WebElement performJavaScript(JavaScriptExecutorStrategy javaScriptExecutorStrategy, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        WebElement element = DriverManager.getDriver().findElement(locator);
        if (javaScriptExecutorStrategy == JavaScriptExecutorStrategy.CLICK) {

            js.executeScript("arguments[0]", element);
        } else if (javaScriptExecutorStrategy == JavaScriptExecutorStrategy.SCROLLINTOVIEW) {
            js.executeScript("arguments[0].scrollIntoView();", element);

        } else if (javaScriptExecutorStrategy == JavaScriptExecutorStrategy.SCROLLBOTTOM) {
            js.executeScript("window.scrollBy(0,document.body.scrollHeight);");

        } else if (javaScriptExecutorStrategy == JavaScriptExecutorStrategy.NONE) {

            element = DriverManager.getDriver().findElement(locator);
        }
        return element;
    }
}
