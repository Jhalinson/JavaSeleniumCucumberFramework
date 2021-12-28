package com.epam.qa.basePage;
import java.util.List;

import com.epam.qa.driver.DriverManager;
import com.epam.qa.enums.ActionsStrategy;
import com.epam.qa.enums.AlertsStrategy;
import com.epam.qa.enums.JavaScriptExecutorStrategy;
import com.epam.qa.enums.WaitStrategy;
import com.epam.qa.factories.ActionsFactory;
import com.epam.qa.factories.AlertsFactory;
import com.epam.qa.factories.ExplicitWaitFactory;
import com.epam.qa.factories.JavaScriptExecutorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class BasePage {

    protected String getTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected void doClick(By locator, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).click();
//        ExtentLogger.pass(getTitle());

    }

    protected void doSendKeys(By locator, String text, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).sendKeys(text);

    }

    protected void doClearField(By locator, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).clear();

    }

    protected boolean getDisplayedImage(By locator, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        return element.isDisplayed();

    }

    protected void getActions(By locator, ActionsStrategy actionsStrategy) {

        ActionsFactory.performActions(actionsStrategy, locator);

    }

    protected void getJS(By locator, JavaScriptExecutorStrategy javaScriptExecutorStrategy) {

        JavaScriptExecutorFactory.performJavaScript(javaScriptExecutorStrategy, locator);

    }

    protected void getAlerts(By locator, AlertsStrategy alertsStrategy) {
        AlertsFactory.performAlerts(alertsStrategy, locator);
    }

    protected String getAlertsText(By locator, AlertsStrategy alertsStrategy) {
        return AlertsFactory.performAlertsGetText(alertsStrategy, locator);
    }

    protected String getText(By locator, WaitStrategy waitStrategy) {
        return ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).getText();

    }
    protected String getAttributeValue(By locator, WaitStrategy waitStrategy, String attribute) {
        return ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).getAttribute(attribute);

    }

    protected List<WebElement> getMultipleElementsText(By locator) {

        List<WebElement> elements = DriverManager.getDriver().findElements(locator);

        return elements;

    }
}