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

    @BeforeTest
    public void localSetup() {
        homePage = new BudgetAppHomePage(driver);
        middleInputSection = new MiddleInputItems(driver);
        bottomListSection = new BottomListOfItems(driver);
        topTotalBudgetCalc = new TopTotalBudgetCalc(driver);
    }

    @Test(description="Test to confirm incomes and expenses can be removed successfully")
    void deleteIncomesAndExpenses() throws InterruptedException {
        //Arrange
        var type = (Math.random() <= 0.5) ? "+" : "-";
        Map<String, String> item = new HashMap<>();
        item.put("type", type);
        item.put("description", "TestItem");
        item.put("value", "10");

        //Act
        middleInputSection.addItem(type, "TestItem", "10");
        bottomListSection.deleteItemFromList(type);
        var itemFound = bottomListSection.checkForItemInList(item);

        //Assert
        Assert.assertFalse(itemFound);

        Thread.sleep(5000);
    }

}
