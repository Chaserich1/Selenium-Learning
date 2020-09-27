package com.daugherty.seleniumplayground;

import com.daugherty.seleniumplayground.api.trello.TrelloApi;
import com.daugherty.seleniumplayground.pages.trello.TrelloHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    protected Object[][] invalidEmailDataProvider() {
        return new Object[][] {
                {""},
                {"Chase@gmail.com"},
                {"Chasegmail.com"}
        };
    }

    @Test(dataProvider = "invalidEmailDataProvider")
    public void failedLoginWithInvalidId(String invalidLoginId) throws InterruptedException {
        trelloHomePage.login(invalidLoginId);

        //Post Login attempt, if the url is still equal to the login page then trello successfully denied the login
        String loggedInURl = "https://trello.com/login";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(loggedInURl, currentURL);
    }


}
