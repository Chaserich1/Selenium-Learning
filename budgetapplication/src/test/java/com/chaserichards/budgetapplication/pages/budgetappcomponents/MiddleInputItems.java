package com.chaserichards.budgetapplication.pages.budgetappcomponents;

import com.chaserichards.budgetapplication.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class MiddleInputItems extends BasePage {
    public MiddleInputItems(WebDriver webDriver) {
        super(webDriver);
    }

    //Add an expense or income (randomly) and use default description and value
    public String addItem() {
        Select dropDownList = new Select(webDriver.findElement(By.className("add__type")));
        //Generate random value of either + or -
        var type = (Math.random() <= 0.5) ? "+" : "-";
        dropDownList.selectByVisibleText(type);
        var randomValue = ThreadLocalRandom.current().nextInt(2, 100);
        String randomValueAsString = Integer.toString(randomValue);
        randomValueAsString += ".00";

        webDriver.findElement(By.className("add__description")).sendKeys("Default");
        webDriver.findElement(By.className("add__value")).sendKeys(randomValueAsString);

        submitItem();
        return type;
    }

    public void addIncome() {
        Select dropDownList = new Select(webDriver.findElement(By.className("add__type")));
        //Generate random value of either + or -
        var type = "+";
        dropDownList.selectByVisibleText(type);
        var randomValue = ThreadLocalRandom.current().nextInt(2, 100);
        String randomValueAsString = Integer.toString(randomValue);
        randomValueAsString += ".00";

        webDriver.findElement(By.className("add__description")).sendKeys("Default");
        webDriver.findElement(By.className("add__value")).sendKeys(randomValueAsString);

        submitItem();
    }

    public void addExpense() {
        Select dropDownList = new Select(webDriver.findElement(By.className("add__type")));
        //Generate random value of either + or -
        var type = "-";
        dropDownList.selectByVisibleText(type);
        var randomValue = ThreadLocalRandom.current().nextInt(2, 100);
        String randomValueAsString = Integer.toString(randomValue);
        randomValueAsString += ".00";

        webDriver.findElement(By.className("add__description")).sendKeys("Default");
        webDriver.findElement(By.className("add__value")).sendKeys(randomValueAsString);

        submitItem();
    }

    //Overload method to add an item with specific values
    public void addItem(String type, String description, String value) {
        Select dropDownList = new Select(webDriver.findElement(By.className("add__type")));
        dropDownList.selectByVisibleText(type);

        webDriver.findElement(By.className("add__description")).sendKeys(description);
        webDriver.findElement(By.className("add__value")).sendKeys(value);

        submitItem();
    }

    public void submitItem() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("add__btn"))).click();
    }
}
