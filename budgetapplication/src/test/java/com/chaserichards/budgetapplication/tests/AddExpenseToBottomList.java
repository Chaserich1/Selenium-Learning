package com.chaserichards.budgetapplication.tests;

import com.chaserichards.budgetapplication.pages.budgetappcomponents.BottomListOfItems;
import com.chaserichards.budgetapplication.pages.budgetappcomponents.MiddleInputItems;
import com.chaserichards.budgetapplication.pages.budgetappcomponents.TopTotalBudgetCalc;
import com.chaserichards.budgetapplication.pages.budgetapppages.BudgetAppHomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class AddExpenseToBottomList extends BaseTestClass {

    protected MiddleInputItems middleInputSection;
    protected BottomListOfItems bottomListSection;
    protected TopTotalBudgetCalc topTotalBudgetCalc;

    @BeforeTest
    public void localSetup() {
        homePage = new BudgetAppHomePage(driver);
        middleInputSection = new MiddleInputItems(driver);
        bottomListSection = new BottomListOfItems(driver);
        topTotalBudgetCalc = new TopTotalBudgetCalc(driver);
    }

    @Test(description="Test to confirm successful addition of expense")
    void addExpenseToBottomList() {
        //Arrange
        Map<String, String> expectedItemDetails = new HashMap<String, String>();
        expectedItemDetails.put("percentage", "---");
        expectedItemDetails.put("type", "-");
        expectedItemDetails.put("description", "Food");
        expectedItemDetails.put("value", "14.75");

        Map<String, String> actualItemDetails = new HashMap<String, String>();

        //Act
        middleInputSection.addItem(expectedItemDetails.get("type"), expectedItemDetails.get("description"), expectedItemDetails.get("value"));
        actualItemDetails = bottomListSection.getItemFromList(expectedItemDetails.get("type"));

        //Assert
        assertTrue(expectedItemDetails.equals(actualItemDetails));
    }
}
