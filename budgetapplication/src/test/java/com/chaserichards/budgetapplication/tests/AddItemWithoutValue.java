package com.chaserichards.budgetapplication.tests;

import com.chaserichards.budgetapplication.pages.budgetappcomponents.AlertHandler;
import com.chaserichards.budgetapplication.pages.budgetappcomponents.BottomListOfItems;
import com.chaserichards.budgetapplication.pages.budgetappcomponents.MiddleInputItems;
import com.chaserichards.budgetapplication.pages.budgetappcomponents.TopTotalBudgetCalc;
import com.chaserichards.budgetapplication.pages.budgetapppages.BudgetAppHomePage;
import com.google.errorprone.annotations.Var;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddItemWithoutValue extends BaseTestClass{

    protected MiddleInputItems middleInputSection;
    protected BottomListOfItems bottomListSection;
    protected TopTotalBudgetCalc topTotalBudgetCalc;
    protected AlertHandler alertPopUp;

    @BeforeTest
    public void localSetup() {
        homePage = new BudgetAppHomePage(driver);
        middleInputSection = new MiddleInputItems(driver);
        bottomListSection = new BottomListOfItems(driver);
        topTotalBudgetCalc = new TopTotalBudgetCalc(driver);
        alertPopUp = new AlertHandler(driver);
    }

    @Test
    void UnableToAddItemWithoutValue() throws InterruptedException {
        //Arrange
        String actualAlertText;
        var expectedAlertText = "Need to enter all necessary fields";

        //Act
        middleInputSection.addItem("+", "Item without Value", "");
        actualAlertText = alertPopUp.getAlertText();

        //Assert
        Assert.assertEquals(expectedAlertText, actualAlertText);
    }
}
