package com.chaserichards.budgetapplication.tests;

import com.chaserichards.budgetapplication.pages.budgetapppages.BudgetAppHomePage;
import com.chaserichards.budgetapplication.webdrivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTestClass {

    protected WebDriver driver;
    protected BudgetAppHomePage homePage;

    /*@BeforeSuite
    public void globalSetup() {
        driver = DriverFactory.getWebDriver("chrome");
    }*/

    @BeforeTest
    public void goToHomePage() {
        driver = DriverFactory.getWebDriver("chrome");
        driver.get("file:///C:/Users/cnr1103/GithubRepos/Selenium-Learning/budgetapplication/src/main/java/com/chaserichards/budgetapplication/index.html");
    }

    @AfterTest(alwaysRun = true)
    public void globalCleanup() {
        driver.quit();
    }
}
