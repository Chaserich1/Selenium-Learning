package com.chaserichards.myprioritiesquiz.pages.mypriorities;

import com.chaserichards.myprioritiesquiz.pages.BasePage;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyPrioritiesResultsPage extends BasePage {
    public MyPrioritiesResultsPage(WebDriver webDriver) { super(webDriver); }

    //Return ResultsPage in case we need to do more checks on this page
    public MyPrioritiesResultsPage onResultsPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ResultsPage")));
        return this;
    }

}
