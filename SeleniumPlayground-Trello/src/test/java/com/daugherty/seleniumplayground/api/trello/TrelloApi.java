package com.daugherty.seleniumplayground.api.trello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TrelloApi {

    private final String apiKey;
    private final String accessToken;

    public TrelloApi(String apiKey, String accessToken) {
        this.apiKey = apiKey;
        this.accessToken = accessToken;
    }

    public TrelloBoard[] getBoards() {
        var url = String.format("https://api.trello.com/1/members/me/boards?key=%s&token=%s", apiKey, accessToken);
        var response = get(url);
        var mapper = new ObjectMapper();
        try {
            return mapper.readValue(response.body(), TrelloBoard[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new TrelloBoard[0];
    }

    public TrelloBoard[] getBoardsByName(String boardName) {
       return Arrays.asList(getBoards()).stream()
               .filter(board -> board.getName().equals(boardName))
               .toArray(TrelloBoard[]::new);
    }

    public void deleteBoardByName(String boardName) {
        var boards = getBoardsByName(boardName);
        if(boards.length > 0) {
            deleteBoardById(boards[0].getShortLink());
        }
    }

    public void deleteBoardById(String id) {
        var url = String.format("https://api.trello.com/1/boards/%s?key=%s&token=%s", id, apiKey, accessToken);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .DELETE()
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createBoard(String boardName) {
        var url = String.format("https://api.trello.com/1/boards?name=%s&key=%s&token=%s&defaultLists=false", encode(boardName), apiKey, accessToken);
        post(url, "");
    }

    private HttpResponse<String> post(String url, String data) {
        var body = (data != null)
                ? HttpRequest.BodyPublishers.ofString(data)
                : HttpRequest.BodyPublishers.noBody();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(body)
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    private HttpResponse<String> get(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String encode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

}
