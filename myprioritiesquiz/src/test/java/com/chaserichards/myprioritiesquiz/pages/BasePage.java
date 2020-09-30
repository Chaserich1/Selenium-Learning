package com.chaserichards.myprioritiesquiz.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        wait.until(pageLoadCondition);
    }

}
