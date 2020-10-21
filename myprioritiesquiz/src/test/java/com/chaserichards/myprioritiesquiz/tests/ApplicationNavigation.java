package com.chaserichards.myprioritiesquiz.tests;

import com.chaserichards.myprioritiesquiz.pages.mypriorities.MyPrioritiesHomePage;
import com.chaserichards.myprioritiesquiz.pages.mypriorities.MyPrioritiesQuizPage;
import com.chaserichards.myprioritiesquiz.pages.mypriorities.MyPrioritiesResultsPage;
import com.chaserichards.myprioritiesquiz.webdrivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.testng.Assert.assertEquals;

public class ApplicationNavigation {
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

    @Test(description = "Test to open the homepage and begin the quiz", priority = -1)
    void openHomepageAndBeginQuiz() throws InterruptedException {
        //Arrange
        var expectedURl = "https://mypriorities.edwardjones.com/quiz";

        //Act
        homePage.navigateToMyPriorHomePage()
                .beginQuiz();

        //Assert
        assertEquals(expectedURl, driver.getCurrentUrl());

        Thread.sleep(2000);
    }

    @Test(description = "Test to confirm that a random card (1 or 2) can be selected through the entire quiz and makes it to results page")
    void chooseOptionsUntilResultsPage() throws InterruptedException {
        //Arrange
        var expectedURL = "https://mypriorities.edwardjones.com/results";

        //Act
        homePage
                .navigateToMyPriorHomePage()
                .beginQuiz()
                .goToQuizPage()
                .chooseAnswer()
                .goToResultsPage()
                .onResultsPage();

        //Assert
        assertEquals(expectedURL, driver.getCurrentUrl());

        Thread.sleep(2000);
    }

    @Test(description = "Test to confirm restart quiz button on results page, restarts the quiz")
    void restartQuizSuccessful() throws InterruptedException {
        //Arrange
        var expectedURL = "https://mypriorities.edwardjones.com/";

        //Act
        homePage
                .navigateToMyPriorHomePage()
                .beginQuiz()
                .goToQuizPage()
                .chooseAnswer()
                .goToResultsPage()
                .onResultsPage()
                .restartQuiz()
                .goToHomePage();

        //Assert
        assertEquals(expectedURL, driver.getCurrentUrl());

        Thread.sleep(2000);
    }
}

