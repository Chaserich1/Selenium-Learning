package com.chaserichards.budgetapplication.pages.budgetapppages;

import com.chaserichards.budgetapplication.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class BudgetAppHomePage extends BasePage {

    public BudgetAppHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    //Return void because I will be breaking the page into components from here
    public void navigateToBudgetAppHomePage() {
        webDriver.get("C:\\Users\\cnr1103\\GithubRepos\\Selenium-Learning\\budgetapplication\\src\\main\\java\\com\\chaserichards\\budgetapplication\\index.html");
    }
}
