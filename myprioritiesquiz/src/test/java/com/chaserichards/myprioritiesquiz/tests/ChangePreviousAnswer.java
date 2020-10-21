package com.chaserichards.myprioritiesquiz.tests;

import com.chaserichards.myprioritiesquiz.pages.mypriorities.MyPrioritiesHomePage;
import com.chaserichards.myprioritiesquiz.webdrivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class ChangePreviousAnswer {

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

    @Test(description = "Test to confirm change previous answer button works")
    void changePreviousAnswerButton() throws InterruptedException {
        //Arrange
        Random r = new Random();
        var randomQuestion = r.nextInt(26 - 2) + 2;
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
        assertTrue(cardList.get(0).equals(cardList.get(2)) && cardList.get(1).equals(cardList.get(3)));

        Thread.sleep(2000);
    }
}
