package com.daugherty.seleniumplayground.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    static final int defaultTimeoutSeconds = 10;

    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                return ChromeDriverFactory.getDriver();
            case "firefox":
                return FirefoxDriverFactory.getDriver();
            case "ie":
                return InternetExplorerDriverFactory.getDriver();
            default:
                System.out.println("Cannot start " + browser + ", starting Chrome instead");
                return ChromeDriverFactory.getDriver();
        }
    }
}
