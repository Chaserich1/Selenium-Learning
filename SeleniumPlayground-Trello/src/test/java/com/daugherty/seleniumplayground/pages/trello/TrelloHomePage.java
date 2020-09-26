package com.daugherty.seleniumplayground.pages.trello;

import com.daugherty.seleniumplayground.api.trello.TrelloBoard;
import com.daugherty.seleniumplayground.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TrelloHomePage extends BasePage {
    private String loginEmail;
    private String loginPassword;
    private String userId;

    public TrelloHomePage(WebDriver webDriver, String loginEmail, String loginPassword, String userId) {
        super(webDriver);
        this.loginEmail = loginEmail;
        this.loginPassword = loginPassword;
        this.userId = userId;
    }

    public TrelloHomePage login() {
        String expectedURL = "https://trello.com/login";
        webDriver.navigate().to(expectedURL);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("user"))).sendKeys(this.loginEmail);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys(loginPassword);
        webDriver.findElement(By.id("login")).click();

        return this;
    }

    public TrelloBoardsPage goToBoards() {
        wait.until(ExpectedConditions.titleContains("Boards | Trello"));

        return new TrelloBoardsPage(webDriver);
    }

    public TrelloBoardPage goToBoard(String boardUrl) {
        webDriver.navigate().to(boardUrl);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".board-main-content")));

       return new TrelloBoardPage(webDriver);
    }

}
