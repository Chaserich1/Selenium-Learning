package com.daugherty.seleniumplayground.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    final static int defaultMaxWaitTimeSeconds = 10;
    final protected WebDriver webDriver;
    final protected WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this(webDriver, defaultMaxWaitTimeSeconds);
    }

    public BasePage(WebDriver webDriver, int maxWaitTimeSeconds) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, maxWaitTimeSeconds);
    }

    protected void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
        wait.until(pageLoadCondition);
    }
}
