package com.chaserichards.budgetapplication.pages.budgetappcomponents;

import com.chaserichards.budgetapplication.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MiddleInputItems extends BasePage {
    public MiddleInputItems(WebDriver webDriver) {
        super(webDriver);
    }

    public void addItem(String type, String description, String value) {
        Select dropDownList = new Select(webDriver.findElement(By.className("add__type")));
        dropDownList.selectByVisibleText(type);

        webDriver.findElement(By.className("add__description")).sendKeys(description);
        webDriver.findElement(By.className("add__value")).sendKeys(value);

        submitItem();
    }

    public MiddleInputItems addExpense() {


        submitItem();
        return this;
    }

    public void submitItem() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("add__btn"))).click();
    }
}
