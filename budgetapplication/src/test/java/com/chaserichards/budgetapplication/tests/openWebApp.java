package com.chaserichards.budgetapplication.tests;

import com.chaserichards.budgetapplication.webdrivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class openWebpage {

    protected WebDriver driver;

    @BeforeTest
    public void localSetup() {
        driver = DriverFactory.getWebDriver("chrome");

    }

    @AfterTest
    public void localCleanup() {
        driver.quit();
    }
}
