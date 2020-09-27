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

    //Return void because this will take us to the quiz page which will be a separate class
    public void beginQuiz() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("get-started-button"))).click();
    }
}
