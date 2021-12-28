package com.epam.qa.TestRunner;

import com.epam.qa.driver.Driver;
import com.epam.qa.enums.ConfigProperties;
import com.epam.qa.utils.ReaderPropertyFile;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


@CucumberOptions(features={"src/test/resources/features"}, glue={"com.epam.qa.stepDefinitions"})
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeTest
    public void setUp() throws Exception {
        Driver.initDriver(ReaderPropertyFile.getValue(ConfigProperties.BROWSER));
    }

    @AfterTest
    public void tearDown(){
        Driver.quitDriver();

    }}


