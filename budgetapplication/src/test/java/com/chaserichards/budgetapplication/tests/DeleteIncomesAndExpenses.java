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

public class DeleteIncomesAndExpenses extends BaseTestClass{

    protected MiddleInputItems middleInputSection;
    protected BottomListOfItems bottomListSection;
    protected TopTotalBudgetCalc topTotalBudgetCalc;
    protected Map<String, String> item;

    @BeforeTest
    public void localSetup() {
        homePage = new BudgetAppHomePage(driver);
        middleInputSection = new MiddleInputItems(driver);
        bottomListSection = new BottomListOfItems(driver);
        topTotalBudgetCalc = new TopTotalBudgetCalc(driver);
        item = new HashMap<>();
    }

    @Test(description="Test to confirm incomes and expenses can be removed successfully")
    void deleteIncome() throws InterruptedException {
        //Arrange
        item.put("type", "+");
        item.put("description", "TestItem");
        item.put("value", "10");

        //Act
        middleInputSection.addItem(item.get("type"), item.get("description"), item.get("value"));
        bottomListSection.deleteItemFromList("+");
        var itemFound = bottomListSection.checkForItemInList(item);

        //Assert
        Assert.assertFalse(itemFound);
    }

    @Test(description = "Test to confirm expenses can be removed")
    void deleteExpense() throws InterruptedException {
        //Arrange
        item.put("type", "+");
        item.put("description", "TestItem");
        item.put("value", "10");

        //Act
        middleInputSection.addItem(item.get("type"), item.get("description"), item.get("value"));
        bottomListSection.deleteItemFromList("+");
        var itemFound = bottomListSection.checkForItemInList(item);

        //Assert
        Assert.assertFalse(itemFound);
    }

}
