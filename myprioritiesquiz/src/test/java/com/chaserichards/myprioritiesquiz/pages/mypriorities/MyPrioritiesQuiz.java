package com.chaserichards.myprioritiesquiz.pages.mypriorities;

import com.chaserichards.myprioritiesquiz.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyPrioritiesQuiz extends BasePage {

    public MyPrioritiesQuiz(WebDriver webDriver) { super(webDriver); }

    public MyPrioritiesQuiz chooseAnswer() {
        //Generate random value of either 1 or 2
        var randomAnswer = (Math.random() <= 0.5) ? "one" : "two";

        wait.until(ExpectedConditions.elementToBeClickable(By.id("value-card-" + randomAnswer))).click();
        return this;
    }

    //Return void because we change to the results page
    public void resultsPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ResultsPage")));
    }
}
