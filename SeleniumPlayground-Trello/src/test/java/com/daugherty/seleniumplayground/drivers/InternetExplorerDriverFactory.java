package com.daugherty.seleniumplayground.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

class InternetExplorerDriverFactory {
    static WebDriver getDriver() {
        WebDriverManager.iedriver().arch32().setup();
        return new InternetExplorerDriver();
    }
}
