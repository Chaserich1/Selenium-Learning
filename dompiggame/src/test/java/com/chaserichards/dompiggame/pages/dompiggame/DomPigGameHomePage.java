package com.chaserichards.dompiggame.pages.dompiggame;

import com.chaserichards.dompiggame.pages.BasePage;
import org.openqa.selenium.WebDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DomPigGameHomePage extends BasePage {

    public DomPigGameHomePage(WebDriver webDriver) { super(webDriver); }

    public DomPigGameHomePage navigateToDomPigGameHomePage() {

        //Path p = Paths.get("index.html");
        //Path folder = p.getParent();

        webDriver.get("C:\\Users\\cnr1103\\GithubRepos\\Selenium-Learning\\dompiggame\\src\\main\\html\\index.html");
        return this;
    }
}
