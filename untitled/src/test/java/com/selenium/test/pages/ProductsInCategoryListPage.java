package com.selenium.test.pages;

import com.selenium.test.utils.ActionBot;
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
 * Created by PLARPUR on 2017-05-20.
 */
public class ProductsInCategoryListPage extends BasePage {

    public ProductsInCategoryListPage() {
        super(false); //tutaj nie potrzeba URL, super to jest konstruktor
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return getDriver().findElement(By.cssSelector("div#content h2")).isDisplayed();
    }

    public ProductsInCategoryListPage addItemToCart(String itemName) {
        List<WebElement> containers = getDriver().findElements(By.className("product-layout"));   // struktura List będzie nam zwracać web elementy które zawierają containers

        for (WebElement container : containers) {  //dla każdego elementu (container) z listy container WebElement  jest to pętle for each
            System.out.println("Tytuł linka: " + container.getText()); // czyli za każdym przejściem pętli będzie wyświetlał tekst ze zmiennej container
            WebElement itemLink = container.findElement(By.cssSelector("h4 a")); //h4 a jest to CSS pobiera on tytuł h4 z produktów
            if (itemLink.getText().equals(itemName)) {  //jeśli itemLink jest równy itemName
                System.out.println("Klikam na: " + itemLink.getText());
                container.findElement(By.className("hidden-xs")).click();
                break; //to daje nam że jak za pierwszym razem znajdzie element i kliknie to funkcja for ma break czyli przerwanie

            }


        }
        return this;
    }
    public ProductsInCategoryListPage showCartItemList(){
        new ActionBot(getDriver()).waitForElemenetAndClickOnIt(By.id("cart-total"));
         //waitForElementAndClickOnIt(By.id("cart-total"));
//        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("cart-total"))).click();
        //getDriver().findElement(By.id("cart-total")).click();
        return this;
    }

    public CheckoutPage checkoutPage(){
       new ActionBot (getDriver()).waitForElemenetAndClickOnIt(By.cssSelector("div#cart i.fa-share")); //szuka css selector po atrybucie href z tekstem checkout
        return new CheckoutPage();
    }



}
