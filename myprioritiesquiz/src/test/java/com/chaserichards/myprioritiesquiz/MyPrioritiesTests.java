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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyPrioritiesTests {
    protected WebDriver driver;
    private MyPrioritiesHomePage homePage;
    private MyPrioritiesQuizPage quizPage;
    private MyPrioritiesResultsPage resultsPage;

    @BeforeTest
    public void localSetup() {
        //Arrange
        //Use driver factory to setup a new chrome driver
        driver = DriverFactory.getWebDriver("chrome");
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
        Assert.assertEquals(driver.getCurrentUrl(), expectedURl);

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
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        Thread.sleep(2000);
    }

    @Test(description = "Test to confirm change previous answer button works")
    void changePreviousAnswerButton() throws InterruptedException {
        //Arrange
        var randomQuestion = ThreadLocalRandom.current().nextInt(1, 25 + 1);
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

        //Assert
        Assert.assertTrue(cardList.get(0).equals(cardList.get(2)) && cardList.get(1).equals(cardList.get(3)));

        Thread.sleep(2000);
    }

    @Test(description = "Test to confirm restart quiz button on results page, restarts the quiz")
    void restartQuizSuccessful() throws InterruptedException {
        //Arrange
        var expectedURL = "https://mypriorities.edwardjones.com/";

        //Act
        quizPage = homePage
                .navigateToMyPriorHomePage()
                .beginQuiz()
                .goToQuizPage();
        resultsPage = quizPage
                .chooseAnswer()
                .goToResultsPage();
        resultsPage
                .onResultsPage()
                .restartQuiz()
                .goToHomePage();

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        Thread.sleep(2000);
    }
}

