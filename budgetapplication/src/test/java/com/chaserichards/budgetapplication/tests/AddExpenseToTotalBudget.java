package com.chaserichards.budgetapplication.tests;

import com.chaserichards.budgetapplication.pages.budgetappcomponents.BottomListOfItems;
import com.chaserichards.budgetapplication.pages.budgetappcomponents.MiddleInputItems;
import com.chaserichards.budgetapplication.pages.budgetappcomponents.TopTotalBudgetCalc;
import com.chaserichards.budgetapplication.pages.budgetapppages.BudgetAppHomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class AddExpenseToTotalBudget extends BaseTestClass {
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

    @Test(description = "Test to check the total budget value compared to added incomes and expenses")
    void checkTotalBudgetWithExpense() throws InterruptedException {
        driver.navigate().refresh();
        //Arrange
        Map<String, String> itemDetails = new HashMap<String, String>();
        Double expectedTotalBudget, actualTotalBudget;

        //Act
        middleInputSection.addExpense();
        itemDetails = bottomListSection.getItemFromList("-");
        expectedTotalBudget = Double.parseDouble(itemDetails.get("value"));
        actualTotalBudget = topTotalBudgetCalc.getTotalBudget();

        //Assert
        assertEquals(expectedTotalBudget, actualTotalBudget);
    }

}
