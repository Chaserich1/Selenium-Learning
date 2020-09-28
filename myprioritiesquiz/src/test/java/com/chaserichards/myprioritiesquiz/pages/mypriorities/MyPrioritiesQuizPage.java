package com.chaserichards.myprioritiesquiz.pages.mypriorities;

import com.chaserichards.myprioritiesquiz.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MyPrioritiesQuizPage extends BasePage {

    public MyPrioritiesQuizPage(WebDriver webDriver) { super(webDriver); }

    private List<String> cardList = new ArrayList<String>();

    //Choose a random card on each page of the quiz until the end if no random value passed in
    public MyPrioritiesQuizPage chooseAnswer() {
        //Generate random value of either 1 or 2
        var randomAnswer = (Math.random() <= 0.5) ? "one" : "two";

        while(true) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.id("value-card-" + randomAnswer))).click();
            } catch (Exception e) {
                break;
            }

        }

        return this;
    }

    //Choose a random card on each page of the quiz until random specified question
    public MyPrioritiesQuizPage chooseAnswer(int randomQuestion) {
        //Generate random value of either 1 or 2
        var randomAnswer = (Math.random() <= 0.5) ? "one" : "two";

        for(var i = 0; i < randomQuestion; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("value-card-one")));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("value-card-two")));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("value-card-" + randomAnswer))).click();
        }

        return this;
    }

    //Store and return the current page cards
    public MyPrioritiesQuizPage storeCurrentCards() throws InterruptedException {
        Thread.sleep(1000);
        var expectedCardOne = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("value-card-one"))).getText();
        var expectedCardTwo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("value-card-two"))).getText();

        cardList.add(expectedCardOne);
        cardList.add(expectedCardTwo);
        //System.out.println(expectedCardOne + "  :  " + expectedCardTwo);

        return this;
    }

    //Click change previous answer button
    public MyPrioritiesQuizPage changePreviousAnswer() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("change-previous-button"))).click();

        return this;
    }

    public MyPrioritiesResultsPage goToResultsPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ResultsPage")));

        return new MyPrioritiesResultsPage(webDriver);
    }

    //Getter for the list of stored cards for testing the previous answer button
    public List<String> getCardList() {
        return this.cardList;
    }
}
