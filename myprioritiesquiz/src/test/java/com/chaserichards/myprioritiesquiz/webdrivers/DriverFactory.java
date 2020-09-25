package com.chaserichards.myprioritiesquiz.webdrivers;

import org.openqa.selenium.WebDriver;

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
                System.out.println("Unable to start " + webBrowser + "defaulting to using Chrome");
                return ChromeDriverFactory.getWebDriver();
        }
    }
}
