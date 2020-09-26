package com.daugherty.seleniumplayground;

import com.daugherty.seleniumplayground.api.trello.TrelloApi;
import com.daugherty.seleniumplayground.pages.trello.TrelloHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class TrelloTests {
    private WebDriver driver;
    private TrelloApi trelloApi;
    private TrelloHomePage trelloHomePage;
    private final String trelloLogin = "dbsseleniumautomation@gmail.com";
    private final String trelloPassword = "g0GXST7pTo7A";
    private final String trelloUserId = "dbsaccount";
    private final String trelloApiKey = "8ebbea51911462b2fc36cd47050378d7";
    private final String trelloAccessToken = "3f30df8cab0b6459af909e778b3617de659fb2dec621114fbb1fb08cab2e4377";

    @BeforeTest
    public void testSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        trelloHomePage = new TrelloHomePage(driver, trelloLogin, trelloPassword, trelloUserId);
        trelloApi = new TrelloApi(trelloApiKey, trelloAccessToken);
    }

    @AfterTest
    public void testTearDown() {
        driver.quit();
    }

    @Test
    void uiCanCreateTrelloBoard() throws InterruptedException {
        var now = LocalDateTime.now();
        var boardName = "test board" + now.toString();

        try {
            trelloHomePage.login()
                    .goToBoards()
                    .createNewBoard(boardName);
        } finally {
            trelloApi.deleteBoardByName(boardName);
        }


    }

    @Test
    void uiCanDeleteTrelloBoard() throws InterruptedException {

    }


}
