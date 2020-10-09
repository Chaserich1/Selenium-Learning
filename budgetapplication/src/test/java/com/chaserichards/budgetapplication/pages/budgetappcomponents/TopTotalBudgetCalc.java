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
}
