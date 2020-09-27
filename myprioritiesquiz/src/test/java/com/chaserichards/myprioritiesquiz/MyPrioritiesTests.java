package com.chaserichards.myprioritiesquiz;

import com.chaserichards.myprioritiesquiz.pages.mypriorities.MyPrioritiesHomePage;
import com.chaserichards.myprioritiesquiz.pages.mypriorities.MyPrioritiesQuiz;
import com.chaserichards.myprioritiesquiz.webdrivers.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class MyPrioritiesTests {
    protected WebDriver driver;
    private MyPrioritiesHomePage homePage;
    private MyPrioritiesQuiz quizPage;

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
        homePage
                .navigateToMyPriorHomePage()
                .beginQuiz();

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), expectedURl);

        Thread.sleep(3000);
    }

    @Test(description = "Test to confirm that a random card (1 or 2) can be selected through the entire quiz and makes it to results page")
    void chooseOptionsUntilResultsPage() throws InterruptedException {
        //Arrange
        var expectedURL = "https://mypriorities.edwardjones.com/results";
        quizPage = new MyPrioritiesQuiz(driver);

        //Act
        openHomepageAndBeginQuiz();
        //for(var i = 0; i < 26; i++) {
        while(driver.getCurrentUrl().equals("https://mypriorities.edwardjones.com/quiz")) {
            quizPage.chooseAnswer();
        }

        //Wait for the page the results page to load
        quizPage.resultsPage();

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        Thread.sleep(3000);
    }

    @Test(description = "Test to confirm change previous answer button works")
    void changePreviousAnswerButton() throws InterruptedException {
        //Arrange
        var randomQuestion = ThreadLocalRandom.current().nextInt(1, 26 + 1);
        quizPage = new MyPrioritiesQuiz(driver);

        //Act
        openHomepageAndBeginQuiz();
        for(var i = 0; i < randomQuestion; i++) {
            quizPage.chooseAnswer();
        }

        /* Store the expected cards, choose an answer to move to next question,
           click the change previous answer button, store the actual cards. This
           works but needs to be refactored and cleaned up. */
        Thread.sleep(2000);
        String[] expectedCards = quizPage.storeCurrentCards();
        quizPage.chooseAnswer();
        quizPage.changePreviousAnswer();
        String[] actualCards = quizPage.storeCurrentCards();

        //Assert
        Assert.assertEquals(actualCards, expectedCards);
    }

}

