package com.daugherty.seleniumplayground.pages.google;

import com.daugherty.seleniumplayground.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class GoogleSearchResultsPage extends BasePage {

    public GoogleSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public GoogleSearchResultsPage waitUntilTitleExists(String pageTitle) {
        wait.until(ExpectedConditions.titleIs(pageTitle));
        return this;
    }

    public WebElement findLinkByText(String linkText) {
        return webDriver.findElement(By.partialLinkText(linkText));
    }

}
