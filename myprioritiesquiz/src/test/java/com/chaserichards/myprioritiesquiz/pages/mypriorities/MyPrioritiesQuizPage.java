package com.chaserichards.myprioritiesquiz.pages.mypriorities;

import com.chaserichards.myprioritiesquiz.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyPrioritiesQuizPage extends BasePage {

    public MyPrioritiesQuizPage(WebDriver webDriver) { super(webDriver); }

    private List<String> cardList = new ArrayList<String>();
    private Map<String, Integer> selectedAnswers = new HashMap<String, Integer>();

    //Choose a random card on each page of the quiz until the end if no random value passed in
    public MyPrioritiesQuizPage chooseAnswer() {
        //Generate random value of either 1 or 2
        var randomAnswer = (Math.random() <= 0.5) ? "one" : "two";

        while(true) {
            try {
                //Get the card text
                var selectedCardText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("value-card-" + randomAnswer))).getText();
                //If the key does not exist add it with the value 1, otherwise sum 1 to the value linked to the key (card text)
                selectedAnswers.merge(selectedCardText, 1, Integer::sum);
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

    //Store the current cards in our cardList
    public MyPrioritiesQuizPage storeCurrentCards() throws InterruptedException {
        Thread.sleep(2000);
        var expectedCardOne = webDriver.findElement(By.className("value-card-1")).getAttribute("aria-label");
        var expectedCardTwo = webDriver.findElement(By.className("value-card-2")).getAttribute("aria-label");

        cardList.add(expectedCardOne);
        cardList.add(expectedCardTwo);
        //System.out.println(expectedCardOne + " : " + expectedCardTwo);

        return this;
    }

    //Click the change previous answer button
    public MyPrioritiesQuizPage changePreviousAnswer() throws InterruptedException {

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

    //Getter for the hashmap that stored the selections and number of times they were selected
    public Map<String, Integer> getCardSelectionFrequencies() {
        for(Map.Entry m : selectedAnswers.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
        return this.selectedAnswers;
    }

    //Getter for the hashmap of selected answers
    public Map<String, Integer> getSelectedAnswers() {
        return this.selectedAnswers;
    }
}
