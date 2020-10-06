package com.chaserichards.budgetapplication.tests;

import com.chaserichards.budgetapplication.pages.budgetapppages.BudgetAppHomePage;
import com.chaserichards.budgetapplication.webdrivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class openWebApp extends BaseTestClass{

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
