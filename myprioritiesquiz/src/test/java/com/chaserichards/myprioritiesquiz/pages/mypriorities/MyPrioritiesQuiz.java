package com.chaserichards.myprioritiesquiz.pages.mypriorities;

import com.chaserichards.myprioritiesquiz.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyPrioritiesQuiz extends BasePage {

    public MyPrioritiesQuiz(WebDriver webDriver) { super(webDriver); }

    public MyPrioritiesQuiz chooseAnswer() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("value-card-one"))).click();
        return this;
    }
}
