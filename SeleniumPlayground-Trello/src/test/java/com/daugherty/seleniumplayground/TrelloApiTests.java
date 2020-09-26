package com.daugherty.seleniumplayground;

import com.daugherty.seleniumplayground.api.trello.TrelloApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.client.methods.HttpGet;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class TrelloApiTests {
    private final String trelloApiKey = "8ebbea51911462b2fc36cd47050378d7";
    private final String trelloAccessToken = "3f30df8cab0b6459af909e778b3617de659fb2dec621114fbb1fb08cab2e4377";
    private TrelloApi trelloApi;

    @BeforeTest
    public void testSetup() {
        trelloApi = new TrelloApi(trelloApiKey, trelloAccessToken);
    }

    @Test
    void createAndDeleteBoardTest() throws InterruptedException {
        var now = LocalDateTime.now();
        var boardName = "test board" + now.toString();
        Assert.assertTrue(trelloApi.getBoardsByName(boardName).length == 0);

        trelloApi.createBoard(boardName);
        Assert.assertTrue(trelloApi.getBoardsByName(boardName).length > 0);
        trelloApi.deleteBoardByName(boardName);
    }

}
