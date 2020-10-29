package com.chaserichards.budgetapplication.pages.budgetappcomponents;

import com.chaserichards.budgetapplication.pages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandler extends BasePage {
    public AlertHandler(WebDriver webDriver) { super(webDriver); }

    public String getAlertText() {
        String alertText;
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
            return alertText;
        } catch (Exception e) {
            return null;
        }
    }
}
