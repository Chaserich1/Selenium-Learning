package com.chaserichards.budgetapplication.pages.budgetappcomponents;

import com.chaserichards.budgetapplication.pages.BasePage;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class BottomListOfItems extends BasePage {
    public BottomListOfItems(WebDriver webDriver) {
        super(webDriver);
    }

    public Map<String, String> getItemFromList(String itemType) {
        Map<String, String> itemDetails = new HashMap<String, String>();
        String itemDesc, itemValue;

        if(itemType == "+") {
            //Get the values from the UI
            itemDesc = webDriver.findElement(By.xpath("//div[@id='inc-0']//div[@class='item__description']")).getText();
            itemValue = webDriver.findElement(By.xpath("//div[@id='inc-0']//div['right clearfix']//div[@class='item__value']")).getText();
        } else {
            //Get the values from the UI
            itemDesc = webDriver.findElement(By.xpath("//div[@id='exp-0']//div[@class='item__description']")).getText();
            itemValue = webDriver.findElement(By.xpath("//div[@id='exp-0']//div['right clearfix']//div[@class='item__value']")).getText();
        }

        //Add them to the map and return it
        itemDetails.put("type", itemType);
        itemDetails.put("description", itemDesc);
        itemDetails.put("value", itemValue.substring(2));

        return itemDetails;
    }
}
