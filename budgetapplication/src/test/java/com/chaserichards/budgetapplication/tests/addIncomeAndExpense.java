package com.chaserichards.budgetapplication.tests;

import com.chaserichards.budgetapplication.pages.budgetappcomponents.BottomListOfItems;
import com.chaserichards.budgetapplication.pages.budgetappcomponents.MiddleInputItems;
import com.chaserichards.budgetapplication.pages.budgetapppages.BudgetAppHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class addIncomeAndExpense extends BaseTestClass {
    protected MiddleInputItems middleInputSection;
    protected BottomListOfItems bottomListSection;

    @BeforeTest
    public void localSetup() {
        homePage = new BudgetAppHomePage(driver);
        middleInputSection = new MiddleInputItems(driver);
        bottomListSection = new BottomListOfItems(driver);
    }

    @Test(description="Test to confirm successful addition of income")
    void addIncomeTest() throws InterruptedException {
        //Arrange
        Map<String, String> expectedItemDetails = new HashMap<String, String>();
        expectedItemDetails.put("type", "+");
        expectedItemDetails.put("description", "Project");
        expectedItemDetails.put("value", "100.00");

        Map<String, String> actualItemDetails = new HashMap<String, String>();

        //Act
        middleInputSection.addItem(expectedItemDetails.get("type"), expectedItemDetails.get("description"), expectedItemDetails.get("value"));
        actualItemDetails = bottomListSection.getItemFromList(expectedItemDetails.get("type"));

        //Assert
        Assert.assertTrue(expectedItemDetails.equals(actualItemDetails));
        Thread.sleep(2000);
    }

    @Test(description="Test to confirm successful addition of expense")
    void addExpenseTest() throws InterruptedException {
        //Arrange
        Map<String, String> expectedItemDetails = new HashMap<String, String>();
        expectedItemDetails.put("type", "-");
        expectedItemDetails.put("description", "Food");
        expectedItemDetails.put("value", "14.75");

        Map<String, String> actualItemDetails = new HashMap<String, String>();

        //Act
        middleInputSection.addItem(expectedItemDetails.get("type"), expectedItemDetails.get("description"), expectedItemDetails.get("value"));
        actualItemDetails = bottomListSection.getItemFromList(expectedItemDetails.get("type"));

        //Assert
        Assert.assertTrue(expectedItemDetails.equals(actualItemDetails));
        Thread.sleep(2000);
    }

}
