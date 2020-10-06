package com.chaserichards.myprioritiesquiz;

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

public class MyPrioritiesTests {
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
        Assert.assertEquals(expectedURl, driver.getCurrentUrl());

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
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());

        Thread.sleep(2000);
    }

    @Test(description = "Test to confirm change previous answer button works")
    void changePreviousAnswerButton() throws InterruptedException {
        //Arrange
        var randomQuestion = ThreadLocalRandom.current().nextInt(2, 26);
        List<String> cardList;

        //Act
        cardList = homePage
                .navigateToMyPriorHomePage()
                .beginQuiz()
                .goToQuizPage()
                .chooseAnswer(randomQuestion)
                .storeCurrentCards()
                .chooseAnswer(1)
                .changePreviousAnswer()
                .storeCurrentCards()
                .getCardList();

        //Assert - thinking of ways this could be improved
        Assert.assertTrue(cardList.get(0).equals(cardList.get(2)) && cardList.get(1).equals(cardList.get(3)));

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
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());

        Thread.sleep(2000);
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

