package com.chaserichards.budgetapplication.pages.budgetappcomponents;

import com.chaserichards.budgetapplication.pages.BasePage;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class BottomListOfItems extends BasePage {
    public BottomListOfItems(WebDriver webDriver) {
        super(webDriver);
    }

    public Map<String, String> getItemFromList(String itemType) {
        Map<String, String> itemDetails = new HashMap<String, String>();
        String itemDesc, itemValue, itemPercentage;

        if(itemType == "+") {
            //Get the values from the UI
            itemDesc = webDriver.findElement(By.xpath("//div[@id='inc-0']//div[@class='item__description']")).getText();
            itemValue = webDriver.findElement(By.xpath("//div[@id='inc-0']//div['right clearfix']//div[@class='item__value']")).getText();
        } else {
            //Get the values from the UI
            itemDesc = webDriver.findElement(By.xpath("//div[@id='exp-0']//div[@class='item__description']")).getText();
            itemValue = webDriver.findElement(By.xpath("//div[@id='exp-0']//div['right clearfix']//div[@class='item__value']")).getText();
            itemPercentage = webDriver.findElement(By.xpath("//div[@id='exp-0']//div[@class='item__percentage']")).getText();
            itemDetails.put("percentage", itemPercentage);
        }

        //Add them to the map and return it
        itemDetails.put("type", itemType);
        itemDetails.put("description", itemDesc);
        itemDetails.put("value", itemValue.substring(2)); //Use substring to get rid of the +

        return itemDetails;
    }

    public void deleteItemFromList(String itemType) throws InterruptedException {
        Map<String, String> itemDetails = new HashMap<String, String>();
        itemDetails = getItemFromList(itemType);
        Actions builder = new Actions(webDriver);

        //Need action builder because the delete button is hidden initially
        if(itemType == "+") {
            WebElement itemToDelete = webDriver.findElement(By.xpath("//div[@id='inc-0']"));
            builder.moveToElement(itemToDelete);
            WebElement deleteButton = webDriver.findElement(By.xpath("//div[@id='inc-0']//button[@class='item__delete--btn']"));
            builder.moveToElement(deleteButton);
            builder.click().build().perform();
        } else {
            WebElement itemToDelete = webDriver.findElement(By.xpath("//div[@id='exp-0']"));
            builder.moveToElement(itemToDelete);
            WebElement deleteButton = webDriver.findElement(By.xpath("//div[@id='exp-0']//button[@class='item__delete--btn']"));
            builder.moveToElement(deleteButton);
            builder.click().build().perform();
        }
        Thread.sleep(5000);
    }

    public Boolean checkForItemInList(Map<String, String> lookupItem) {
        String itemType, itemDesc, itemValue;

        if(lookupItem.get("type") == "+") {
            if(webDriver.findElements(By.xpath("//div[@id='inc-0']")).size() != 0) {
                //Get the values from the UI
                itemDesc = webDriver.findElement(By.xpath("//div[@id='inc-0']//div[@class='item__description']")).getText();
                itemValue = webDriver.findElement(By.xpath("//div[@id='inc-0']//div['right clearfix']//div[@class='item__value']")).getText();
                return true;
            } else {
                return false;
            }
        } else {
            if(webDriver.findElements(By.xpath("//div[@id='exp-0']")).size() != 0) {
                //Get the values from the UI
                itemDesc = webDriver.findElement(By.xpath("//div[@id='exp-0']//div[@class='item__description']")).getText();
                itemValue = webDriver.findElement(By.xpath("//div[@id='exp-0']//div['right clearfix']//div[@class='item__value']")).getText();
                return true;
            } else {
                return false;
            }
        }
    }

    public String calculateExpectedPercentage(String incomeAsString, String expenseAsString) {
        String percentageAsString;
        double incomeDouble, expenseDouble, percentageDouble;

        incomeDouble = Double.parseDouble(incomeAsString);
        expenseDouble = Double.parseDouble(expenseAsString);

        percentageDouble = Math.round((expenseDouble / incomeDouble) * 100);
        percentageAsString = String.valueOf((int) percentageDouble);

        return percentageAsString + "%";
    }
}
