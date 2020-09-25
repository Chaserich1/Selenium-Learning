package com.chaserichards.myprioritiesquiz.pages.mypriorities;

import com.chaserichards.myprioritiesquiz.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyPrioritiesHomePage extends BasePage {

    public MyPrioritiesHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MyPrioritiesHomePage navigateToMyPriorHomePage() {
        webDriver.get("https://mypriorities.edwardjones.com/");
        return this;
    }
}
