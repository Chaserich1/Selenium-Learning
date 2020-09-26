package com.daugherty.seleniumplayground.pages.google;

import com.daugherty.seleniumplayground.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends BasePage {

    public GoogleHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public GoogleHomePage go() {
        webDriver.get("http://www.google.com");
        return this;
    }

    public GoogleSearchResultsPage search(String searchString) {
        var searchBox = webDriver.findElement(By.name("q"));
        searchBox.sendKeys(searchString);
        searchBox.submit();

        return new GoogleSearchResultsPage(webDriver);
    }
}
