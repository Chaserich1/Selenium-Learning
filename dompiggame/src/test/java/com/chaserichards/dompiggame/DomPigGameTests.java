package com.chaserichards.dompiggame;

import com.chaserichards.dompiggame.pages.dompiggame.DomPigGameHomePage;
import com.chaserichards.dompiggame.webdrivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DomPigGameTests {

    protected WebDriver driver;

    @BeforeTest
    public void localSetup() {
        driver = DriverFactory.getWebDriver("chrome");
    }

    @AfterTest
    public void localCleanup() {
        driver.quit();
    }

    @Test
    void openDomPigGameHomePageSuccess() throws InterruptedException {

        var home = new DomPigGameHomePage(driver);
        home
                .navigateToDomPigGameHomePage();



        Thread.sleep(5000);
    }
}
