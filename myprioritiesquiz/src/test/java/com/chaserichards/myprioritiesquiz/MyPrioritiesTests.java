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

        Thread.sleep(3000);
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

        Thread.sleep(3000);
    }

    @Test(description = "Test to confirm change previous answer button works")
    void changePreviousAnswerButton() throws InterruptedException {
        //Arrange
        var randomQuestion = ThreadLocalRandom.current().nextInt(1, 25 + 1);

        //Act
        homePage
                .navigateToMyPriorHomePage()
                .beginQuiz()
                .goToQuizPage()
                .chooseAnswer(randomQuestion);

        /* Store the expected cards, choose an answer to move to next question,
           click the change previous answer button, store the actual cards. This
           works but needs to be refactored and cleaned up. */
        String[] expectedCards = quizPage.storeCurrentCards();
        quizPage.chooseAnswer();
        quizPage.changePreviousAnswer();
        String[] actualCards = quizPage.storeCurrentCards();

        //Assert
        Assert.assertEquals(actualCards, expectedCards);
    }

}

