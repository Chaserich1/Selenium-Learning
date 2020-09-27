package com.chaserichards.myprioritiesquiz.pages.mypriorities;

import com.chaserichards.myprioritiesquiz.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyPrioritiesQuizPage extends BasePage {

    public MyPrioritiesQuizPage(WebDriver webDriver) { super(webDriver); }

    //Choose a random card on each page of the quiz until the end if no random value passed in
    public MyPrioritiesQuizPage chooseAnswer() {
        //Generate random value of either 1 or 2
        var randomAnswer = (Math.random() <= 0.5) ? "one" : "two";

        for(var i = 0; i < 26; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("value-card-" + randomAnswer))).click();
        }

        return this;
    }

    //Choose a random card on each page of the quiz until random specified question
    public MyPrioritiesQuizPage chooseAnswer(int randomQuestion) {
        //Generate random value of either 1 or 2
        var randomAnswer = (Math.random() <= 0.5) ? "one" : "two";

        for(var i = 0; i < randomQuestion; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("value-card-" + randomAnswer))).click();
        }

        return this;
    }

    //Store and return the current page cards
    public String[] storeCurrentCards() {
        var expectedCardOne = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("value-card-one"))).getText();
        var expectedCardTwo = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("value-card-two"))).getText();
        String[] expectedElementArray = {expectedCardOne, expectedCardTwo};

        return expectedElementArray;
    }

    //Click change previous answer button
    public void changePreviousAnswer() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("change-previous-button"))).click();
    }

    public MyPrioritiesResultsPage goToResultsPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ResultsPage")));

        return new MyPrioritiesResultsPage(webDriver);
    }
}
