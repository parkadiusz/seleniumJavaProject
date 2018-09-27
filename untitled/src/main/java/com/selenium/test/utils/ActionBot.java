package com.selenium.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium.test.webtestsbase.WebDriverFactory.getDriver;

/**
 * Created by PLARPUR on 2017-05-21.
 */
public class ActionBot {

    private WebDriver driver; //nowa zmienna

    public ActionBot(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElemenetAndClickOnIt(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
