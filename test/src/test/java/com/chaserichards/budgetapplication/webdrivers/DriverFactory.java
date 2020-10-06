package com.chaserichards.budgetapplication.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public static WebDriver getWebDriver(String webBrowser) {
        switch(webBrowser) {
            case "chrome":
                return ChromeDriverFactory.getWebDriver();
            case "firefox":
                return FirefoxDriverFactory.getWebDriver();
            case "ie":
                return IEDriverFactory.getWebDriver();
            default:
                System.out.println("Unable to start " + webBrowser + " launching chrome instead.");
                return ChromeDriverFactory.getWebDriver();
        }
    }
}
