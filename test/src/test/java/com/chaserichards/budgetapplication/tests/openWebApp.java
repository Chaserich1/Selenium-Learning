package com.chaserichards.budgetapplication.tests;

import com.chaserichards.budgetapplication.pages.budgetapppages.BudgetAppHomePage;
import com.chaserichards.budgetapplication.webdrivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class openWebApp {

    protected WebDriver driver;
    private BudgetAppHomePage homePage;

    @BeforeTest
    public void localSetup() {
        driver = DriverFactory.getWebDriver("firefox");
        homePage = new BudgetAppHomePage(driver);
    }

    @AfterTest
    public void localCleanup() {
        driver.quit();
    }

    @Test(description = "Test to navigate to the web application")
    void openWebApplication() {
        //Arrange
        var expectedURL = "C:\\Users\\cnr1103\\GithubRepos\\Selenium-Learning\\budgetapplication\\src\\main\\java\\com\\chaserichards\\budgetapplication";

        //Act
        homePage.navigateToBudgetAppHomePage();

        //Assert
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }

}
