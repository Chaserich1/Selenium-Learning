package com.chaserichards.budgetapplication.pages.budgetappcomponents;

import com.chaserichards.budgetapplication.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopTotalBudgetCalc extends BasePage {
    public TopTotalBudgetCalc(WebDriver webDriver) {
        super(webDriver);
    }

    public double getTotalBudget() {
        String totalBudgetAsString = webDriver.findElement(By.className("budget__value")).getText();
        double totalBudgetAsDouble = Double.parseDouble(totalBudgetAsString.substring(2));
        return totalBudgetAsDouble;
    }

    public String getTotalExpensesPercentage() {
        String totalPercentageAsString = webDriver.findElement(By.className("budget__expenses--percentage")).getText();
        return totalPercentageAsString;
    }

    public Double getTotalIncomeBudget () {
        var totalIncomeBudgetAsString = webDriver.findElement(By.className("budget__income--value")).getText();
        var totalIncomeBudgetDouble = Double.parseDouble(totalIncomeBudgetAsString.substring(2));
        return totalIncomeBudgetDouble;
    }

    public Double getTotalExpenseBudget () {
        var totalExpenseBudgetAsString = webDriver.findElement(By.className("budget__expenses--value")).getText();
        var totalExpenseBudgetDouble = Double.parseDouble(totalExpenseBudgetAsString.substring(2));
        return totalExpenseBudgetDouble;
    }

    public String calculateTotalExpensePercentage () {
        Double totalIncomeBudget, totalExpenseBudget;
        totalIncomeBudget = getTotalIncomeBudget();
        totalExpenseBudget = getTotalExpenseBudget();

        var totalExpensePercentage = Math.round((totalExpenseBudget / totalIncomeBudget) * 100);
        var totalExpensePercentageAsString = String.valueOf((int) totalExpensePercentage);

        return totalExpensePercentageAsString + "%";
    }
}
