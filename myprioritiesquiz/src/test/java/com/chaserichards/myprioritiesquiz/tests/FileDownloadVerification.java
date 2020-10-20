package com.chaserichards.myprioritiesquiz.tests;

import com.chaserichards.myprioritiesquiz.pages.mypriorities.MyPrioritiesHomePage;
import com.chaserichards.myprioritiesquiz.pages.mypriorities.MyPrioritiesResultsPage;
import com.chaserichards.myprioritiesquiz.webdrivers.DriverFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownloadVerification {

    protected WebDriver driver;
    private static String downloadPath = "C:/seleniumdownloads";
    private MyPrioritiesHomePage homePage;

    @BeforeTest
    public void localSetup() throws Exception {
        //Arrange
        driver = DriverFactory.getWebDriver("chrome");
        homePage = new MyPrioritiesHomePage(driver);
    }

    @AfterTest
    public void localCleanup() {
        driver.quit();
    }

    @Test(description = "Test to confirm that download results on results page successfully downloads file")
    void downloadResults() throws InterruptedException {
        //Arrange
        MyPrioritiesResultsPage resultsPage = new MyPrioritiesResultsPage(driver);
        Boolean successfulDownload;

        //Act
        successfulDownload = homePage
                .navigateToMyPriorHomePage()
                .beginQuiz()
                .goToQuizPage()
                .chooseAnswer()
                .goToResultsPage()
                .onResultsPage()
                .downloadResults()
                .isFileDownloaded("C:\\Users\\cnr1103\\Downloads", "My Priorities Results.pdf");

        //Assert
        Assert.assertTrue(successfulDownload);
    }
}
