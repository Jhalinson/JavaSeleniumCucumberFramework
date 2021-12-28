package com.epam.qa.pages;

import com.epam.qa.basePage.BasePage;
import com.epam.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Repository of elements
    private By myAccountLink = By.xpath("//a[contains(text(), 'My Account')]");
    private By usernameInput = By.xpath("//input[@type='text' and @name='username']");
    private By passInput = By.xpath("//input[@type='password' and @id='password']");
    private By loginBtn = By.xpath("//input[@type='submit' and @name='login']");
    private By errorMessage = By.xpath("//ul[@class='woocommerce-error']/li");

    // Constructor
    public LoginPage() {

    }

    //Actions
    public void sendValueUsernameInput(String username) {
        doSendKeys(usernameInput, username, WaitStrategy.PRESENCE);
    }

    public void sendValuePassInput(String username) {
        doSendKeys(passInput, username, WaitStrategy.PRESENCE);
    }

    public void clickLoginBtn() {
        doClick(loginBtn, WaitStrategy.CLICKABLE);
    }

    public void clickMyAccountLink() {
        doClick(myAccountLink, WaitStrategy.CLICKABLE);
    }

    public String getMyAccountLinkText() {
        return getText(myAccountLink, WaitStrategy.PRESENCE);
    }

    public String getPassInputText() {
        return getText(passInput, WaitStrategy.VISIBLE);

    }

    public String getErrorMessageText() {
        return getText(errorMessage, WaitStrategy.VISIBLE);

    }
    public String getPassInputAttribute(String attribute){
        return getAttributeValue(passInput, WaitStrategy.VISIBLE, attribute);
    }
}
