package com.chaserichards.budgetapplication.tests;

import com.chaserichards.budgetapplication.pages.budgetappcomponents.BottomListOfItems;
import com.chaserichards.budgetapplication.pages.budgetappcomponents.MiddleInputItems;
import com.chaserichards.budgetapplication.pages.budgetappcomponents.TopTotalBudgetCalc;
import com.chaserichards.budgetapplication.pages.budgetapppages.BudgetAppHomePage;
import com.chaserichards.budgetapplication.webdrivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class OpenWebApp extends BaseTestClass{

    @BeforeTest
    public void localSetup() {
        homePage = new BudgetAppHomePage(driver);
    }

    @Test(description = "Test to navigate to the web application")
    void openWebApplication() throws InterruptedException {
        //Arrange
        var expectedTitle = "Budgety";

        //Act
        homePage.navigateToBudgetAppHomePage();

        //Assert
        Assert.assertEquals(expectedTitle, driver.getTitle());

        Thread.sleep(2000);
    }

}
