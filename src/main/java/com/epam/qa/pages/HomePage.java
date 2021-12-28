package com.epam.qa.pages;

import com.epam.qa.basePage.BasePage;
import com.epam.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By userName = By.xpath("//p//following::strong");

//    Actions
    public String getUserNameText(){
        return getText(userName, WaitStrategy.PRESENCE);
    }
}
