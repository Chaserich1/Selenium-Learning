package com.chaserichards.budgetapplication.pages;

import org.jsoup.Connection;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    final static int timeOutInSeconds = 12;
    final protected WebDriver webDriver;
    final protected WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this(webDriver, timeOutInSeconds);
    }

    public BasePage(WebDriver webDriver, int maxWaitTimeSeconds) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, maxWaitTimeSeconds);
    }

    protected void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = webDriver -> ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete");
        wait.until(pageLoadCondition);
    }
}
