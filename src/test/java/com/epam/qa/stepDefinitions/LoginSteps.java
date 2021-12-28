package com.epam.qa.stepDefinitions;

import com.epam.qa.TestRunner.TestRunner;
import com.epam.qa.pages.HomePage;
import com.epam.qa.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginSteps extends TestRunner {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();
//    @Given("the url {string}")
//    public void theUrl(String arg0) {
//        try {
//            DriverManager.getDriver().get(arg0);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            System.out.println(e.getCause());
//        }
//
//    }

    @Given("the user do click in {string} button")
    public void the_user_do_click_in_button(String string) {
        Assert.assertEquals(string, loginPage.getMyAccountLinkText());
        loginPage.clickMyAccountLink();

    }

    @Then("it showed the password input masked {string}")
    public void itShowedThePasswordInputMasked(String arg0) {
        Assert.assertEquals(arg0, loginPage.getPassInputAttribute("type"));

    }

    @When("it log in with the credentials {string}, {string}")
    public void it_log_in_with_the_credentials(String string, String string2) {
        loginPage.sendValueUsernameInput(string);
        loginPage.sendValuePassInput(string2);
        loginPage.clickLoginBtn();

    }

    @Then("the webpage must show {string}")
    public void the_webpage_must_show(String string) {
        softAssert.assertEquals(string, loginPage.getErrorMessageText());
        Assert.assertEquals(string, loginPage.getErrorMessageText());
    }

    @Then("it showed the name {string}")
    public void it_showed_the_name(String string) {
        softAssert.assertEquals(string, homePage.getUserNameText());

    }


}
