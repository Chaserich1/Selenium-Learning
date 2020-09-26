package com.daugherty.seleniumplayground.pages.trello;

import com.daugherty.seleniumplayground.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrelloBoardsPage extends BasePage {
    public TrelloBoardsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void createNewBoard(String boardName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-test-id='create-board-tile']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[data-test-id='create-board-title-input']"))).sendKeys(boardName);
        webDriver.findElement(By.cssSelector("button[data-test-id='create-board-submit-button']")).submit();
    }

}
