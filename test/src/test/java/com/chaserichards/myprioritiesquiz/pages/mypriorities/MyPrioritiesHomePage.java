package com.chaserichards.myprioritiesquiz.pages.mypriorities;

import com.chaserichards.myprioritiesquiz.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyPrioritiesHomePage extends BasePage {

    public MyPrioritiesHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MyPrioritiesHomePage navigateToMyPriorHomePage() {
        webDriver.get("https://mypriorities.edwardjones.com/");
        return this;
    }

    public MyPrioritiesHomePage beginQuiz() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("get-started-button"))).click();
        return this;
    }

    public MyPrioritiesQuizPage goToQuizPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("quizPage")));

        return new MyPrioritiesQuizPage(webDriver);
    }

}
