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

public class PercentageCalculation extends BaseTestClass{

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

    @Test(description = "Add an income and then add an expense checking that the percentage is the expected value")
    void checkPercentages() {
        Map<String, Object> allItems = new HashMap<>();
        Map<String, String> incomeItem = new HashMap<>();
        Map<String, String> expenseItem = new HashMap<>();
        String actualPercentage, expectedPercentage;

        middleInputSection.addIncome();
        middleInputSection.addExpense();
        incomeItem = bottomListSection.getItemFromList("+");
        expenseItem = bottomListSection.getItemFromList("-");
        allItems.put("incomes", incomeItem);
        allItems.put("expenses", expenseItem);

        //Get the percentage being displayed
        actualPercentage = expenseItem.get("percentage");

        expectedPercentage = bottomListSection.calculateExpectedPercentage(incomeItem.get("value"), expenseItem.get("value"));

        Assert.assertEquals(expectedPercentage, actualPercentage);
    }

}
