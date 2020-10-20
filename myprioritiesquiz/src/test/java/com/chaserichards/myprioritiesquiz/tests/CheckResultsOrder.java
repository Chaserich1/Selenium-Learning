package com.chaserichards.myprioritiesquiz.tests;

import com.chaserichards.myprioritiesquiz.pages.mypriorities.MyPrioritiesHomePage;
import com.chaserichards.myprioritiesquiz.webdrivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class CheckResultsOrder {

    protected WebDriver driver;
    private MyPrioritiesHomePage homePage;

    @BeforeTest
    public void localSetup() {
        //Arrange
        //Use driver factory to setup a new chrome driver
        driver = DriverFactory.getWebDriver("firefox");
        homePage = new MyPrioritiesHomePage(driver);
    }

    @AfterTest
    public void localCleanup() {
        driver.quit();
    }

    @Test(enabled = false, description = "Test to check the order of results on result page")
    void checkTestResultOrder() throws InterruptedException {
        //Arrange
        Map<String, Integer> selectedAnswers;

        //Act
        selectedAnswers = homePage
                .navigateToMyPriorHomePage()
                .beginQuiz()
                .goToQuizPage()
                .chooseAnswer()
                .getCardSelectionFrequencies();

        Thread.sleep(2000);

    }
}
