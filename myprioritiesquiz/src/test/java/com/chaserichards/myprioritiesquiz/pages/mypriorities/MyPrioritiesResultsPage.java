package com.chaserichards.myprioritiesquiz.pages.mypriorities;

import com.chaserichards.myprioritiesquiz.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.HashMap;


public class MyPrioritiesResultsPage extends BasePage {
    public MyPrioritiesResultsPage(WebDriver webDriver) { super(webDriver); }

    //Return ResultsPage in case we need to do more checks on this page
    public MyPrioritiesResultsPage onResultsPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ResultsPage")));
        return this;
    }

    public MyPrioritiesResultsPage restartQuiz() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("restart-button"))).click();
        return this;
    }

    public MyPrioritiesResultsPage downloadResults() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("download-button"))).click();
        Thread.sleep(2000);
        return this;
    }

    public Boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    public MyPrioritiesHomePage goToHomePage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("WelcomePage")));

        return new MyPrioritiesHomePage(webDriver);
    }

}
