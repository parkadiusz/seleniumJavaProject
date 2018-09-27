package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import com.sun.imageio.plugins.wbmp.WBMPImageWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

/**
 * Created by PLARPUR on 2017-05-21.
 */
public class CheckoutPage extends BasePage {

    public CheckoutPage(){
        super(false);
    }
    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion"))).isDisplayed();
    }


}
