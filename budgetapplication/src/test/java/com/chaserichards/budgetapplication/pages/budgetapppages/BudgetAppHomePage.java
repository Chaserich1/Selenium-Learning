package com.chaserichards.budgetapplication.pages.budgetapppages;

import com.chaserichards.budgetapplication.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BudgetAppHomePage extends BasePage {

    public BudgetAppHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    //Return void because I will be breaking the page into components from here
    public BudgetAppHomePage navigateToBudgetAppHomePage() {

        webDriver.get("file:///C:/Users/cnr1103/GithubRepos/Selenium-Learning/budgetapplication/src/main/java/com/chaserichards/budgetapplication/index.html");

        return this;
    }
}
