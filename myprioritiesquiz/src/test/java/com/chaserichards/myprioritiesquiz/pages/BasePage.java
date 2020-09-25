package com.chaserichards.myprioritiesquiz.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    final static int baseWaitTime = 12;
    final protected WebDriver webDriver;
    final protected WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this(webDriver, baseWaitTime);
    }

    public BasePage(WebDriver webDriver, int maxWaitTimeSeconds) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, maxWaitTimeSeconds);
    }

}
