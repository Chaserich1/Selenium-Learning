package com.chaserichards.myprioritiesquiz;

import com.chaserichards.myprioritiesquiz.pages.mypriorities.MyPrioritiesHomePage;
import com.chaserichards.myprioritiesquiz.pages.mypriorities.MyPrioritiesQuiz;
import com.chaserichards.myprioritiesquiz.webdrivers.DriverFactory;
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
        //Use driver factory to setup a new chrome driver
        driver = DriverFactory.getWebDriver("chrome");

    }

    @AfterTest
    public void localCleanup() {
        driver.quit();
    }

    @Test
    void openHomepageAndBeginQuiz() throws InterruptedException {

        var home = new MyPrioritiesHomePage(driver);
        home
                .navigateToMyPriorHomePage()
                .beginQuiz();

        Thread.sleep(3000);
    }

    @Test
    void chooseOptionCardOne() throws InterruptedException {
        var quizPage = new MyPrioritiesQuiz(driver);
        openHomepageAndBeginQuiz();
        quizPage.chooseAnswer();

        Thread.sleep(3000);
    }


}

