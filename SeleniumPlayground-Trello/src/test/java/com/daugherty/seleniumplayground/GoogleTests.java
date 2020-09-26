package com.daugherty.seleniumplayground;

import com.daugherty.seleniumplayground.pages.google.GoogleHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTests {
    protected WebDriver driver;

    @BeforeTest
    public void testSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void testTearDown() {
        driver.quit();
    }

    @Test
    void canOpenGoogleSiteTest() throws InterruptedException {

        var home = new GoogleHomePage(driver);
        home
                .go()
                .search("selenium webdriver")
                .waitUntilTitleExists("selenium webdriver - Google Search")
                .findLinkByText("WebDriver - Selenium")
                .click();
        Thread.sleep(2000);
    }
}
