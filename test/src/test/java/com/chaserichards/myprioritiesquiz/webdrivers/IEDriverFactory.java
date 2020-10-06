package com.chaserichards.myprioritiesquiz.webdrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverFactory {
    static WebDriver getWebDriver() {
        WebDriverManager.iedriver().arch32().setup();
        return new InternetExplorerDriver();
    }
}
