package com.chaserichards.myprioritiesquiz;

import com.chaserichards.myprioritiesquiz.pages.mypriorities.MyPrioritiesHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyPrioritiesTests {
    protected WebDriver driver;

    @BeforeTest
    public void localSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void localCleanup() {
        driver.quit();
    }

    @Test
    void openMyPrioritiesHomePageSuccess() throws InterruptedException {

        var home = new MyPrioritiesHomePage(driver);
        home
                .navigateToMyPriorHomePage();



        Thread.sleep(5000);
    }
}

